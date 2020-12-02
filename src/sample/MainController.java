package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public void changeScreenToBubbleSort(ActionEvent e) throws IOException {
        Parent bubbleSortParent = FXMLLoader.load(getClass().getResource("BubbleSort.fxml"));
        Scene bubbleSortScene = new Scene(bubbleSortParent);

        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.setScene(bubbleSortScene);
        window.show();
    }
    public void exit(ActionEvent e) {
        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.close();
    }
}
