package com.example.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EnseignantApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TabPane root = FXMLLoader.load(getClass().getResource("main.fxml"));
      //  FXMLLoader fxmlLoader = new FXMLLoader(EnseignantApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Gestion des enseignants Anas Mansouri BDCC 2");
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}