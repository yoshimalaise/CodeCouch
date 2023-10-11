package com.example.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class DesktopWindow extends Application {
    private final int MIN_HEIGHT = 768;
    private final int MIN_WIDTH = 1024;

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(Main.class)
                .run(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CodeCouch - Web Technologies Edition");
        stage.setResizable(true);
        stage.setMinWidth(MIN_WIDTH);
        stage.setWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.setHeight(MIN_HEIGHT);

        BorderPane root = new BorderPane();
        stage.setScene(new Scene(root));

        try {
            WebView webView = new WebView();
            root.setCenter(webView);

            (new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    Platform.runLater(() -> webView.getEngine().load("http://localhost:8080"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })).start();


            stage.show();
            stage.setFullScreen(true);
        } catch (Exception e) {
            System.out.println("Could not load JavaFX falling back on browser.");
            this.openLocalBrowser();
            stage.hide();
        };

    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    private void openLocalBrowser() {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("http://localhost:8080"));
            }

            // try to change the logo

            URL url = getClass().getClassLoader().getResource("CodeCouchLogo.png");
            if (Taskbar.isTaskbarSupported()) {
                Taskbar.getTaskbar().setIconImage(ImageIO.read(new File(url.getFile())));
            }
        } catch (Exception ex) {
            System.out.println("Could not change taskbar logo");
        }
    }
}
