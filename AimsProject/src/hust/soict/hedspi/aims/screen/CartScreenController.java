package hust.soict.hedspi.aims.screen;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Optional;
import java.util.function.Predicate;
import javax.swing.JFrame;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;
	private JFrame frame;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;

	@FXML
	private TextField tfFilter;
	@FXML
	private RadioButton radioBtnFilterId;
	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private Label lbTotalCost;
	@FXML
	private Button btnPlaceOrder;

	public CartScreenController(Cart cart, JFrame frame) {
		super();
		this.cart = cart;
		this.frame = frame;
	}

	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));

		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));

		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));

		tblMedia.setItems(this.cart.getItemsOrdered());
		lbTotalCost.setText(cart.totalCost() + "$");

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}
				});

		tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.equals("")) {
					tblMedia.setItems(cart.getItemsOrdered());
					return;
				}

				showFilteredMedia(newValue);
			}
		});

		cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
			@Override
			public void onChanged(Change<? extends Media> change) {
				lbTotalCost.setText(cart.totalCost() + "$");
			}
		});
	}

	private void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	private void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}

	@FXML
	private void btnPlayPressed(ActionEvent event) {
		Playable media = (Playable) tblMedia.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Playing");
		alert.setHeaderText(null);
		try {
			alert.setContentText(media.play());
		} catch (PlayerException e) {
			alert.setContentText(e.getMessage());
		}

		alert.showAndWait();
	}

	private void showFilteredMedia(String value) {
		Predicate<Media> filter = null;
		if (radioBtnFilterId.isSelected()) {
			filter = (m -> value.equals(String.valueOf(m.getId())));
		} else if (radioBtnFilterTitle.isSelected()) {
			filter = (m -> value.equals(m.getTitle()));
		}

		FilteredList<Media> filteredCartItems = new FilteredList<Media>(cart.getItemsOrdered(), filter);

		tblMedia.setItems(filteredCartItems);
	}

	@FXML
	private void btnPlaceOrderPressed(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Place Order");
		alert.setHeaderText(null);
		alert.setContentText("Do you want to place order this cart?\n\n" + cart);
		alert.setWidth(600);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent()) {
			if (result.get() == ButtonType.OK) {
				cart.emptyCart();

				Alert nextAlert = new Alert(AlertType.INFORMATION);

				nextAlert.setTitle("Thanks");
				nextAlert.setHeaderText(null);
				nextAlert.setContentText("Thank you for your confirmation!");

				nextAlert.showAndWait();
			}
		}

	}

	@FXML
	private void exitScreen(ActionEvent event) {
		WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
	}
}