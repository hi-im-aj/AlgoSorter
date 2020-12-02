package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BubbleSortController {
    public void changeScreenToMain(ActionEvent e) throws IOException {
        Parent bubbleSortParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene bubbleSortScene = new Scene(bubbleSortParent);

        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.setScene(bubbleSortScene);
        window.show();
    }
    public void saveFile(ActionEvent e) {
        System.out.println("Save a file!");
    }
}

