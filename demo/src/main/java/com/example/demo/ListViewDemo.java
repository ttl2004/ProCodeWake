package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ComboBox Demo");

        // Tạo ComboBox 1
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll("Option 1", "Option 2", "Option 3");
        comboBox1.setPromptText("Select Option 1");

        // Tạo ComboBox 2
        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll("Option A", "Option B", "Option C");
        comboBox2.setPromptText("Select Option A");

        // Tạo nút cập nhật
        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            // Lấy giá trị từ các ComboBox
            String selectedOption1 = comboBox1.getValue();
            String selectedOption2 = comboBox2.getValue();

            // In ra chuỗi đã chọn
            System.out.println("Selected options: " + selectedOption1 + ", " + selectedOption2);

            // Đặt lại ComboBox về trạng thái ban đầu
            comboBox1.getSelectionModel().clearSelection();
            comboBox2.getSelectionModel().clearSelection();
        });

        // Tạo layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(comboBox1, comboBox2, updateButton);

        // Tạo Scene
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
