package com.example.application.model.jsTypes;

public class XYZResult {
    int x;
    int y;
    int z;

    public XYZResult() {
    }

    public static String getExtractionString() {
        return "\n return ({x, y, z});";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
