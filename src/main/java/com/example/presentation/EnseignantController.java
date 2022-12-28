package com.example.presentation;

import com.example.dao.EnseignantDaoImpl;
import com.example.dao.entities.Departement;
import com.example.dao.entities.Enseignant;
import com.example.services.EnseignantService;
import com.example.services.EnseignantServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EnseignantController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;
    @FXML
    private TextField textAdresse;
    @FXML
    private TextField textTelephone;
    @FXML
    private ComboBox<Enseignant> textDepartement;
    @FXML
    private TableView<Enseignant> tableEnseignant;
    @FXML
    TableColumn<Enseignant,String> colNom;
    @FXML
    TableColumn<Enseignant,String> colPrenom;
    @FXML
    TableColumn<Enseignant,String> colAdresse;
    @FXML
    TableColumn<Enseignant,String> colTelephone;
    @FXML
    TableColumn<Enseignant,Departement> colDepartement;
  //  @FXML
 //   ListView<Enseignant> listView;
    private ObservableList<Enseignant> observableList = FXCollections.observableArrayList();
    private EnseignantService enseignantService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            enseignantService =new EnseignantServiceImpl(new EnseignantDaoImpl());
            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            colDepartement.setCellValueFactory(new PropertyValueFactory<>("departement"));
            tableEnseignant.setItems(observableList);
    //        tableEnseignant.setItems(observableList);
        try {
            loadEnseignants();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addEnseignant(ActionEvent actionEvent) throws SQLException {
        String nom=textNom.getText();
        String prenom=textPrenom.getText();
        String adresse=textAdresse.getText();
        String telephone=textTelephone.getText();
        int id = Integer.parseInt(textDepartement.getPromptText());
        Departement departement = new Departement();
        departement.setNom(textDepartement.getPromptText());
        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            Enseignant e = new Enseignant(nom,prenom,adresse,telephone,departement);
            e.getDepartement().setId(id);
            enseignantService.addEnseignant(e);
                 observableList.add(e);

            textNom.clear();
        }
     //   loadEnseignants();

    }

    public void deleteEnseignant(ActionEvent actionEvent) throws SQLException {
        Enseignant e =tableEnseignant.getSelectionModel().getSelectedItem();
        if(e!=null){
            enseignantService.deleteEnseignant(e);
            loadEnseignants();
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément !!");
            alert.show();
        }

        textNom.clear();
    }

    public void fillField(MouseEvent mouseEvent) {
        //   textNom.setText(listView.getSelectionModel().getSelectedItem());
    }
    private void loadEnseignants() throws SQLException {
            observableList.clear();
            observableList.addAll(enseignantService.getAllEnseignants());

    }


}