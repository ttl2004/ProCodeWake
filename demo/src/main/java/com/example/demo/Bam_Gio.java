package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import com.example.demo.Test;
public  class Bam_Gio {
    private Timeline timeline;
    private int seconds = 0;
    private boolean isRunning = false;
    private Label timeLabel;

    private void setupTimeline() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            seconds++;
            updateLabel();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void startStop() {
        if (isRunning) {
            timeline.stop();
        } else {
            timeline.play();
        }
        isRunning = !isRunning;
    }

    public void reset() {
        timeline.stop();
        seconds = 0;
        updateLabel();
        isRunning = false;
    }

    private void updateLabel() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, secs));
    }
}
