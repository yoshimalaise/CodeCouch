package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Every chapter needs at least 30 true and 30 false statements for optimal use
 */
public abstract class BaseChapter {

    public String chapterName = "";

    public BaseChapter(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterName(){
        return chapterName;
    }
    public List<String> getTrueStatements() {
        return new ArrayList<>();
    }
    public List<String> getFalseStatements(){
        return new ArrayList<>();
    }
}
