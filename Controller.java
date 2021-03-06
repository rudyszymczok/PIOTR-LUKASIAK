package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Controller implements Initializable {
    public void nowaGraPushed(ActionEvent event) throws IOException
    {

        //Parent nowaGraParent = FXMLLoader.load(getClass().getResource("gra.fxml"));
        //Scene nowaGraScene = new Scene(nowaGraParent);
        Plansza root = new Plansza();
        Pane board = new Pane();
        board = (Pane) root.init();
        Scene nowaGraScene = new Scene(board);
        Stage nowaGraWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        nowaGraWindow.setScene(nowaGraScene);
        nowaGraWindow.show();
    }
    public void opcjePushed(ActionEvent event) throws IOException
    {
        Parent opcjeParent = FXMLLoader.load(getClass().getResource("opcje.fxml"));
        Scene opcjeScene = new Scene(opcjeParent);
        Stage opcjeWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        opcjeWindow.setScene(opcjeScene);
        opcjeWindow.show();
    }
    public void wyjsciePushed()
    {
        exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}
