package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Test {
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
    private Label Gio_Va_Phut_Lich_Hen_Label;
    @FXML
    private Label Proptit_Label;
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

    //Bắt Đầu dòng code của phần controller và logic của Bấm giờ
    private Timeline timeline;
    private long startTime;
    private boolean isRunning = false;
    private int lapCount = 0;
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
    private String string;
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
        Chon_Gio_ComboBox.getSelectionModel().clearSelection();
        Chon_Phut_ComboBox.getSelectionModel().clearSelection();
        HBox hBox = new HBox();
        Button button1 = new Button("Xoá");
        Label Thoi_Gian_Bao_Thuc = new Label();
        if (string.length() == 7) {
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
            Bao_Thuc_List_View.getItems().remove(hBox);
        });
        Bao_Thuc_List_View.getItems().add(hBox);
        string = "";
    }
    @FXML
    void Chon_Gio_Bao_Thuc(ActionEvent event) {
        Object selectedItem = Chon_Gio_ComboBox.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String str = selectedItem.toString();
            string = string + str + " : ";
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
    //Kết thúc dòng code Controller và logic của Báo Thức


    //Bắt đầu dòng code Controller và logic của Cài Đặt
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

    }
    @FXML
    void Cai_Dat_Nhac_Chuong_Bao_Thuc(ActionEvent event) {

    }
    @FXML
    void Chuc_Nang_Am_Luong_Nhac_Chuong(ActionEvent event) {

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
