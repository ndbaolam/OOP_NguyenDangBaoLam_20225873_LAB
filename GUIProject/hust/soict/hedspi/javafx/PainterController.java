import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRB;
    @FXML
    private RadioButton eraserRB;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = null;

        if (penRB.isSelected())
            color = Color.BLACK;
        else if (eraserRB.isSelected())
            color = Color.WHITE;

        Circle newCircle = new Circle(event.getX(),
                event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}