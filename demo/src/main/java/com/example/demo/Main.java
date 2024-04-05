package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.example.demo.Test;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("Window-View.fxml"));
        stage.setTitle("ProCodeWake");
        stage.setScene((new Scene(root, 341, 543)));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}