package com.example.application.views.mobile;

import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.Text;

public class WaitView extends BaseView {

    public WaitView() {
        Text txtPleaseWait = new Text("Please wait while the host is setting up the game");
        this.add(txtPleaseWait);
    }
}
