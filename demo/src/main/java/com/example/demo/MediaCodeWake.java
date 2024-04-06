package com.example.demo;// Class AudioPlayer
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import java.io.File;


public class MediaCodeWake {
    MediaCodeWake (){
        filePath = "C:\\Users\\Admin\\Downloads\\ssstik.io_1710274642514.mp3";
    }
    private static String filePath;
    private MediaPlayer mediaPlayer;

    public static void setFilePath(String path) {
        filePath = path;
    }

    public void playMedia() {
        File file = new File(filePath);
        if (file.exists()) {
            javafx.scene.media.Media media = new javafx.scene.media.Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } else {
            System.out.println("File âm thanh không tồn tại.");
        }
    }

    public void setVolume(int volume) {
        mediaPlayer.setVolume(volume);
    }
}

