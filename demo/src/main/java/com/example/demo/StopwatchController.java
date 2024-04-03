package com.example.demo;//package com.example.demo;
//
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//import java.text.DecimalFormat;
//
//public class StopwatchController {
//
//    @FXML
//    private Label timeLabel;
//
//    @FXML
//    private Button startButton;
//
//    @FXML
//    private Button stopButton;
//
//    @FXML
//    private Button resetButton;
//
//    private long startTime;
//    private boolean isRunning = false;
//
//    @FXML
//    void startTimer() {
//        if (!isRunning) {
//            startTime = System.currentTimeMillis();
//            isRunning = true;
//            startButton.setDisable(true);
//            stopButton.setDisable(false);
//            resetButton.setDisable(true);
//            updateTimer();
//        }
//    }
//
//    @FXML
//    void stopTimer() {
//        if (isRunning) {
//            isRunning = false;
//            startButton.setDisable(false);
//            stopButton.setDisable(true);
//            resetButton.setDisable(false);
//        }
//    }
//
//    @FXML
//    void resetTimer() {
//        timeLabel.setText("00:00:00");
//        startButton.setDisable(false);
//        stopButton.setDisable(true);
//        resetButton.setDisable(true);
//        isRunning = false;
//    }
//
//    private void updateTimer() {
//        DecimalFormat df = new DecimalFormat("00");
//        DecimalFormat millisFormat = new DecimalFormat("00");
//
//        new Thread(() -> {
//            while (isRunning) {
//                long elapsedTime = System.currentTimeMillis() - startTime;
//                long hours = elapsedTime / (60 * 60 * 1000);
//                long minutes = (elapsedTime / (60 * 1000)) % 60;
//                long seconds = (elapsedTime / 1000) % 60;
//                long millis = elapsedTime % 100;
//
//                String time = df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds) + ":" + millisFormat.format(millis);
//                Platform.runLater(() -> timeLabel.setText(time));
//
//                try {
//                    Thread.sleep(1); // Update every millisecond
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//}
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopwatchController {
    @FXML
    private Button Bam_Gio_Button;

    @FXML
    private Button Bao_thuc_Button;

    @FXML
    private Button Bat_Dau_Button;

    @FXML
    private BorderPane Border_Pane;

    @FXML
    private Button Cai_Dat_Button;

    @FXML
    private Button Dat_Lai_Button;

    @FXML
    private Button Lich_Hen_Button;

    @FXML
    private Button Luu_Thoi_Gian_Button;

    @FXML
    private Label Proptit_Label;

    @FXML
    private Button Tam_Dung_Button;

    @FXML
    private Button Them_Bao_Thuc_Button;

    @FXML
    private Button Them_Lich_Hen_Button;

    @FXML
    private Button Cap_Nhap_Button;

    @FXML
    private MenuButton Chon_Gio_MenuButton;

    @FXML
    private MenuButton Chon_Phut_MenuButton;

    @FXML
    private AnchorPane Cua_So_Them_Bao_Thuc;

    @FXML
    private Button Huy_Button;

    @FXML
    private ListView<String> Danh_Sach_Bao_Thuc_ListView;

    @FXML
    private Label Thoi_Gian_Bam_Gio_Label;

    @FXML
    private ListView<String> Bam_Gio_ListView; // Thêm ListView này

    private Timeline timeline;
    private long startTime;
    private boolean isRunning = false;
    private int lapCount = 0;
    private List<String> lapTimes = new ArrayList<>(); // Danh sách các lap time

    @FXML
    void Hien_Thi_Cua_So_Bam_Gio(ActionEvent event) throws IOException {
        AnchorPane view_2 = FXMLLoader.load(getClass().getResource("BamGio_View.fxml"));
        Border_Pane.setCenter(view_2);
        Bat_Dau_Button.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
    }

    @FXML
    void Chuc_Nang_Bat_Dau(ActionEvent event) {
        Bat_Dau_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(true);
        Tam_Dung_Button.setVisible(true);
        if (!isRunning) {
            startTimer();
        }
    }

    @FXML
    void Chuc_Nang_Dat_Lai(ActionEvent event) {
        Dat_Lai_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Tam_Dung_Button.setVisible(false);
        Bat_Dau_Button.setVisible(true);
        Thoi_Gian_Bam_Gio_Label.setText("00:00:00");
        Bam_Gio_ListView.getItems().clear(); // Xóa danh sách lap time khi đặt lại
        lapTimes.clear();
        if (timeline != null) {
            timeline.stop();
            timeline = null;
        }
        isRunning = false;
        lapCount = 0;
    }

    @FXML
    void Chuc_Nang_Tam_Dung(ActionEvent event) {
        Tam_Dung_Button.setVisible(false);
        Bat_Dau_Button.setVisible(true);
        Dat_Lai_Button.setVisible(true);
        timeline.pause();
        isRunning = false;
    }

    private void startTimer() {
        startTime = System.currentTimeMillis();
        timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            long now = System.currentTimeMillis();
            long elapsedTime = now - startTime;
            String time = formatTime(elapsedTime);
            Thoi_Gian_Bam_Gio_Label.setText(time);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        isRunning = true;
    }

    private String formatTime(long elapsedTime) {
        long hours = elapsedTime / (1000 * 60 * 60);
        long mins = (elapsedTime / (1000 * 60)) % 60;
        long secs = (elapsedTime / 1000) % 60;
        long millis = (elapsedTime % 1000) / 10;
        return String.format("%02d:%02d:%02d.%02d", hours, mins, secs, millis);
    }

    @FXML
    void Chay_Chuc_Nang_Luu_Thoi_Gian(ActionEvent event) {
        // Lưu thời gian vào ListView và danh sách lap time
        lapCount++;
        String lapTime = Thoi_Gian_Bam_Gio_Label.getText();
        lapTimes.add(lapTime);
        Bam_Gio_ListView.getItems().add("Lap " + lapCount + ": " + lapTime);
    }

    // Các phương thức khác không thay đổi
}
