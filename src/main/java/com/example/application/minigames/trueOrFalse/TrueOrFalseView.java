package com.example.application.minigames.trueOrFalse;

import com.example.application.bl.Game;
import com.example.application.bl.utils.MyUtils;
import com.example.application.minigames.trueOrFalse.model.TrueOrFalseRound;
import com.example.application.model.Player;
import com.example.application.model.answers.StringAnswer;
import com.example.application.views.desktop.components.AnswerBox;
import com.example.application.views.desktop.components.PlayersOverview;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.PickOneOptionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class TrueOrFalseView extends BaseView {

    private String chapter;

    private List<TrueOrFalseRound> rounds;

    private int roundCtr;

    private PlayersOverview playersOverview;

    private List<StringAnswer> answers = new ArrayList<>();

    private List<AnswerBox> answerBoxes = new ArrayList<>();

    public TrueOrFalseView(String chapter, List<TrueOrFalseRound> rounds, Game game) {
        super(game);
        this.chapter = chapter;
        this.rounds = rounds;
        roundCtr = -1;
        this.loadNextRound();
    }

    private void loadNextRound() {
        this.roundCtr++;
        if (this.roundCtr == this.rounds.size()) {
            game.loadNextMiniGame();
            return;
        }
        game.clearPlayersRoundInfo();
        this.answers = new ArrayList<>();

        this.updateUIInLock(() -> {
            this.removeAll();

            HorizontalLayout roundOverview = new HorizontalLayout();
            roundOverview.setAlignItems(Alignment.END);
            roundOverview.add(new Span("Round "  + (roundCtr + 1) + "/" + rounds.size()));

            VerticalLayout question = new VerticalLayout();
            for (String s : rounds.get(roundCtr).description.split("\n")) {
                question.add(new Span(s));
            }

            VerticalLayout answersContainer = new VerticalLayout();
            answerBoxes.clear();
            for (String possibleAnswer : rounds.get(roundCtr).options) {
                AnswerBox a = new AnswerBox(possibleAnswer);
                answerBoxes.add(a);
                answersContainer.add(a);
            }
            answersContainer.setSpacing(true);
            answersContainer.setAlignItems(Alignment.STRETCH);
            answersContainer.setHorizontalComponentAlignment(Alignment.CENTER);

            this.playersOverview = new PlayersOverview(game);
            add(roundOverview, question, answersContainer, playersOverview);
        });

        game.switchAllMobileClientsToView(p -> new PickOneOptionView(rounds.get(roundCtr).options , p));
    }

    public void handleAnswer(Player player, String answer) {
        this.answers.add(new StringAnswer(player, answer));
        if (game.allPlayersAnswered()){
            // calculate all the scores for this round
            int rightAnswersCnt = 0;
            for (StringAnswer a : answers) {
                if (a.answer.equals(rounds.get(roundCtr).correctAnswer)) {
                    int score = game.getPlayers().size() - rightAnswersCnt;
                    rightAnswersCnt++;
                    a.player.increaseScore(score);
                } else {
                    a.player.increaseScore(0);
                }
            }
        }
        game.getPlayers().sort((p1, p2) -> p2.getScore() - p1.getScore());
        this.updateUIInLock(() -> {
            playersOverview.update();
        });

        if (game.allPlayersAnswered()){
            try {
                this.showSolution();
                sleep(4000);
                this.loadNextRound();
            } catch (InterruptedException e) {
                this.loadNextRound();
            }
        }
    }

    private void showSolution() {
        this.updateUIInLock(() -> {
            for (AnswerBox b : answerBoxes) {
                if (b.getText().equals(rounds.get(roundCtr).correctAnswer)) {
                    b.markCorrect();
                }
            }
        });
    }
}
