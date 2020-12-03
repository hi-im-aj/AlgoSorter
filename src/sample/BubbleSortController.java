package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BubbleSortController implements Initializable {
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private BarChart<String, Number> barChart;

    private int[] data;

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

    public void sort() {
        barChart.getData().clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.data = randomArray(10);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (int i = 0; i < this.data.length; i++) {
            series.getData().add(new XYChart.Data<>(Integer.toString(i + 1),this.data[i]));
        }

        barChart.setAnimated(false);
        barChart.getData().add(series);
    }
    public int[] randomArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        return arr;
    }
}

