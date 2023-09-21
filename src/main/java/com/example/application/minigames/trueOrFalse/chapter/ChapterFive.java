package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterFive extends BaseChapter{
    public static final String NAME = "5. CSS3 & Responsive Design";

    public ChapterFive() {
        super(NAME);
    }

    // TODO: continue after slide 16

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("The main goal of Cascading Style Sheets is the separation of presentation and content.");
            add("The HTML spec allows us to load different stylesheets depending on the media attribute (e.g. print vs screen).");
            add("A css rule consists of 2 parts a selector and a declaration block.");
            add("Every line a declaration block of a css rule consists of one property and value pair.");
            add("In css the '*' selector selects all elements in the document.");
            add("Type selectors such as 'p' can be used to select tags of a certain type in the document.");
            add("h1 { display: none } will hide all h1 elements in the document unless overwritten by more precise rule");
            add("In css the '#' can be used to select an element by id.");
            add("In css the '.' can be used to select elements with a certain class.");
            add("The css rule 'h1.main { ... }' will select h1 elements with the class main.");
            add("The css rule 'p>a { ... }' will select a elements that are direct children of p elements.");
            add("The css rule p[type=\"new\"] { ... } can be used to select all p elements with type attribute value 'new' (equality)");
            add("The css rule p[type^=\"no\"] { ... } can be used to select all p elements with type attribute value starting with 'no'");
            add("The css rule p[type*=\"no\"] { ... } can be used to select all p elements with type attribute value starting containing substring 'no'");
            add("The css pseudo selector ':hover' can be used to apply certain styles only when the user is hovering over the element.");
            add("CSS use the following internal priorities: (1) ids, (2) classes and attributes, (3) elements");
            add("In css rules that are more specific than others have preference.");
            add("CSS can be included in 3 ways: inline style, internal style sheet and external style sheet");
            add("The use of inline style is discouraged.");
            add("The css overriding priorities are (high-to-low): (1) inline style, (2) internal style sheets, (3) external style sheets, (4) default browser style");
            add("The Box Model wraps every single HTML element and contains padding, border and margin.");
            add("In the box model the margin is the transparent area outside the border.");
            add("In the box model the padding is the transparent area around the content.");
            add("In the box model the border goes around the padding.");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>(){{
            add("A css rule consists of 3 parts: A subject, a predicate and an object.");
            add("In css the '.' can be used to select an element by id.");
            add("In css the '#' can be used to select elements with a certain class.");
            add("An HTML element can have exactly one class.");
            add("The css rule 'h1.main { ... }' will select elements of the type h1 or main.");
            add("The css rule 'p>a { ... }' will select all a elements as long as they are descendants of p elements.");
            add("In css the space ' ' can be used as a logical or to select elements that satisfy at least one of the selectors as opposed to the '.' which serves as logical and.");
            add("The css rule p[type*=\"no\"] { ... } can be used to select all p elements with type attribute value starting with 'no'");
            add("The css rule p[type^=\"no\"] { ... } can be used to select all p elements with type attribute value starting containing substring 'no'");
            add("CSS use the following internal priorities: (1) classes and attributes, (2) ids, (3) elements");
            add("For identical CSS selector, all collisions after the first one will be ignored, so the first one is applied.");
            add("The use of internal style sheets is heavily encouraged as it makes it easier to move the html without breaking links");
            add("The css overriding priorities are (high-to-low): (1) external style sheets, (2) internal style sheets, (3) inline style, (4) default browser style");
            add("In the box model the padding is the transparent area outside the border.");
            add("In the box model the margin is the transparent area around the content.");
            add("In the box model the border goes around the margin.");
        }};
    }
}
