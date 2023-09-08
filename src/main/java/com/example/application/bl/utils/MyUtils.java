package com.example.application.bl.utils;

import java.util.ArrayList;
import java.util.Random;

public abstract class MyUtils {

    public static <T> T getRandomElFromList(ArrayList<T> els){
        Random random = new Random();
        return els.get(random.nextInt(els.size()));
    }
}
