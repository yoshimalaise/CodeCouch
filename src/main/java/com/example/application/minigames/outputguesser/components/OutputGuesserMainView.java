package com.example.application.minigames.outputguesser.components;

import com.example.application.bl.Game;
import com.example.application.bl.Server;
import com.example.application.bl.jsgenerators.XYZSnippetGenerator;
import com.example.application.bl.utils.MyUtils;
import com.example.application.minigames.outputguesser.ProblemType;
import com.example.application.model.answers.StringAnswer;
import com.example.application.model.Player;
import com.example.application.model.jsTypes.XYZResult;
import com.example.application.views.desktop.components.CodeSnippet;
import com.example.application.views.desktop.components.PlayersOverview;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.PickOneOptionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


import java.util.*;

import static java.lang.Thread.sleep;

public class OutputGuesserMainView extends BaseView {
    private int roundCtr;
    private final int maxRoundCounts = 5;
    private ProblemType problemType;
    private String codeSnippet;
    private String solution;

    private PlayersOverview playersOverview;

    private List<StringAnswer> answers = new ArrayList<>();

    private ArrayList<Button> buttons = new ArrayList<>();

    public OutputGuesserMainView(Game g) {
        super(g);
        roundCtr = 0;
        this.loadNextRound();
    }

    private void loadNextRound() {
        // load all vars for the new round
        this.roundCtr++;
        if (this.roundCtr > this.maxRoundCounts) {
            game.loadNextMiniGame();
            return;
        }
        game.clearPlayersRoundInfo();
        this.answers = new ArrayList<>();
        List<ProblemType> types = new ArrayList<ProblemType>() {{
          add(ProblemType.X_PROBLEM);
          add(ProblemType.Y_PROBLEM);
          add(ProblemType.Z_PROBLEM);
        }};
        Collections.shuffle(types);
        this.problemType = types.get(0);
        this.codeSnippet = XYZSnippetGenerator.generateXYZSnippet();
        game.getContainer().executeJavaScript(this.codeSnippet + XYZResult.getExtractionString(), XYZResult.class, (res) -> {
                // generate results for the generated code
                String q = "What is the value of " + problemType
                        +  " after executing the following program?";
                solution = "" + (this.problemType == ProblemType.X_PROBLEM
                        ? res.getX()
                        : problemType == ProblemType.Y_PROBLEM
                        ? res.getY()
                        : res.getZ());
                List<String> possibleAnswers = new ArrayList<>() {{ add(solution); }};
                Random rnd = new Random();
                // TODO: generate smarter alternative responses
                while (possibleAnswers.size() != 4){
                    int tmp = rnd.nextInt(-100, 100);
                    if (possibleAnswers.stream().noneMatch(s -> s.equals(tmp + ""))) {
                        possibleAnswers.add(""+tmp);
                    }
                }
                Collections.shuffle(possibleAnswers);

                // show the components for the new round
                this.updateUIInLock(() -> {
                    this.removeAll();

                    HorizontalLayout roundOverview = new HorizontalLayout();
                    roundOverview.setAlignItems(Alignment.END);
                    roundOverview.add(new Span("Round "  + roundCtr + "/" + maxRoundCounts));

                    HorizontalLayout answersContainer = new HorizontalLayout();
                    buttons.clear();
                    for (String possibleAnswer : possibleAnswers) {
                        Button btn = new Button();
                        btn.setText(possibleAnswer);
                        answersContainer.add(btn);
                        buttons.add(btn);
                    }
                    answersContainer.setSpacing(true);
                    answersContainer.setAlignItems(Alignment.STRETCH);
                    answersContainer.setVerticalComponentAlignment(Alignment.CENTER);

                    this.playersOverview = new PlayersOverview(game);
                    this.add(roundOverview, new H1(q), new CodeSnippet(codeSnippet), answersContainer, playersOverview);
                });


                game.switchAllMobileClientsToView(p -> new PickOneOptionView(possibleAnswers, p));
            });
    }

    public void handleAnswer(Player player, String answer) {
        this.answers.add(new StringAnswer(player, answer));
        if (game.allPlayersAnswered()){
            // calculate all the scores for this round
            int rightAnswersCnt = 0;
            for (StringAnswer a : answers) {
                if (a.answer.equals(solution)) {
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
            this.showSolution();
            try {
                sleep(4000);
                this.loadNextRound();
            } catch (InterruptedException e) {
                this.loadNextRound();
            }
        }
    }

    private void showSolution() {
        this.updateUIInLock(() -> {
            for (Button button : buttons) {
                if (button.getText().equals(solution)) {
                    button.addClassName("correct-answer");
                }
            }
        });
    }
}
