package com.example.application.views.desktop;

import com.example.application.bl.Game;
import com.example.application.views.desktop.components.PlayerAvatarComponent;
import com.example.application.views.main.BaseView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;

import javax.imageio.ImageIO;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

public class LobbyView extends BaseView {

    private HorizontalLayout playersContainer;
    private Button btnStart;
    public LobbyView() {
        Text lblTitle = new Text("CodeCouch Lobby");
        Image imgQR = new Image();
        playersContainer = new HorizontalLayout();
        playersContainer.setAlignItems(Alignment.CENTER);
        playersContainer.setPadding(true);
        playersContainer.setMargin(true);
        playersContainer.setSpacing(true);
        playersContainer.setVerticalComponentAlignment(Alignment.CENTER);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            String publicIp = this.getPublicIPv4();
            bitMatrix = barcodeWriter.encode("http://" + publicIp + ":8080/mobile", BarcodeFormat.QR_CODE, 400, 400);
            BufferedImage bimg = MatrixToImageWriter.toBufferedImage(bitMatrix);
            String b64Data = this.encodeToString(bimg, "png");
            imgQR.setSrc(b64Data);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        this.btnStart = new Button("Start Game");
        btnStart.setEnabled(false);

        this.setAlignItems(Alignment.CENTER);
        this.setHorizontalComponentAlignment(Alignment.CENTER);
        this.add(lblTitle, imgQR, playersContainer);
    }

    @Override
    public void update() {
        playersContainer.getUI().get().access(() -> {
            playersContainer.removeAll();
            Game.getPlayers().stream().forEach(p -> playersContainer.add(new PlayerAvatarComponent(p)));
            if (Game.getPlayers().size() > 1) {
                btnStart.setEnabled(true);
            }
        });
    }

    private String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            Base64.Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/jpeg;base64," + imageString;
    }

    private String getPublicIPv4() {
        try {
            Enumeration<NetworkInterface> e = null;
            e = NetworkInterface.getNetworkInterfaces();
            String ipToReturn = null;
            while(e.hasMoreElements())
            {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration<InetAddress> ee = n.getInetAddresses();
                while (ee.hasMoreElements())
                {
                    InetAddress i = (InetAddress) ee.nextElement();
                    String currentAddress = i.getHostAddress();
                    if(currentAddress.split("\\.").length == 4 && !currentAddress.startsWith("127.")){
                        ipToReturn = currentAddress;
                    }
                }
            }
            return ipToReturn;
        } catch (SocketException ex) {
            throw new RuntimeException(ex);
        }
    }

}
