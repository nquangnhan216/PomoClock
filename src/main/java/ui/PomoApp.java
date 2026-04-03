package ui;

import service.PomoService;
import model.PomoConfig;
import javafx.application.Application;
import javafx.stage.Stage; //window của app
import javafx.scene.Scene; //hiển thị trên window
import javafx.scene.control.Label; //chữ trên window
import javafx.scene.layout.VBox; //sắp xếp layout
import javafx.geometry.Pos; //sắp xếp layout
import javafx.scene.control.Button; // nút
import javafx.animation.KeyFrame; //đánh dấu dòng thời gian
import javafx.animation.Timeline; //dòng thời gian để chạy animation
import javafx.util.Duration;

public class PomoApp extends Application {
    private PomoConfig config = new PomoConfig(30,5);
    private PomoService service = new PomoService(config);

    private Label titleLabel = new Label("Pomodoro App");
    private Label modeLabel = new Label(" ");
    private Label timeLabel = new Label("0:30");

    private String formatTime(int seconds) { //đưa thời gian từ second về minute:second
        if (seconds%60 >= 10) {
            return seconds/60 + ":" + seconds % 60;
        } else {
            return seconds/60 + ":0" + seconds % 60;
        }
    }

    private void refreshUI() {
        timeLabel.setText(formatTime(service.getState().getRemainingSeconds())); //refresh UI để hiện thay đổi
        modeLabel.setText(String.valueOf(service.getState().getMode())); //refresh chế độ
    }
    private Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                service.tick();
                refreshUI();
            })
    );


    @Override
    public void start(Stage stage) { //khi start thì nhận object stage = window
        stage.setTitle("Pomo"); //đặt tên cửa sổ

        //Label titleLabel = new Label("Pomodoro App"); //tạo biến chữ
        titleLabel.setStyle("-fx-font-size: 48px; -fx-font-family: 'Montserrat ExtraBold'");
        //đặt kiểu chữ: cỡ + phông

        //Label timeLabel = new Label("25:00");
        timeLabel.setStyle("-fx-font-size:24px; -fx-font-family: 'Times New Roman'");

        modeLabel.setStyle("-fx-font-size:24px; -fx-font-family: 'Arial Bold'");

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            service.start();
            refreshUI();
        });


        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> {
            service.pause();
            refreshUI();
        });

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e ->{
            service.reset();
            refreshUI();
        });

        VBox root = new VBox(titleLabel, modeLabel, timeLabel, startButton, pauseButton, resetButton);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER); //align chính giữa
        Scene scene = new Scene(root, 1000, 700); //show biến chữ + cỡ CỦA MH (width, height)
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        stage.setScene(scene);
        stage.show();
    }
}
