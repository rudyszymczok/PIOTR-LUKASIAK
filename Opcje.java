package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Opcje implements Initializable {


    @FXML private CheckBox bialyCheckbox;
    @FXML private CheckBox niebieskiCheckbox;
    @FXML private CheckBox czerwonyCheckbox;
    @FXML private ChoiceBox trybGry;

    public Setup setup = new Setup("#000035",7);

    @FXML
    private void bialyCheckboxChecked(ActionEvent actionEvent) throws IOException{
        setup.setKolory("#f5f5f5");
        niebieskiCheckbox.setSelected(false);
        czerwonyCheckbox.setSelected(false);
        bialyCheckbox.setSelected(true);
    }
    @FXML
    private void niebieskiCheckboxChecked(ActionEvent actionEvent) throws IOException{
        setup.setKolory("#ff0000");
        bialyCheckbox.setSelected(false);
        czerwonyCheckbox.setSelected(false);
        niebieskiCheckbox.setSelected(true);
    }
    @FXML
    private void czerwonyCheckboxChecked(ActionEvent actionEvent) throws IOException{
        setup.setKolory("#0000ff");
        niebieskiCheckbox.setSelected(false);
        czerwonyCheckbox.setSelected(true);
        bialyCheckbox.setSelected(false);
    }

    @FXML
    public void dodajTryby()
    {
        trybGry.getItems().add("5");
        trybGry.getItems().add("7");
        trybGry.getItems().add("9");
    }

    @FXML
    private void rozmiarChosen(ActionEvent actionEvent) throws IOException{

        int a = (int) trybGry.getValue();
        setup.setRozmiar(a);

    }


    public void applyPushed(ActionEvent event) throws IOException
    {
        Parent menuParent = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage menuWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        menuWindow.setScene(menuScene);
        menuWindow.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dodajTryby();
    }

}
class Setup{
    String kolor;
    int rozmiar;

    public Setup(String kolor,int rozmiar){
        this.kolor=kolor;
        this.rozmiar=rozmiar;
    }

    public void setKolory(String kolor) { this.kolor = kolor; }

    public void setRozmiar(int rozmiar) { this.rozmiar = rozmiar; }
}
