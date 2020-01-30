package sample.controller;

import com.exo.soap.service.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.config.Message;
import sample.config.Validator;
import utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.controller.PersonneController.selectedPersonne;

public class AddPersonneController implements Initializable {
    @FXML
    private TextField prenom_Tfd;

    @FXML
    private TextField nom_Tfd;

    @FXML
    private TextField telephone_Tfd;

    @FXML
    private TextArea adresse_Tar;

    @FXML
    private Button save_Btn;

    @FXML
    private Button edit_Btn;



    @FXML
    void handleEdit(ActionEvent event) {

        if("".equals(prenom_Tfd.getText().trim()) || "".equals(nom_Tfd.getText().trim()) || "".equals(telephone_Tfd.getText().trim())
                || "".equals(adresse_Tar.getText().trim())){
            Message.alerteWithoutHeaderText("Informations","Veuillez renseigner tous les champs!");
            return;
        }else{
            if(!Validator.isNomWhithWhiteEspace(prenom_Tfd.getText())){
                Message.alerteWithoutHeaderText("Informations","Format du prenom invalide!");
                return;
            }

            if(!Validator.isNomWhithWhiteEspace(nom_Tfd.getText())){
                Message.alerteWithoutHeaderText("Informations","Format du nom invalide!");
                return;
            }

            if(!Validator.isSenegaleseCallNumber(telephone_Tfd.getText())){
                Message.alerteWithoutHeaderText("Informations","Format du numero de telephone invalide!");
                return;
            }


            try {


                selectedPersonne.setNom(nom_Tfd.getText());
                selectedPersonne.setPrenom(prenom_Tfd.getText());
                selectedPersonne.setTelephone(telephone_Tfd.getText());
                selectedPersonne.setAdresse(adresse_Tar.getText());
                Utils utils = new Utils();
                if (utils.getPersonneService().updatePersonne(selectedPersonne.getId(),selectedPersonne)) {
                    Message.alerteWithoutHeaderText("Informations","Personne modifiée avec succès!");
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } else {
                    Message.alerteWithoutHeaderText("Informations","Une erreur est survenue!");
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

        }
    }
    @FXML
    void closePopup(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void handleSave(ActionEvent event) {

        if("".equals(prenom_Tfd.getText().trim()) || "".equals(nom_Tfd.getText().trim()) || "".equals(telephone_Tfd.getText().trim())
                || "".equals(adresse_Tar.getText().trim())){
            Message.alerteWithoutHeaderText("Informations","Veuillez renseigner tous les champs!");
            return;
        }else{
            if(!Validator.isNomWhithWhiteEspace(prenom_Tfd.getText())){
                Message.alerteWithoutHeaderText("Informations","Format du prenom invalide!");
                return;
            }

            if(!Validator.isNomWhithWhiteEspace(nom_Tfd.getText())){
                Message.alerteWithoutHeaderText("Informations","Format du nom invalide!");
                return;
            }

            if(!Validator.isSenegaleseCallNumber(telephone_Tfd.getText())){
                Message.alerteWithoutHeaderText("Informations","Format du numero de telephone invalide!");
                return;
            }


            try {

                Personne personne = new Personne();
                personne.setNom(nom_Tfd.getText());
                personne.setPrenom(prenom_Tfd.getText());
                personne.setTelephone(telephone_Tfd.getText());
                personne.setAdresse(adresse_Tar.getText());
                Utils utils = new Utils();
                if (utils.getPersonneService().addPersonne(personne)) {
                    Message.alerteWithoutHeaderText("Informations","Personne Ajoutée avec succès!");
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } else {
                    Message.alerteWithoutHeaderText("Informations","Une erreur est survenue!");
                }


            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(selectedPersonne!=null){
            nom_Tfd.setText(selectedPersonne.getNom());
            prenom_Tfd.setText(selectedPersonne.getPrenom());
            telephone_Tfd.setText(selectedPersonne.getTelephone());
            adresse_Tar.setText(selectedPersonne.getAdresse());
            save_Btn.setVisible(false);
            edit_Btn.setVisible(true);
        }else{
            nom_Tfd.setText("");
            prenom_Tfd.setText("");
            telephone_Tfd.setText("");
            adresse_Tar.setText("");
            save_Btn.setVisible(true);
            edit_Btn.setVisible(false);
        }



    }
}
