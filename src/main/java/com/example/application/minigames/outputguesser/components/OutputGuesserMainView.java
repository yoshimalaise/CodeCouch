package com.example.application.minigames.outputguesser.components;

import com.example.application.model.jsTypes.XYZResult;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;

public class OutputGuesserMainView extends BaseView {

    private final String testScript = "function demo() {" +
            " return ({x: 5, y: 7, z: 4});" +
            "}" +
            " return demo();";

    public OutputGuesserMainView() {
        DesktopContainer.executeJavaScript(testScript, XYZResult.class, res -> {
            System.out.println(res.toString());
        });
    }
}
