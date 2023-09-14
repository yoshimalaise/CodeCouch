package com.example.application.views.main;

import com.example.application.model.jsTypes.JSResultCallback;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.desktop.HomeView;
import com.example.application.views.desktop.LobbyView;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonObject;
import com.nimbusds.jose.shaded.gson.JsonParser;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
@PreserveOnRefresh
public class DesktopContainer extends HorizontalLayout {

    private BaseView currentView;

    public DesktopContainer() {
        this.switchToView(DesktopView.HOME_VIEW);
    }

    public void switchToView(DesktopView v) {
        switch (v) {
            case HOME_VIEW:
                this.currentView = new HomeView(this);
                break;
            case LOBBY:
                this.currentView = new LobbyView();
                break;
        }

        if (this.getUI().isPresent()) {
            this.getUI().get().access(() -> {
                this.removeAll();
                this.add(this.currentView);
            });
        } else {
            this.removeAll();
            this.add(this.currentView);
        }
    }

    public void switchToView(BaseView v) {
        this.getUI().get().access(() -> {
            currentView = v;
            this.removeAll();
            this.add(v);
        });
    }

    public void update() {
        if (this.currentView != null) {
            if (this.currentView.getUI().isPresent()) {
                this.currentView.getUI().get().access(() -> {
                    this.currentView.update();
                });
            } else {
                this.currentView.update();
            }
        }
    }

    public static <T> void executeJavaScript(String script, Class<T> type, JSResultCallback<T> callback) {
        Page page = UI.getCurrent().getPage();
        PendingJavaScriptResult result = page.executeJs(script);
        result.then(res -> {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(res.toJson());// response will be the json String
            T obj = gson.fromJson(object, type);
            callback.call(obj);
        });
    }

}
