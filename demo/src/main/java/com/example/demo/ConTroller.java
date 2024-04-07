package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ConTroller {


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
    private Button Am_Luong_Nhac_Chuong_Button;
    @FXML
    private Button Nhac_Chuong_Bao_Thuc_Button;
    @FXML
    private Button Quay_Lai_Button;
    @FXML
    private Button Tat_Cua_So_Thong_Bao_Lich_Hen_Button;
    @FXML
    private ComboBox Chon_Gio_ComboBox;

    @FXML
    private ComboBox Chon_Phut_ComboBox;
    @FXML
    private ComboBox Chon_Gio_Lich_Hen_ComboBox;
    @FXML
    private ComboBox Chon_Phut_Lich_Hen_ComboBox;
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
    private Label Thoi_Gian_Bam_Gio_Label;
    @FXML
    private Label Lich_Hen_Label;
    @FXML
    private Label Cau_Hoi_O_Cua_So_Cau_Hoi_Label;
    @FXML
    private Label Kiem_Tra_Label;

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
    private TextField Lich_Hen_TextField;
    @FXML
    private Slider Thanh_Am_Luong_Slider;
    @FXML
    private AnchorPane Cua_So_Cau_Tra_Loi_AnchorPane;
    @FXML
    private AnchorPane Thong_Bao_Lich_Hen_AnchorPane;
    @FXML
    private AnchorPane Them_Lich_Hen_AnchorPane;
    @FXML
    private AnchorPane Them_Bao_Thuc_AnchorPane;
    @FXML
    private AnchorPane Buc_Anh_AnchorPane;
    @FXML
    private AnchorPane Empty_AnchorPane;
    @FXML
    private CheckBox Tat_Mo_Giao_Dien_Chinh_Checkbox;

    private void Khoi_Tao_Media(){
        mediaCodeWake.playMedia();
        if (mediaCodeWake != null) mediaCodeWake.stopMedia();
    }

    //Bắt Đầu dòng code của phần controller và logic của Bấm giờ
    private Timeline timeline;
    private long startTime;
    private boolean isRunning = false;
    private int lapCount = 0;
    private void Reset() {
        Thoi_Gian_Bam_Gio_Label.setText("00:00:00:00");
        Tam_Dung_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
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
        Tiep_Tuc_Button.setVisible(false);
        Quay_Lai_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Cau_Hoi_Cho_Bao_Thuc_TexField.setVisible(false);
        Cau_Tra_Loi_Bao_Thuc_TextField.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Them_Lich_Hen_AnchorPane.setVisible(false);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        Thong_Bao_Lich_Hen_AnchorPane.setVisible(false);
        Tat_Mo_Giao_Dien_Chinh_Checkbox.setSelected(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Empty_AnchorPane.setVisible(false);
        Khoi_Tao_Media();
        Reset();
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
    private int cnt = 0;
    private String string;
    private String Cau_Hoi;
    private String Cau_Tra_Loi;
    private Timeline alarmTimeline;
    private ArrayList<Pair<String,String>> Danh_Sach_Cau_Hoi = new ArrayList<>();
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
        Quay_Lai_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Thong_Bao_Lich_Hen_AnchorPane.setVisible(false);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        Them_Lich_Hen_AnchorPane.setVisible(false);
        Tat_Mo_Giao_Dien_Chinh_Checkbox.setSelected(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Empty_AnchorPane.setVisible(false);
        Khoi_Tao_Media();
        Reset();
    }
    @FXML
    void Hien_Thi_Cua_So_Them_Bao_Thuc(ActionEvent event) {
        Bao_Thuc_List_View.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(false);
        Them_Bao_Thuc_AnchorPane.setVisible(true);
        string = "";
        Khoi_Tao();
    }
    @FXML
    void Chuc_Nang_Cua_Huy_Button(ActionEvent event)  {
        Bao_Thuc_List_View.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(true);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        StartAlarmClock();
    }
    @FXML
    void Chuc_Nang_Cua_Cap_Nhap_Button(ActionEvent event)  {
        Bao_Thuc_List_View.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(true);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        Chon_Gio_ComboBox.getSelectionModel().clearSelection();
        Chon_Phut_ComboBox.getSelectionModel().clearSelection();
        HBox hBox = new HBox();
        Button button1 = new Button("Xoá");
        Label Thoi_Gian_Bao_Thuc = new Label();
        Cau_Hoi = Cau_Hoi_Cho_Bao_Thuc_TexField.getText();
        Cau_Tra_Loi = Cau_Tra_Loi_Bao_Thuc_TextField.getText();
        if (string.length() == 5 && Cau_Hoi.length() > 0 && Cau_Tra_Loi.length() > 0) {
            Thoi_Gian_Bao_Thuc.setText(string);
        }
        else {
            return;
        }
        hBox.getChildren().addAll(Thoi_Gian_Bao_Thuc, button1);
        Thoi_Gian_Bao_Thuc.setMaxWidth(Double.MAX_VALUE);
        hBox.setHgrow(Thoi_Gian_Bao_Thuc, Priority.ALWAYS);
        // Thêm ClickListener vào nút "Xoá"
        button1.setOnAction(event1 -> {
            Danh_Sach_Cau_Hoi.remove(Bao_Thuc_List_View.getItems().indexOf(hBox));
            Bao_Thuc_List_View.getItems().remove(hBox);
        });
        Bao_Thuc_List_View.getItems().add(hBox);
        //Cập nhập câu hỏi để tắt báo thức
        Danh_Sach_Cau_Hoi.add( new Pair<>(Cau_Hoi, Cau_Tra_Loi));
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
     private int Check_1(String s) {
        //Lấy thời gian từ hệ thống
         LocalDateTime localDateTime = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
         String dateString = localDateTime.format(formatter);
        // So sánh thời gian
        if (s.equals(dateString)) return 1;
        else return 0;
    }
    private int Check_2(String x, String y) {
        if (x.equals(y)) return 1;
        else return 0;
    }
    private int kiemtra = 0;
    private void StartAlarmClock() {
        // Tạo một timeline kiểm tra mỗi nửa phút
        alarmTimeline = new Timeline(new KeyFrame(Duration.minutes(0.5), event -> {
            int len = Bao_Thuc_List_View.getItems().size();
            for (int i = 0; i < len; i++) {
                HBox hBox = Bao_Thuc_List_View.getItems().get(i);
                Label tmp = (Label) hBox.getChildren().get(0);
                String alrmTime = tmp.getText();
                if (Check_1(alrmTime) == 1) {
                    kiemtra = -1;
                    // Hiển thị giao diện khi báo thức được kích hoạt
                    Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(true);
                    Empty_AnchorPane.setVisible(true);
                    Bao_thuc_Button.setVisible(false);
                    Bam_Gio_Button.setVisible(false);
                    Lich_Hen_Button.setVisible(false);
                    Cai_Dat_Button.setVisible(false);

                    // Lấy câu hỏi và đáp án từ danh sách
                    Pair<String, String> pair = Danh_Sach_Cau_Hoi.get(i);
                    Cau_Hoi_O_Cua_So_Cau_Hoi_Label.setText("Câu hỏi: " + pair.getKey());
                    //Chạy nhạc
                    mediaCodeWake.playMedia();
                    // Xử lý sự kiện khi nhấn nút "Nộp"
                    Nop_Button.setOnAction(event1 -> {
                        String str = Cau_Tra_Loi_TextField.getText();
                        if (Check_2(pair.getValue(), str) == 1) {
                            // Nếu đáp án đúng, dừng nhạc và ẩn giao diện
                            mediaCodeWake.stopMedia();
                            System.out.println("ok");
                            Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(false);
                            Empty_AnchorPane.setVisible(false);
                            Bao_thuc_Button.setVisible(true);
                            Bam_Gio_Button.setVisible(true);
                            Lich_Hen_Button.setVisible(true);
                            Cai_Dat_Button.setVisible(true);
                            kiemtra = 1;
                            Nop_Button.setOnAction(null); // Xóa sự kiện khi đã kết thúc
                        } else {
                            // Nếu đáp án sai, chơi lại âm thanh báo thức và xóa nội dung câu trả lời
                            if (mediaCodeWake != null) {
                                mediaCodeWake.stopMedia();
                            }
                            mediaCodeWake.playMedia();
                            Cau_Tra_Loi_TextField.clear();
                            Kiem_Tra_Label.setText("Kiểm tra: Đáp án sai");
                        }
                    });
                    break; // Sau khi tìm thấy báo thức phù hợp, thoát khỏi vòng lặp
                }
                else if (kiemtra == -1){
                    mediaCodeWake.playMedia();
                }
                else {
                    if (mediaCodeWake != null) mediaCodeWake.stopMedia();
                    kiemtra = 0;
                }
            }
        }));
        alarmTimeline.setCycleCount(Animation.INDEFINITE);
        alarmTimeline.play();
    }
    //Kết thúc dòng code Controller và logic của Báo Thức


    //Bắt đầu dòng code Controller và logic của Cài Đặt
    public int number;
    @FXML
    void Hien_Thi_Cua_So_Cai_Dat(ActionEvent event) {
        Quay_Lai_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(true);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(true);
        Thoi_Gian_Bam_Gio_Label.setVisible(false);
        Bam_Gio_List_View.setVisible(false);
        Bat_Dau_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
        Bao_Thuc_List_View.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Tam_Dung_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Thong_Bao_Lich_Hen_AnchorPane.setVisible(false);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        Them_Lich_Hen_AnchorPane.setVisible(false);
        Tat_Mo_Giao_Dien_Chinh_Checkbox.setSelected(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Empty_AnchorPane.setVisible(false);
        Khoi_Tao_Media();
        Reset();
    }
    @FXML
    void Cai_Dat_Nhac_Chuong_Bao_Thuc(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Cập nhật đường dẫn file vào class MediaCodeWake
            MediaCodeWake.setFilePath(selectedFile.getPath());
            mediaCodeWake.playMedia();
        }
    }
    @FXML
    void Chuc_Nang_Am_Luong_Nhac_Chuong(ActionEvent event) {
        //Bắt đầu code setvisible
        Am_Luong_Label.setVisible(true);
        Thanh_Am_Luong_Slider.setVisible(true);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Quay_Lai_Button.setVisible(true);
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
    void Chuc_Nang_Quay_Lai(ActionEvent event) {
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(true);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(true);
        Quay_Lai_Button.setVisible(false);
    }
    //Kết thúc dòng code Controller và logic của Cài Đặt


    //Bắt đầu dòng code Controller và logic của Lịch Hẹn
    private String ThoiGian;
    private ArrayList<String> Danh_Sach_Lich_Hen = new ArrayList<>();
    void Khoi_Tao_Thoi_Gian_Lich_Hen() {
        //Thêm lựa chọn giờ báo thức
        ObservableList<String> items_1 = FXCollections.observableArrayList();
        for (int i = 0; i <= 23; i++) {
            if (i < 10) items_1.add("0" + i);
            else items_1.add(""+ i);
        }
        Chon_Gio_Lich_Hen_ComboBox.setItems(items_1);
        //Thêm lựa chọn phút báo thức
        ObservableList<String> items_2 = FXCollections.observableArrayList();
        for (int i = 0; i <= 59; i ++) {
            if (i < 10) items_2.add("0" + i);
            else items_2.add(""+ i);
        }
        Chon_Phut_Lich_Hen_ComboBox.setItems(items_2);
    }
    @FXML
    void Hien_Thi_Cua_So_Lich_Hen(ActionEvent event){
        Quay_Lai_Button.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Thoi_Gian_Bam_Gio_Label.setVisible(false);
        Bam_Gio_List_View.setVisible(false);
        Bat_Dau_Button.setVisible(false);
        Them_Bao_Thuc_Button.setVisible(false);
        Bao_Thuc_List_View.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(true);
        Am_Luong_Label.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Cua_So_Cau_Tra_Loi_AnchorPane.setVisible(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Thong_Bao_Lich_Hen_AnchorPane.setVisible(false);
        Them_Lich_Hen_AnchorPane.setVisible(false);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        Them_Lich_Hen_Button.setVisible(true);
        Tat_Mo_Giao_Dien_Chinh_Checkbox.setSelected(false);
        Buc_Anh_AnchorPane.setVisible(false);
        Empty_AnchorPane.setVisible(false);
        Khoi_Tao_Media();
        Reset();
    }

    @FXML
    void Hien_Thi_Cua_So_Them_Lich_Hen(ActionEvent event) {
        Them_Lich_Hen_AnchorPane.setVisible(true);
        Lich_Hen_List_View.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
        ThoiGian = "";
        Khoi_Tao_Thoi_Gian_Lich_Hen();
    }
    @FXML
    void Chon_Gio_Lich_Hen(ActionEvent event) {
        Object selectedItem = Chon_Gio_Lich_Hen_ComboBox.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String str = selectedItem.toString();
            ThoiGian = ThoiGian + str + ":";
        }
    }
    @FXML
    void Chon_Phut_Lich_Hen(ActionEvent event) {
        Object selectedItem = Chon_Phut_Lich_Hen_ComboBox.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String str = selectedItem.toString();
            ThoiGian = ThoiGian + str;
        }
    }
    @FXML
    void Chuc_Nang_Cap_Nhap_Lich_Hen(ActionEvent event) {
        Lich_Hen_List_View.setVisible(true);
        Them_Lich_Hen_Button.setVisible(true);
        Them_Lich_Hen_AnchorPane.setVisible(false);
        Chon_Gio_Lich_Hen_ComboBox.getSelectionModel().clearSelection();
        Chon_Phut_Lich_Hen_ComboBox.getSelectionModel().clearSelection();
        HBox hBox = new HBox();
        Button button1 = new Button("Xoá");
        Label Thoi_Gian_Lich_Hen = new Label();
        String str = Lich_Hen_TextField.getText();
        if (ThoiGian.length() == 5 && str.length() > 0) {
            Thoi_Gian_Lich_Hen.setText(ThoiGian);
        }
        else {
            return;
        }
        hBox.getChildren().addAll(Thoi_Gian_Lich_Hen, button1);
        Thoi_Gian_Lich_Hen.setMaxWidth(Double.MAX_VALUE);
        hBox.setHgrow(Thoi_Gian_Lich_Hen, Priority.ALWAYS);
        // Thêm ClickListener vào nút "Xoá"
        button1.setOnAction(event1 -> {
            Danh_Sach_Lich_Hen.remove(Lich_Hen_List_View.getItems().indexOf(hBox));
            Lich_Hen_List_View.getItems().remove(hBox);
        });
        Danh_Sach_Lich_Hen.add(str);
        Lich_Hen_List_View.getItems().add(hBox);
        ThoiGian = "";
        Lich_Hen_TextField.clear();
        Start_Lich_Hen();
    }
    @FXML
    void Chuc_Nang_Huy_Dat_Lich_Hen(ActionEvent event) {
        Lich_Hen_List_View.setVisible(true);
        Them_Lich_Hen_Button.setVisible(true);
        Them_Lich_Hen_AnchorPane.setVisible(false);
        Start_Lich_Hen();
    }
    private int Check_3(String s) {
        //Lấy thời gian từ hệ thống
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String dateString = localDateTime.format(formatter);
        // So sánh thời gian
        if (s.equals(dateString)) return 1;
        else return 0;
    }
    private int ktra = 0;
    private int count = 0;
    private void Start_Lich_Hen() {
        // Tạo một timeline kiểm tra mỗi nửa phút
        alarmTimeline = new Timeline(new KeyFrame(Duration.minutes(0.6), event -> {
            int len = Lich_Hen_List_View.getItems().size();
            for (int i = 0; i < len; i++) {
                HBox hBox = Lich_Hen_List_View.getItems().get(i);
                Label tmp = (Label) hBox.getChildren().get(0);
                String alrmTime = tmp.getText();
                if (Check_3(alrmTime) == 1) {
                    count ++;
                    ktra = -1;
                    Thong_Bao_Lich_Hen_AnchorPane.setVisible(true);
                    // Lấy câu hỏi và đáp án từ danh sách
                    String str = Danh_Sach_Lich_Hen.get(i);
                    Lich_Hen_Label.setText(str);
                    //Chạy nhạc
                    mediaCodeWake.playMedia();
                    // Xử lý sự kiện khi nhấn nút "X"
                    Tat_Cua_So_Thong_Bao_Lich_Hen_Button.setOnAction(event1 -> {
                        mediaCodeWake.stopMedia();
                        Thong_Bao_Lich_Hen_AnchorPane.setVisible(false);
                        ktra = 1;
                    });
                    break; // Sau khi tìm thấy báo thức phù hợp, thoát khỏi vòng lặp
                }
                else if (ktra == -1){
                    mediaCodeWake.playMedia();
                }
                else if(count > 0){
                    if (mediaCodeWake != null) mediaCodeWake.stopMedia();
                    ktra = 0;
                    count = 0;
                }
            }
        }));
        alarmTimeline.setCycleCount(Animation.INDEFINITE);
        alarmTimeline.play();
    }
    //Kết thúc dòng code Controller và logic của Lịch Hẹn
    private void Kiem_Tra_Tat_Giao_Dien_Chinh() {
        if (!Tat_Mo_Giao_Dien_Chinh_Checkbox.isSelected()) {
            Bao_Thuc_List_View.setVisible(true);
            Them_Bao_Thuc_Button.setVisible(true);
            Buc_Anh_AnchorPane.setVisible(false);
            Empty_AnchorPane.setVisible(false);
        }
        else return;
    }
    @FXML
    void Mo_Giao_Dien_Chinh(ActionEvent event) {
        Buc_Anh_AnchorPane.setVisible(true);
        Empty_AnchorPane.setVisible(true);
        Them_Bao_Thuc_Button.setVisible(false);
        Bat_Dau_Button.setVisible(false);
        Tiep_Tuc_Button.setVisible(false);
        Dat_Lai_Button.setVisible(false);
        Luu_Thoi_Gian_Button.setVisible(false);
        Tam_Dung_Button.setVisible(false);
        Them_Lich_Hen_Button.setVisible(false);
        Thoi_Gian_Bam_Gio_Label.setVisible(false);
        Bam_Gio_List_View.setVisible(false);
        Bao_Thuc_List_View.setVisible(false);
        Am_Luong_Nhac_Chuong_Button.setVisible(false);
        Quay_Lai_Button.setVisible(false);
        Nhac_Chuong_Bao_Thuc_Button.setVisible(false);
        Lich_Hen_List_View.setVisible(false);
        Thanh_Am_Luong_Slider.setVisible(false);
        Am_Luong_Label.setVisible(false);
        Thong_Bao_Lich_Hen_AnchorPane.setVisible(false);
        Them_Bao_Thuc_AnchorPane.setVisible(false);
        Reset();
        Kiem_Tra_Tat_Giao_Dien_Chinh();
    }

}
