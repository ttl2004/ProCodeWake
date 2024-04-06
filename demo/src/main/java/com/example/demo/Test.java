package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Test{


    @FXML
    private Button Bam_Gio_Button;

    @FXML
    private Button Bao_thuc_Button;

    @FXML
    private Button Bat_Dau_Button;
    @FXML
    private Button Tiep_Tuc_Button;
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
    private Button Tam_Dung_Button;

    @FXML
    private Button Them_Bao_Thuc_Button;

    @FXML
    private Button Them_Lich_Hen_Button;
    @FXML
    private Button Huy_Dat_Lich_Hen_Button;
    @FXML
    private Button Cap_Nhap_Button;
    @FXML
    private Button Cap_Nhap_Lich_Hen_Button;

    @FXML
    private MenuButton Chon_Gio_Lich_Hen_MenuBtton;
    @FXML
    private MenuButton Chon_Phut_Lich_Hen_MenuButton;
    @FXML
    private Button Am_Luong_Nhac_Chuong_Button;
    @FXML
    private Button Nhac_Chuong_Bao_Thuc_Button;
    @FXML
    private Button Thoi_Gian_Tu_Tat_Bao_Thuc_Button;

    @FXML
    private ComboBox Chon_Gio_ComboBox;

    @FXML
    private ComboBox Chon_Phut_ComboBox;

    @FXML
    private Button Huy_Button;
    @FXML
    private Button Nop_Button;
    @FXML
    private Label Gio_Va_Phut_Lich_Hen_Label;
    @FXML
    private Label ProCodeWake_Label;
    @FXML
    private Label Am_Luong_Label;
    @FXML
    private Label Cau_Hoi_Label;
    @FXML
    private Label Cau_Tra_Loi_Label;
    @FXML
    private Label Gio_Bao_Thuc_Label;
    @FXML
    private Label Phut_Bao_Thuc_Label;
    @FXML
    private Label Ky_Tu_Label;
    @FXML
    private Label Thoi_Gian_Bam_Gio_Label;

    @FXML
    private ListView<String> Bam_Gio_List_View;

    @FXML
    private ListView<HBox> Bao_Thuc_List_View;
    @FXML
    private ListView<HBox> Lich_Hen_List_View;
    @FXML
    private TextField Cau_Hoi_Cho_Bao_Thuc_TexField;
    @FXML
    private TextField Cau_Tra_Loi_Bao_Thuc_TextField;

    @FXML
    private TextField Cau_Tra_Loi_TextField;
    @FXML
    private Slider Thanh_Am_Luong_Slider;
    @FXML
    private AnchorPane Cua_So_Cau_Tra_Loi_AnchorPane;

    //Bắt Đầu dòng code của phần controller và logic của Bấm giờ
    private Timeline timeline;
    private long startTime;
    private boolean isRunning = false;
    private int lapCount = 0;
    void Reset() {
        Thoi_Gian_Bam_Gio_Label.setText("00:00:00:00");
        Bam_Gio_List_View.getItems().clear(); // Xóa danh sách lap time khi đặt lại
        if (timeline != null) {
            timeline.stop();
            timeline = null;
        }
        isRunning = false;
        lapCount = 0;
    }
    @FXML
    void Hien_Thi_Cua_So_Bam_Gio(ActionEvent event) {
        Thoi_Gian_Bam_Gio_Label.setVisible(true);
        Bam_Gio_List_View.setVisible(true);
        Bat_Dau_Button.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
        Bao_Thuc_List_View.setVisible(false);
        Cap_Nhap_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Chon_Gio_ComboBox.setVisible(false);
        Chon_Phut_ComboBox.setVisible(false);
        Huy_Button.setVisible(false);
        Gio_Bao_Thuc_Label.setVisible(false);
        Phut_Bao_Thuc_Label.setVisible(false);
        Ky_Tu_Label.setVisible(false);
        Thoi_Gian_Tu_Tat_Bao_Thuc_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Gio_Va_Phut_Lich_Hen_Label.setVisible(false);
        Chon_Gio_Lich_Hen_MenuBtton.setVisible(false);
        Chon_Phut_Lich_Hen_MenuButton.setVisible(false);
        Huy_Dat_Lich_Hen_Button.setVisible(false);
        Cap_Nhap_Lich_Hen_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Cau_Hoi_Label.setVisible(false);
        Cau_Tra_Loi_Label.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
    }
    @FXML
    void Chay_Chuc_Nang_Luu_Thoi_Gian(ActionEvent event) {
        lapCount++;
        String lapTime = Thoi_Gian_Bam_Gio_Label.getText();
        Bam_Gio_List_View.getItems().add("Lần " + lapCount + ": " + lapTime);
    }
    @FXML
    void Chuc_Nang_Bat_Dau(ActionEvent event) {
        Bat_Dau_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(true);
        Tam_Dung_Button.setVisible(true);
        Dat_Lai_Button.setVisible(true);
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
        Thoi_Gian_Bam_Gio_Label.setText("00:00:00:00");
        Bam_Gio_List_View.getItems().clear(); // Xóa danh sách lap time khi đặt lại
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
        Tiep_Tuc_Button.setVisible(true);
        Dat_Lai_Button.setVisible(true);
        Luu_Thoi_Gian_Button.setVisible(false);
        timeline.pause();
        isRunning = false;
    }
    @FXML
    void Chuc_Nang_Tiep_Tuc(ActionEvent event) {
        Tiep_Tuc_Button.setVisible(false);
        Tam_Dung_Button.setVisible(true);
        Luu_Thoi_Gian_Button.setVisible(true);
        timeline.play();
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
    //Kết thúc dòng code Controller và logic của Bấm Giờ


    //Bắt đầu dòng code Controller và logic của Báo Thức
    private int So_Thu_Tu = 0;
    private int cnt = 0;
    private String string;
    private String Cau_Hoi;
    private String Cau_Tra_Loi;
    private Timeline alarmTimeline;
    private ArrayList<Pair<String, String>> Danh_Sach_Cau_Hoi = new ArrayList<>();
    private MediaCodeWake mediaCodeWake = new MediaCodeWake();
    void Khoi_Tao() {
        //Thêm lựa chọn giờ báo thức
        ObservableList<String> items_1 = FXCollections.observableArrayList();
        for (int i = 0; i <= 23; i++) {
            if (i < 10) items_1.add("0" + i);
            else items_1.add(""+ i);
        }
        Chon_Gio_ComboBox.setItems(items_1);
        //Thêm lựa chọn phút báo thức
        ObservableList<String> items_2 = FXCollections.observableArrayList();
        Chon_Phut_ComboBox.setItems(items_2);
        for (int i = 0; i <= 59; i ++) {
            if (i < 10) items_2.add("0" + i);
            else items_2.add(""+ i);
        }
        Chon_Phut_ComboBox.setItems(items_2);
    }
    @FXML
    void Hien_Thi_Cua_So_Bao_Thuc(ActionEvent event) {
        Bao_Thuc_List_View.setVisible(true);
        Them_Lich_Hen_Button.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(true);
        Bat_Dau_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Tam_Dung_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Thoi_Gian_Bam_Gio_Label.setVisible(false);
        Bam_Gio_List_View.setVisible(false);
        Thoi_Gian_Tu_Tat_Bao_Thuc_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Gio_Va_Phut_Lich_Hen_Label.setVisible(false);
        Chon_Gio_Lich_Hen_MenuBtton.setVisible(false);
        Chon_Phut_Lich_Hen_MenuButton.setVisible(false);
        Huy_Dat_Lich_Hen_Button.setVisible(false);
        Cap_Nhap_Lich_Hen_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Cau_Hoi_Label.setVisible(false);
        Cau_Tra_Loi_Label.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Reset();
    }
    @FXML
    void Hien_Thi_Cua_So_Them_Bao_Thuc(ActionEvent event) {
        Bao_Thuc_List_View.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(false);
        Cap_Nhap_Button.setVisible(true);
        Chon_Gio_ComboBox.setVisible(true);
        Chon_Phut_ComboBox.setVisible(true);
        Huy_Button.setVisible(true);
        Gio_Bao_Thuc_Label.setVisible(true);
        Phut_Bao_Thuc_Label.setVisible(true);
        Ky_Tu_Label.setVisible(true);
        Cau_Hoi_Label.setVisible(true);
        Cau_Tra_Loi_Label.setVisible(true);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(true);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(true);
        string = "";
        Khoi_Tao();
    }
    @FXML
    void Chuc_Nang_Cua_Huy_Button(ActionEvent event)  {
        Bao_Thuc_List_View.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(true);
        Cap_Nhap_Button.setVisible(false);
        Chon_Gio_ComboBox.setVisible(false);
        Chon_Phut_ComboBox.setVisible(false);
        Huy_Button.setVisible(false);
        Gio_Bao_Thuc_Label.setVisible(false);
        Phut_Bao_Thuc_Label.setVisible(false);
        Ky_Tu_Label.setVisible(false);
        Cau_Hoi_Label.setVisible(false);
        Cau_Tra_Loi_Label.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        StartAlarmClock();
    }
    @FXML
    void Chuc_Nang_Cua_Cap_Nhap_Button(ActionEvent event)  {
        Bao_Thuc_List_View.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(true);
        Cap_Nhap_Button.setVisible(false);
        Chon_Gio_ComboBox.setVisible(false);
        Chon_Phut_ComboBox.setVisible(false);
        Huy_Button.setVisible(false);
        Gio_Bao_Thuc_Label.setVisible(false);
        Phut_Bao_Thuc_Label.setVisible(false);
        Ky_Tu_Label.setVisible(false);
        Cau_Hoi_Label.setVisible(false);
        Cau_Tra_Loi_Label.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        Chon_Gio_ComboBox.getSelectionModel().clearSelection();
        Chon_Phut_ComboBox.getSelectionModel().clearSelection();
        HBox hBox = new HBox();
        Button button1 = new Button("Xoá");
        Label Thoi_Gian_Bao_Thuc = new Label();
        Label STT;
        Cau_Hoi = Cau_Hoi_Cho_Bao_Thuc_TexField.getText();
        Cau_Tra_Loi = Cau_Tra_Loi_Bao_Thuc_TextField.getText();
        if (string.length() == 5 && Cau_Hoi.length() > 0 && Cau_Tra_Loi.length() > 0) {
            Thoi_Gian_Bao_Thuc.setText(string);
            So_Thu_Tu ++;
            STT = new Label(String.valueOf(So_Thu_Tu) + ".    ");
            System.out.println(Cau_Hoi + " " + Cau_Tra_Loi);
        }
        else {
            return;
        }
        hBox.getChildren().addAll(STT, Thoi_Gian_Bao_Thuc, button1);
        Thoi_Gian_Bao_Thuc.setMaxWidth(Double.MAX_VALUE);
        hBox.setHgrow(Thoi_Gian_Bao_Thuc, Priority.ALWAYS);
        // Thêm ClickListener vào nút "Xoá"
        button1.setOnAction(event1 -> {
            Bao_Thuc_List_View.getItems().remove(hBox);
        });
        Bao_Thuc_List_View.getItems().add(hBox);
        //Cập nhập câu hỏi để tắt báo thức
        Danh_Sach_Cau_Hoi.add(new Pair<>(Cau_Hoi, Cau_Tra_Loi));
        string = "";
        Cau_Hoi_Cho_Bao_Thuc_TexField.clear();
        Cau_Tra_Loi_Bao_Thuc_TextField.clear();
        StartAlarmClock();
    }
    @FXML
    void Chon_Gio_Bao_Thuc(ActionEvent event) {
        Object selectedItem = Chon_Gio_ComboBox.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String str = selectedItem.toString();
            string = string + str + ":";
        }
    }

    @FXML
    void Chon_Phut_Bao_Thuc(ActionEvent event) {
        Object selectedItem = Chon_Phut_ComboBox.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String str = selectedItem.toString();
            string = string + str;
        }
    }
     private int Check(String s) {
        //Lấy thời gian từ hệ thống
         LocalDateTime localDateTime = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
         String dateString = localDateTime.format(formatter);
        // So sánh thời gian
        if (s.equals(dateString)) return 1;
        else return 0;
    }
    private void show_Cua_So_Cau_Hoi(Pair<String, String> pair){
        Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(true);
    }
    private void StartAlarmClock() {
        //Tạo một timeline kiểm tra mỗi phút
        alarmTimeline = new Timeline(new KeyFrame(Duration.minutes(1), event -> {
            int len = Bao_Thuc_List_View.getItems().size();
            for (int i = 0; i < len; i ++) {
                HBox hBox = Bao_Thuc_List_View.getItems().get(i);
                Label tmp = (Label) hBox.getChildren().get(1);
                String alrmTime = tmp.getText();
                if (Check(alrmTime) == 1){
                    System.out.println("hello");
                    cnt = cnt + 1;
                    mediaCodeWake.playMedia();
                    Pair<String, String> pair = Danh_Sach_Cau_Hoi.get(i);
                    Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(true);
                    break;
                }
                else if (cnt > 0){
                    System.out.println("oki");
                    cnt = 0;
                }
            }
        }));
        alarmTimeline.setCycleCount(Animation.INDEFINITE);
        alarmTimeline.play();
    }
    //Kết thúc dòng code Controller và logic của Báo Thức


    //Bắt đầu dòng code Controller và logic của Cài Đặt
    public static int number;
    @FXML
    void Hien_Thi_Cua_So_Cai_Dat(ActionEvent event) {
        Thoi_Gian_Tu_Tat_Bao_Thuc_Button.setVisible(true);
        Am_Luong_Nhac_Chuong_Button.setVisible(true);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(true);
        Thoi_Gian_Bam_Gio_Label.setVisible(false);
        Bam_Gio_List_View.setVisible(false);
        Bat_Dau_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
        Bao_Thuc_List_View.setVisible(false);
        Cap_Nhap_Button.setVisible(false);
        Chon_Gio_ComboBox.setVisible(false);
        Chon_Phut_ComboBox.setVisible(false);
        Huy_Button.setVisible(false);
        Gio_Bao_Thuc_Label.setVisible(false);
        Phut_Bao_Thuc_Label.setVisible(false);
        Ky_Tu_Label.setVisible(false);
        Gio_Va_Phut_Lich_Hen_Label.setVisible(false);
        Chon_Gio_Lich_Hen_MenuBtton.setVisible(false);
        Chon_Phut_Lich_Hen_MenuButton.setVisible(false);
        Huy_Dat_Lich_Hen_Button.setVisible(false);
        Cap_Nhap_Lich_Hen_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Tam_Dung_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Cau_Hoi_Label.setVisible(false);
        Cau_Tra_Loi_Label.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Reset();
    }
    @FXML
    void Cai_Dat_Nhac_Chuong_Bao_Thuc(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chọn file âm thanh");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Cập nhật đường dẫn file vào class MediaCodeWake
            MediaCodeWake.setFilePath(selectedFile.getPath());
        }
    }
    @FXML
    void Chuc_Nang_Am_Luong_Nhac_Chuong(ActionEvent event) {
        //Bắt đầu code setvisible
        Am_Luong_Label.setVisible(true);
        Thanh_Am_Luong_Slider.setVisible(true);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Thoi_Gian_Tu_Tat_Bao_Thuc_Button.setVisible(false);
        //Kết thúc code setvisible

        Thanh_Am_Luong_Slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Lấy giá trị âm lượng mới từ Slider
            int number = (int) (newValue.doubleValue());
            Am_Luong_Label.setText("Âm lượng: " + number);

            // Đặt âm lượng cho đối tượng MediaPlayer của MediaCodeWake
            if (mediaCodeWake != null) {
                mediaCodeWake.setVolume(number);
            }
        });
    }
    @FXML
    void Chuc_Nang_Thoi_Gian_Tat_Bao_Thuc(ActionEvent event) {

    }
    //Kết thúc dòng code Controller và logic của Cài Đặt


    //Bắt đầu dòng code Controller và logic của Lịch Hẹn
    @FXML
    void Hien_Thi_Cua_So_Lich_Hen(ActionEvent event) throws IOException {
        Thoi_Gian_Tu_Tat_Bao_Thuc_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Thoi_Gian_Bam_Gio_Label.setVisible(false);
        Bam_Gio_List_View.setVisible(false);
        Bat_Dau_Button.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(false);
        Them_Lich_Hen_Button.setVisible(true);
        Bao_Thuc_List_View.setVisible(false);
        Cap_Nhap_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Chon_Gio_ComboBox.setVisible(false);
        Chon_Phut_ComboBox.setVisible(false);
        Huy_Button.setVisible(false);
        Gio_Bao_Thuc_Label.setVisible(false);
        Phut_Bao_Thuc_Label.setVisible(false);
        Ky_Tu_Label.setVisible(false);
        Gio_Va_Phut_Lich_Hen_Label.setVisible(false);
        Chon_Gio_Lich_Hen_MenuBtton.setVisible(false);
        Chon_Phut_Lich_Hen_MenuButton.setVisible(false);
        Huy_Dat_Lich_Hen_Button.setVisible(false);
        Cap_Nhap_Lich_Hen_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(true);
        Cau_Hoi_Label.setVisible(false);
        Cau_Tra_Loi_Label.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Reset();
    }

    @FXML
    void Hien_Thi_Cua_So_Them_Lich_Hen(ActionEvent event) {
        Gio_Va_Phut_Lich_Hen_Label.setVisible(true);
        Chon_Gio_Lich_Hen_MenuBtton.setVisible(true);
        Chon_Phut_Lich_Hen_MenuButton.setVisible(true);
        Huy_Dat_Lich_Hen_Button.setVisible(true);
        Cap_Nhap_Lich_Hen_Button.setVisible(true);
        Lich_Hen_List_View.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
    }
    @FXML
    void Chon_Gio_Lich_Hen(ActionEvent event) {

    }
    @FXML
    void Chon_Phut_Lich_Hen(ActionEvent event) {

    }
    @FXML
    void Chuc_Nang_Cap_Nhap_Lich_Hen(ActionEvent event) {

    }
    @FXML
    void Chuc_Nang_Huy_Dat_Lich_Hen(ActionEvent event) {

    }

    //Kết thúc dòng code Controller và logic của Lịch Hẹn

}
