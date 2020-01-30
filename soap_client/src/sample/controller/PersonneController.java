package sample.controller;

import com.exo.soap.service.Personne;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import sample.config.Message;
import sample.config.Rooting;
import sample.config.StringMessage;
import utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static javafx.fxml.FXMLLoader.load;
import static sample.config.StringMessage.ERROR;

public class PersonneController implements Initializable {
    @FXML
    private TableView<Personne> tablePersonne;

    @FXML
    private TableColumn<Personne, String> prenom_column;

    @FXML
    private TableColumn<Personne, String> nom_column;

    @FXML
    private TableColumn<Personne, String> telephone_column;

    @FXML
    private TableColumn<Personne, String> adresse_column;

    @FXML
    private TableColumn<Personne, String> edit_coulmn;

    @FXML
    private TableColumn<Personne, String> delete_column;

    @FXML
    private TextField search_Tfd;

    private ObservableList<Personne> listPersonne;

    private FilteredList<Personne> filteredData;

    public static Personne selectedPersonne = null;



    @FXML
    void addPersonne(ActionEvent event) {

        Stage stage = new Stage();
        Parent root = null;
        try {
            root = load(getClass().getResource(Rooting.ADDPERSONNE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.setTitle("-=- SOAP Client FX | Ajouter une personne -=-");
        stage.initModality(Modality.WINDOW_MODAL);


        stage.centerOnScreen();

        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();

        stage.setOnHidden((e) -> {
            this.cellValueFactory();
            this.loadData();

        });




    }

    private void cellValueFactory() {
        ///////////////////////////////////////////////////////////////////////////////////
        ///INITIALISATION DES COLONNES DU TABLEVIEW


        prenom_column.setCellValueFactory((TableColumn.CellDataFeatures<Personne, String> parametre) -> {
            Personne p = parametre.getValue();
            return Bindings.createStringBinding(() -> p.getPrenom() );
        });

        nom_column.setCellValueFactory((TableColumn.CellDataFeatures<Personne, String> parametre) -> {
            Personne p = parametre.getValue();
            return Bindings.createStringBinding(() -> p.getNom() );
        });

        telephone_column.setCellValueFactory((TableColumn.CellDataFeatures<Personne, String> parametre) -> {
            Personne p = parametre.getValue();
            return Bindings.createStringBinding(() -> p.getTelephone());
        });

        adresse_column.setCellValueFactory((TableColumn.CellDataFeatures<Personne, String> parametre) -> {
            Personne p = parametre.getValue();
            return Bindings.createStringBinding(() -> p.getAdresse() );
        });


        Callback<TableColumn<Personne, String>, TableCell<Personne, String>> removeFactory
                = //
                new Callback<TableColumn<Personne, String>, TableCell<Personne, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Personne, String> param) {
                        final TableCell<Personne, String> cell = new TableCell<Personne, String>() {

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    final JFXButton btn = new JFXButton();
                                    FontAwesomeIcon icon = new FontAwesomeIcon();
                                    icon.setIcon(FontAwesomeIconName.TRASH);
                                    icon.setSize("1.5em");
                                    btn.setId("deleteButton");
                                    btn.setGraphic(icon);
                                    btn.setTooltip(new Tooltip("Supprimer cette personne"));
                                    btn.setOnAction(event -> {
                                        try {
                                            Personne a = getTableView().getItems().get(getIndex());

                                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                            alert.setTitle("Informations");
                                            alert.setHeaderText("Vous êtes sur le point de supprimer");
                                            alert.setContentText("Etes-vous d'accord?");
                                            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();


                                            Optional<ButtonType> result = alert.showAndWait();
                                            if (result.get() == ButtonType.OK){
                                                try {

                                                    Utils utils = new Utils();
                                                    Personne personne = getTableView().getItems().get(getIndex());
                                                    if (utils.getPersonneService().deletePersonne(personne.getId())) {
                                                        Message.alerteWithoutHeaderText(StringMessage.SUCCESS,StringMessage.OPERATIONSUCCESS);
                                                        refreshTableView();

                                                    } else {

                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();

                                                }
                                            } else {
                                                // ... user chose CANCEL or closed the dialog
                                            }
                                        }catch (Exception ex){

                                        }




                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };


        Callback<TableColumn<Personne, String>, TableCell<Personne, String>> editFactory
                =
                new Callback<TableColumn<Personne, String>, TableCell<Personne, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Personne, String> param) {
                        final TableCell<Personne, String> cell = new TableCell<Personne, String>() {

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    final JFXButton btn = new JFXButton();
                                    FontAwesomeIcon icon = new FontAwesomeIcon();
                                    icon.setIcon(FontAwesomeIconName.EDIT);
                                    icon.setSize("1.5em");
                                    btn.setId("editButton");
                                    btn.setGraphic(icon);
                                    btn.setTooltip(new Tooltip("Modifier cette personne"));
                                    btn.setOnAction(event -> {
                                        selectedPersonne = getTableView().getItems().get(getIndex());

                                        Stage stage = new Stage();
                                        Parent root = null;
                                        try {
                                            root = load(getClass().getResource(Rooting.ADDPERSONNE));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        stage.setScene(new Scene(root));
                                        stage.setTitle("-=- SOAP Client FX | Ajout / Modification -=-");
                                        stage.initModality(Modality.WINDOW_MODAL);


                                        stage.centerOnScreen();

                                        stage.initOwner(
                                                ((Node) event.getSource()).getScene().getWindow());
                                        stage.show();

                                        stage.setOnHidden((e) -> {
                                            cellValueFactory();
                                            loadData();
                                            selectedPersonne = null;

                                        });

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        delete_column.setCellFactory(removeFactory);
        edit_coulmn.setCellFactory(editFactory);

    }

    private void refreshTableView() {
        this.cellValueFactory();
        this.loadData();
    }

    public void loadData(){
        this.listPersonne = FXCollections.observableArrayList();
        Utils utils = new Utils();
        this.listPersonne.addAll(utils.getPersonneService().personneList());
        filteredData = new FilteredList<>(this.listPersonne,u -> true);
        this.tablePersonne.setItems(this.listPersonne);


    }

    @FXML
    void filterByReference(KeyEvent event) {
        search_Tfd.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Personne>) (Personne p) -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;

                } else if (p.getPrenom().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }else if(p.getNom().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }else if(p.getTelephone().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Personne> liste = new SortedList<>(filteredData);
        liste.comparatorProperty().bind(tablePersonne.comparatorProperty());
        tablePersonne.setItems(liste);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.cellValueFactory();
            this.loadData();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
