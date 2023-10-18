package com.example.application.minigames.trueOrFalse;

import com.example.application.bl.Game;
import com.example.application.bl.commands.BaseCommand;
import com.example.application.bl.commands.StringAnswerCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.trueOrFalse.chapter.BaseChapter;
import com.example.application.minigames.trueOrFalse.model.TrueOrFalseRound;
import com.example.application.minigames.trueOrFalse.model.TrueOrFalseType;
import com.example.application.model.GameTutorial;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.example.application.views.mobile.WaitView;

import java.util.*;

public class TrueOrFalseGame implements BaseMiniGame {
    private Random r = new Random();
    private TrueOrFalseView view;

    private BaseChapter chapter;

    private Game game;


    public TrueOrFalseGame(BaseChapter chapter, Game game) {
        this.chapter = chapter;
        this.game = game;
    }

    @Override
    public void handleCommand(BaseCommand command) {
        if (command instanceof StringAnswerCommand c) {
            view.handleAnswer(c.player, c.getAnswer());
        }
    }

    @Override
    public GameTutorial getTutorial() {
        return new TrueOrFalseGameTutorial(chapter.getChapterName());
    }

    @Override
    public BaseView getDesktopView() {
        if (this.view == null) {
            this.setupGame();
        }
        return this.view;
    }

    @Override
    public Game getGame() {
        return game;
    }

    private void setupGame() {
        // we will generate 10 rounds based on the Info we get from the chapter
        List<TrueOrFalseRound> rounds = new ArrayList<>();
        List<String> trueStatements = chapter.getTrueStatements();
        List<String> falseStatements = chapter.getFalseStatements();
        Collections.shuffle(trueStatements);
        Collections.shuffle(falseStatements);
        int correctCtr = 0;
        int falseCtr = 0;
        for (int i = 0; i < 10; i++) {
            // We get a value between 1 and 10
            int tmp = r.nextInt(1, 11);
            // on 1-4 We do a pick the false one round
            if (tmp <= 4) {
                List<String> options = new ArrayList<>();
                String falseStatement = falseStatements.get(falseCtr++ % falseStatements.size());
                options.add(falseStatement);
                for (int j = 0; j < 3; j++) {
                    options.add(trueStatements.get(correctCtr++ % trueStatements.size()));
                }
                Collections.shuffle(options);
                rounds.add(new TrueOrFalseRound(
                        "Which of the following statements is false?",
                        TrueOrFalseType.PICK_THE_FALSE_ONE,
                        options,
                        falseStatement
                ));
            }
            // on 5-8 We do a pick the true one round
            if (tmp >= 5 && tmp <= 8) {
                List<String> options = new ArrayList<>();
                String trueStatement = trueStatements.get(correctCtr++ % trueStatements.size());
                options.add(trueStatement);
                for (int j = 0; j < 3; j++) {
                    options.add(falseStatements.get(falseCtr++ % falseStatements.size()));
                }
                Collections.shuffle(options);
                rounds.add(new TrueOrFalseRound(
                        "Which of the following statements is true?",
                        TrueOrFalseType.PICK_THE_TRUE_ONE,
                        options,
                        trueStatement
                ));
            }
            // on 9 or 10 we do a true or false round
            if (tmp >= 9 && tmp <= 10) {
                String solution;
                String statement;
                if (r.nextInt(1, 3) > 1) {
                    statement = trueStatements.get(correctCtr++ % trueStatements.size());
                    solution = "True";
                } else {
                    statement = falseStatements.get(falseCtr++ % falseStatements.size());
                    solution = "False";
                }
                rounds.add(new TrueOrFalseRound(
                        "Is the following statement True or False?\n\n" + statement,
                        TrueOrFalseType.TRUE_OR_FALSE,
                        Arrays.asList("True","False"),
                        solution
                ));
            }
        }

        this.view = new TrueOrFalseView(chapter.getChapterName(), rounds, game);
    }

}
