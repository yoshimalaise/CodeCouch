package com.example.application.minigames.trueOrFalse;

import com.example.application.bl.Game;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.trueOrFalse.chapter.BaseChapter;
import com.example.application.model.BaseGameFactory;

import java.util.function.Supplier;

public class TrueOrFalseGameFactory<T extends BaseChapter> extends BaseGameFactory {
    private final Supplier<T> supplier;

    public TrueOrFalseGameFactory(String name, Supplier<T> supplier, Game game) {
        super(name, game);
        this.supplier = supplier;
    }

    @Override
    public BaseMiniGame build() {
        BaseChapter c = supplier.get();
        return new TrueOrFalseGame(c, game);
    }
}
