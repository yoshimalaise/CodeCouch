package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
public class Main implements AppShellConfigurator  {


    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        builder.headless(false);
        builder.run(args);

        /** this code is irrelevant in the new hosted online edition
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:8080"));

                URL url = Main.class.getClassLoader().getResource("icons/CodeCouchLogo.png");
                if (Taskbar.isTaskbarSupported()) {
                    Taskbar.getTaskbar().setIconImage(ImageIO.read(new File(url.getFile())));
                }
            } catch (IOException | URISyntaxException | NullPointerException e) {
                // :)
            }
        }
         */
    }
}
