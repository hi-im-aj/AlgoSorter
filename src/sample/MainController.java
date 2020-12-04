package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class MainController implements Initializable {
    @FXML
    private Label lastVisitLabel;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            if(new File("DateLog.txt").exists()) {
                BufferedReader reader = new BufferedReader(new FileReader("./DateLog.txt"));
                String line = reader.readLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date firstDate = sdf.parse(line);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                Date secondDate = sdf.parse(date);
                long diffInMillis = Math.abs(secondDate.getTime() - firstDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
                if(diff == 0) {
                    lastVisitLabel.setText("Your last visit was today!");
                } else lastVisitLabel.setText(String.format("Your last visit was %s days ago!", diff));
            }

            try (PrintWriter out = new PrintWriter("DateLog.txt")) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = dtf.format(now);
                out.println(date);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
