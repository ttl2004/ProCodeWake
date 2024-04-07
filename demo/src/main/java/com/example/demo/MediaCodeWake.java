package com.example.demo;// Class AudioPlayer
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import java.io.File;


public class MediaCodeWake {
    //Nhạc mặc định mink để ở đường dẫn file trong máy mik, nên bạn muốn cài nhạc mạc định chỉ cần viết đường dẫn vào dưới đây
    MediaCodeWake (){
        filePath = "C:\\Users\\Admin\\Downloads\\ssstik.io_1710274642514.mp3";
        //media = new javafx.scene.media.Media(new File(filePath).toURI().toString());
    }
    private static String filePath;
    private MediaPlayer mediaPlayer;
    private javafx.scene.media.Media media;

    public static void setFilePath(String path) {
        filePath = path;
    }

    public void playMedia() {
        File file = new File(filePath);
        if (file.exists()) {
            media = new javafx.scene.media.Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } else {
            System.out.println("File âm thanh không tồn tại.");
        }
    }

    public void setVolume(int volume) {
        mediaPlayer.setVolume(volume);
    }

    public void stopMedia() {
        mediaPlayer.stop();
    }
}

