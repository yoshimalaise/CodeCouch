package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterFour extends BaseChapter{
    public static final String NAME = "4. Web Application Frameworks";

    public ChapterFour() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>() {{
            add("The Model-View-Controller design pattern is used to avoid the mix of application logic and view.");
            add("In MVC the model contains the state and the business logic.");
            add("In MVC the model is responsible for notifying the views when the state changes.");
            add("In MVC the view is responsible for rendering the data coming from the model.");
            add("In MVC the view is responsible for notifying the controller when there is a change.");
            add("In MVC the controller is responsible for handling interactions with the view.");
            add("In MVC the controller is responsible for transforming view interactions into operations on the model.");
            add("The Java Spring framework contains many modular components to create server side applications.");
            add("Technologies such as Electron and NW.js can be used to create desktop applications using web technologies.");
            add("Angular, React and Vue.js are client side web frameworks to support creating RIAs");
            add("Component based frameworks (such as React) allow users to define rich reusable components");
            add("Using tools such as React Native one can even create native mobile interfaces using JavaScript");
            add("Angular offers 2-way data binding which allows us te describe the view in a declarative way that will update automatically when the model changes.");
            add("Web Content Management Systems offer functionality related to publishing, user management and versioning.");
            add("The target users of Web Frameworks are Software Engineers.");
            add("The target users of Content Management Systems are content developers without software engineering experience.");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>(){{
            add("In MVC the controller contains the state and the business logic.");
            add("In MVC the controller is responsible for notifying the views when the state changes.");
            add("In MVC the view is responsible for rendering the data coming from the controller.");
            add("In MVC the model is responsible for notifying the controller when there is a change.");
            add("In MVC the model is responsible for handling interactions with the view.");
            add("In MVC the controller is responsible for transforming view interactions into operations on the view.");
            add("Online Content Management Systems typically create static webpages based on the content.");
            add("The target users of Content Management Systems are Software Engineers.");
            add("The target users of Web Frameworks are content developers without software engineering experience.");
        }};
    }
}
