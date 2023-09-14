package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterThree extends BaseChapter {
    private static final String NAME = "3. HTML5";

    public ChapterThree() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>(){{
            add("");
        }};
    }
}
