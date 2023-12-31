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
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.StreamResource;

import javax.imageio.ImageIO;
import javax.xml.transform.stream.StreamSource;
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

    public LobbyView(Game g) {
        super(g);
        Text lblTitle = new Text("CodeCouch Lobby");
        Image imgQR = new Image();
        playersContainer = new HorizontalLayout();
        playersContainer.setAlignItems(Alignment.CENTER);
        playersContainer.setPadding(true);
        playersContainer.setMargin(true);
        playersContainer.setSpacing(true);
        playersContainer.setVerticalComponentAlignment(Alignment.CENTER);
        String joinUrl = "";
        try {
            BitMatrix bitMatrix = null;
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            String url = System.getenv("HOST_URL") == null ? ("http://" + this.getPublicIPv4() + ":8080") : System.getenv("HOST_URL");
            joinUrl = url + "/mobile/"+ g.gameId;
            bitMatrix = barcodeWriter.encode( url + "/mobile/"+ g.gameId, BarcodeFormat.QR_CODE, 400, 400);
            BufferedImage bimg = MatrixToImageWriter.toBufferedImage(bitMatrix);
            String b64Data = this.encodeToString(bimg, "png");
            imgQR.setSrc(b64Data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Span lblInstructions = new Span("Scan the QR code with your phone or navigate to " + joinUrl + " to join the game.");

        this.setAlignItems(Alignment.CENTER);
        this.setHorizontalComponentAlignment(Alignment.CENTER);
        this.add(lblTitle, imgQR, lblInstructions, playersContainer);
    }

    @Override
    public void update() {
        if (playersContainer.getUI().isPresent()) {
            playersContainer.getUI().get().access(() -> {
                playersContainer.removeAll();
                game.getPlayers().stream().forEach(p -> playersContainer.add(new PlayerAvatarComponent(p)));
            });
        }
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
