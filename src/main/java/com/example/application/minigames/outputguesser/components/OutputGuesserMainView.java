package com.example.application.minigames.outputguesser.components;

import com.example.application.bl.jsgenerators.XYZSnippetGenerator;
import com.example.application.minigames.outputguesser.ProblemType;
import com.example.application.model.jsTypes.XYZResult;
import com.example.application.views.desktop.components.CodeSnippet;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.PickOneOptionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


import java.util.*;

public class OutputGuesserMainView extends BaseView {
    private int roundCtr;
    private ProblemType problemType;
    private String codeSnippet;
    private String solution;

    public OutputGuesserMainView() {
        roundCtr = -1;
        this.loadNextRound();
    }

    private void loadNextRound() {
        // load all vars for the new round
        List<ProblemType> types = new ArrayList<ProblemType>() {{
          add(ProblemType.X_PROBLEM);
          add(ProblemType.Y_PROBLEM);
          add(ProblemType.Z_PROBLEM);
        }};
        Collections.shuffle(types);
        this.problemType = types.get(0);
        this.roundCtr++;
        this.codeSnippet = XYZSnippetGenerator.generateXYZSnippet();
        DesktopContainer.executeJavaScript(this.codeSnippet + XYZResult.getExtractionString(), XYZResult.class, (res) -> {
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
            this.removeAll();
            HorizontalLayout answersContainer = new HorizontalLayout();
            for (String possibleAnswer : possibleAnswers) {
                Button btn = new Button();
                btn.setText(possibleAnswer);
                answersContainer.add(btn);
            }
            answersContainer.setSpacing(true);
            answersContainer.setAlignItems(Alignment.STRETCH);
            answersContainer.setVerticalComponentAlignment(Alignment.CENTER);
            this.add(new H1(q), new CodeSnippet(codeSnippet), answersContainer);
            MobileContainer.switchAllMobileClientsToView(p -> new PickOneOptionView(possibleAnswers, p));
        });
    }
}
