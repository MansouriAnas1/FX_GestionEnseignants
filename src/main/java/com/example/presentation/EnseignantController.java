package com.example.presentation;

import com.example.dao.EnseignantDao;
import com.example.dao.EnseignantDaoImpl;
import com.example.dao.entities.Enseignant;
import com.example.services.EnseignantService;
import com.example.services.EnseignantServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
    ListView<Enseignant> listView;
    private ObservableList<Enseignant> observableList = FXCollections.observableArrayList();
    private EnseignantService enseignantService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enseignantService =new EnseignantServiceImpl(new EnseignantDaoImpl());
        listView.setItems(observableList);
        loadEnseignants();
    }

    public void addEnseignant(ActionEvent actionEvent) {
        String nom=textNom.getText();
//        String prenom=textPrenom.getText();
//        String adresse=textAdresse.getText();
//        String telephone=textTelephone.getText();
        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            //     observableList.add(new Enseignant(nom,prenom,adresse,telephone));
            textNom.clear();
        }
    }

    public void deleteEnseignant(ActionEvent actionEvent) throws SQLException {
        Enseignant e =listView.getSelectionModel().getSelectedItem();
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
    private void loadEnseignants() {
        try {
            observableList.clear();
            observableList.addAll(enseignantService.getAllEnseignants());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}