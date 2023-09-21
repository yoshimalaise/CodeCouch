package com.example.application.minigames.resultguesser;

import com.example.application.bl.Game;
import com.example.application.bl.jsgenerators.FunctionCallSnippetGenerator;
import com.example.application.bl.jsgenerators.XYZSnippetGenerator;
import com.example.application.bl.utils.MyUtils;
import com.example.application.minigames.outputguesser.ProblemType;
import com.example.application.model.Player;
import com.example.application.model.answers.StringAnswer;
import com.example.application.model.jsTypes.JSFunctionCallResult;
import com.example.application.model.jsTypes.XYZResult;
import com.example.application.views.desktop.components.AnswerBox;
import com.example.application.views.desktop.components.CodeSnippet;
import com.example.application.views.desktop.components.PlayersOverview;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.NumberInputView;
import com.example.application.views.mobile.PickOneOptionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class ResultGuesserGameView extends BaseView {
    private int x;
    private int y;
    private int z;

    Random r = new Random();

    private int roundCtr;
    private final int maxRoundCounts = 5;

    private String codeSnippet;
    private String solution;

    private PlayersOverview playersOverview;

    private List<StringAnswer> answers = new ArrayList<>();

    public ResultGuesserGameView() {
        roundCtr = 0;
        this.loadNextRound();
    }

    private void loadNextRound() {
        // load all vars for the new round
        this.roundCtr++;
        if (this.roundCtr > this.maxRoundCounts) {
            Game.loadNextMiniGame();
            return;
        }
        Game.clearPlayersRoundInfo();
        this.answers = new ArrayList<>();

        x = r.nextInt(-50,50);
        y = r.nextInt(-50,50);
        z = r.nextInt(-50,50);
        this.codeSnippet = FunctionCallSnippetGenerator.generateSnippet();
        DesktopContainer.executeJavaScript(this.codeSnippet + JSFunctionCallResult.getExtractionString(x,y,z), JSFunctionCallResult.class, (res) -> {
            // generate results for the generated code
            String q = "What would be the result of the function call if we pass the following arguments?";
            solution = "" + res.getRes();

            // show the components for the new round
            this.updateUIInLock(() -> {
                this.removeAll();

                HorizontalLayout roundOverview = new HorizontalLayout();
                roundOverview.setAlignItems(Alignment.END);
                roundOverview.add(new Span("Round "  + roundCtr + "/" + maxRoundCounts));

                HorizontalLayout argsBoxContainer = new HorizontalLayout();
                argsBoxContainer.add(new AnswerBox("x: " + x+""));
                argsBoxContainer.add(new AnswerBox("y: " + y+""));
                argsBoxContainer.add(new AnswerBox("z: " + z+""));
                argsBoxContainer.setSpacing(true);
                argsBoxContainer.setAlignItems(Alignment.STRETCH);
                argsBoxContainer.setVerticalComponentAlignment(Alignment.CENTER);

                this.playersOverview = new PlayersOverview();

                this.add(roundOverview, new H1(q), argsBoxContainer, new CodeSnippet(codeSnippet), playersOverview);
            });

            MobileContainer.switchAllMobileClientsToView(NumberInputView::new);
        });
    }
    public void handleAnswer(Player player, String answer) {
        this.answers.add(new StringAnswer(player, answer));
        if (MyUtils.allPlayersAnswered()){
            // calculate all the scores for this round
            int rightAnswersCnt = 0;
            for (StringAnswer a : answers) {
                if (a.answer.equals(solution)) {
                    int score = Game.getPlayers().size() - rightAnswersCnt;
                    rightAnswersCnt++;
                    a.player.increaseScore(score);
                } else {
                    a.player.increaseScore(0);
                }
            }
        }
        Game.getPlayers().sort((p1, p2) -> p2.getScore() - p1.getScore());
        this.updateUIInLock(() -> {
            playersOverview.update();
        });

        if (MyUtils.allPlayersAnswered()){
            try {
                sleep(4000);
                this.loadNextRound();
            } catch (InterruptedException e) {
                this.loadNextRound();
            }
        }
    }

}
