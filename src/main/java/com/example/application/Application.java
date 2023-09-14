package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Push
@Theme(value = "mytodo")
public class Application implements AppShellConfigurator  {
    private static AtomicBoolean isRunning = new AtomicBoolean(false);

    public static void main(String[] args) {

        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.headless(false);
        builder.run(args);

        /**
         * Open the browser window and navigate to the game
         */
        if (!isRunning.getAndSet(true)) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

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
            });
            thread.start();
        }
    }

}
