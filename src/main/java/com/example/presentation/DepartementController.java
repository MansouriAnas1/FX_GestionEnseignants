package com.example.presentation;

import com.example.dao.DepartementDao;
import com.example.dao.DepartementDaoImpl;
import com.example.dao.entities.Departement;
import com.example.dao.entities.Departement;
import com.example.services.DepartementService;
import com.example.services.DepartementServiceImpl;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DepartementController implements Initializable {
    @FXML
    private TextField textNom;

    @FXML
    ListView<Departement> listView;
    @FXML
    TableView<Departement> tableDepartement;
    @FXML
    TableColumn<Departement,Integer> colID;
    @FXML
    TableColumn<Departement,String> colNom;
    private ObservableList<Departement> observableList = FXCollections.observableArrayList();
    private DepartementService departementService;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        departementService =new DepartementServiceImpl(new DepartementDaoImpl());
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        observableList.clear();
        tableDepartement.setItems(observableList);
        loadDepartements();
    }

    public void addDepartement(ActionEvent actionEvent) throws SQLException {
        String nom=textNom.getText();

        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            Departement d = new Departement(nom,new ArrayList<>());
            departementService.addDepartement(d);
            observableList.add(d);
            textNom.clear();
        }
        loadDepartements();
    }

    public void deleteDepartement(ActionEvent actionEvent) throws SQLException {
        Departement e =tableDepartement.getSelectionModel().getSelectedItem();
        if(e!=null){
            departementService.deleteDepartement(e);
            loadDepartements();
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
    private void loadDepartements() {
        try {
        //    observableList.clear();
            observableList.addAll(departementService.getAllDepartements());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
