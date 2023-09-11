package com.example.application.minigames.trueOrFalse;

import com.example.application.model.GameTutorial;

public class TrueOrFalseGameTutorial extends GameTutorial {

    public TrueOrFalseGameTutorial(String chapter) {
        super(chapter + " - True or False?",
                "In the following rounds you will be presented with a list of statements about the " +
                 chapter + " chapter. However one of the statements is not like the other, look at the question to see if you have to find the correct or the wrong statement!",
                "");
    }
}
