package com.example.demo;//package com.example.demo;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Slider;
//import javafx.scene.layout.VBox;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.net.MalformedURLException;
//
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//
//public class AudioPlayer extends Application {
//
//    private MediaPlayer mediaPlayer;
//    private Slider volumeSlider;
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Tạo một nút để chọn file âm thanh
//        Button selectButton = new Button("Chọn file âm thanh");
//
//        // Sự kiện khi nút được nhấn
//        selectButton.setOnAction(e -> {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Chọn file âm thanh");
//            File file = fileChooser.showOpenDialog(primaryStage);
//            if (file != null) {
//                playAudio(file);
//            }
//        });
//
//        // Tạo Slider để điều chỉnh âm lượng
//        volumeSlider = new Slider(0.0, 1.0, 0.5); // Giá trị mặc định là 0.5
//        volumeSlider.setShowTickLabels(true);
//        volumeSlider.setShowTickMarks(true);
//        volumeSlider.setMajorTickUnit(0.25);
//        volumeSlider.setBlockIncrement(0.1);
//
//        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.setVolume(newValue.doubleValue());
//            }
//        });
//
//        VBox root = new VBox();
//        root.getChildren().addAll(selectButton, volumeSlider);
//
//        Scene scene = new Scene(root, 300, 250);
//
//        primaryStage.setTitle("Phát âm thanh");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    // Phát âm thanh từ file
//    private void playAudio(File file) {
//        try {
//            Media media = new Media(file.toURI().toURL().toString());
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setVolume(volumeSlider.getValue()); // Đặt âm lượng ban đầu từ Slider
//            mediaPlayer.play();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AudioPlayer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Tạo các thành phần giao diện
        Label labelCauHoi = new Label("Câu hỏi:");
        Label labelCauTraLoi = new Label("Câu trả lời:");
        TextField textFieldCauTraLoi = new TextField();
        Button buttonNop = new Button("Nộp");

        // Tạo một GridPane để chứa các thành phần
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);

        // Thêm các thành phần vào GridPane và thiết lập vị trí
        gridPane.add(labelCauHoi, 0, 0); // labelCauHoi ở cột 0, hàng 0
        gridPane.add(labelCauTraLoi, 0, 1); // labelCauTraLoi ở cột 0, hàng 1
        gridPane.add(textFieldCauTraLoi, 0, 2); // textFieldCauTraLoi ở cột 1, hàng 1
        gridPane.add(buttonNop, 0, 3); // buttonNop ở cột 1, hàng 2



        // Đặt căn chỉnh cho buttonNop để nó nằm ở góc dưới cùng bên phải
        GridPane.setHalignment(buttonNop, javafx.geometry.HPos.RIGHT);
        GridPane.setMargin(buttonNop, new Insets(20, 0, 0, 0)); // Đặt khoảng cách cho buttonNop

        // Tạo Scene từ GridPane với kích thước 200x200
        Scene scene = new Scene(gridPane, 200, 200);

        // Thiết lập tiêu đề cho Stage (cửa sổ)
        primaryStage.setTitle("Cửa sổ nhỏ hình vuông");
        primaryStage.setScene(scene);

        // Hiển thị cửa sổ
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

