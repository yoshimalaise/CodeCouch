package com.example.application.bl;

import com.example.application.minigames.outputguesser.OutputGuesserGameFactory;
import com.example.application.minigames.trueOrFalse.TrueOrFalseGameFactory;
import com.example.application.minigames.trueOrFalse.chapter.ChapterOne;
import com.example.application.minigames.trueOrFalse.chapter.ChapterTwo;
import com.example.application.model.BaseGameFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public abstract class MiniGameFactoryCollection {

    public static ArrayList<BaseGameFactory> getAllFactories() {
        return (new ArrayList<BaseGameFactory>() {{
                    add(new OutputGuesserGameFactory());

                    // add all the chapter true or false levels
                    add(new TrueOrFalseGameFactory<>(ChapterOne.NAME, ChapterOne::new));
                    add(new TrueOrFalseGameFactory<>(ChapterTwo.NAME, ChapterTwo::new));
                }}).stream()
                .sorted(Comparator.comparing(f -> f.name))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
