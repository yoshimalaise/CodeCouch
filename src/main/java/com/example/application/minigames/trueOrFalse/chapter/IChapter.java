package com.example.application.minigames.trueOrFalse.chapter;

import java.util.List;

/**
 * Every chapter needs at least 30 true and 30 false statements for optimal use
 */
public interface IChapter {
    public String getChapterName();
    public List<String> getTrueStatements();
    public List<String> getFalseStatements();
}
