package com.example.application.model.jsTypes;

public class JSFunctionCallResult {
    int res;

    public JSFunctionCallResult() {
    }

    public static String getExtractionString(int x, int y, int z) {
        return "\nreturn ({ res: doMagic(" + x + ", " +
                y + ", " +  z +") });";
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
