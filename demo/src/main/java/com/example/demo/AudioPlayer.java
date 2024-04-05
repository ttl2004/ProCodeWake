package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer extends Application {

    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {
        // Tạo một nút để chọn file âm thanh
        Button selectButton = new Button("Chọn file âm thanh");

        // Sự kiện khi nút được nhấn
        selectButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Chọn file âm thanh");
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                playAudio(file);
            }
        });

        VBox root = new VBox();
        root.getChildren().add(selectButton);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Phát âm thanh");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Phát âm thanh từ file
    private void playAudio(File file) {
        try {
            Media media = new Media(file.toURI().toURL().toString());
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
