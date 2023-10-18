package com.example.application.bl;

import com.example.application.minigames.outputguesser.OutputGuesserGameFactory;
import com.example.application.minigames.resultguesser.ResultGuesserGameFactory;
import com.example.application.minigames.trueOrFalse.TrueOrFalseGameFactory;
import com.example.application.minigames.trueOrFalse.chapter.*;
import com.example.application.model.BaseGameFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public abstract class MiniGameFactoryCollection {

    public static ArrayList<BaseGameFactory> getAllFactories(Game game) {
        return (new ArrayList<BaseGameFactory>() {{
                    add(new OutputGuesserGameFactory(game));
                    add(new ResultGuesserGameFactory(game));

                    // add all the chapter true or false levels
                    add(new TrueOrFalseGameFactory<>(ChapterOne.NAME, ChapterOne::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterTwo.NAME, ChapterTwo::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterThree.NAME, ChapterThree::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterFour.NAME, ChapterFour::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterFive.NAME, ChapterFive::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterSix.NAME, ChapterSix::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterSeven.NAME, ChapterSeven::new, game));
                    add(new TrueOrFalseGameFactory<>(ChapterEight.NAME, ChapterEight::new, game));
                }}).stream()
                .sorted(Comparator.comparing(f -> f.name))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
