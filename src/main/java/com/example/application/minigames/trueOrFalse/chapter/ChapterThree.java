package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterThree extends BaseChapter {
    public static final String NAME = "3. HTML5";

    public ChapterThree() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("HTML is an application of the Standard Generalized Markup Language (SGML).");
            add("HTML tags are used to define the structure of a webpage.");
            add("HTML tags can be nested.");
            add("Attributes are key/value pairs that can be added to tags.");
            add("The browser translates HTML documents into a Document Object Model.");
            add("The DOM has 5 types of nodes, the document node, element nodes, text nodes, attribute nodes and comment nodes.");
            add("HTML supports unidirectional embedded hyperlinks");
            add("HTML 2.0 was first released in 1995.");
            add("The World Wide Web Consortium is responsible for supervising the development of the HTML specification.");
            add("XHTML is a reformulation of HTML to make it an XML application (instead of SGML.");
            add("One of the key features of the HTML5 spec is that it forces identical error handling across browsers");
            add("HTML5 added new semantic elements <article>,<section>,<header>,<footer> or <nav> to use instead of the default <div>.");
            add("The canvas element is a new addition in HTML5 that allows JavaScript to draw arbitrary graphics.");
            add("HTML5 contains built-in media elements including <video>, <audio> and <embed>.");
            add("On submission the filled in information of HTML forms is sent to the server as name/value pairs.");
            add("HTML forms can use an HTTP GET or an HTTP POST request.");
            add("Scalable Vector Graphics are a way to define graphics in XML format.");
            add("SVG are resolution independent.");
            add("PNG are resolution dependent.");
            add("WebGL adds support for GPU accelerated 3D graphics to the web.");
            add("sessionStorage is deleted when the browser closes");
            add("localStorage is a way to keep data even when the browser closes");
            add("Web workers can be used to execute JavaScript code in a background process (thread)");
            add("The WebSocket API offers a bidirectional, full duplex socket connection between the server and client.");
            add("An EventSource object can be used in HTML5 to enable server-sent events.");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>(){{
            add("HTML supports bidirectional embedded hyperlinks");
            add("HTML tags are used both for the structure and the styling of the content");
            add("The advantage of XHTML over traditional HTML is that it is a lot more forgiving for errors such as missing closing tags.");
            add("HTML5 was quite controversial as it introduced some features that break backwards compatibility with HTML4.01.");
            add("Having a HTML5 application with errors can cause unexpected issues as browsers can have differing error handling techniques");
            add("In the HTML5 spec the W3C promotes the use of external plug-ins for content that does not map nicely to structured documents");
            add("The World Wide Web Consortium is responsible for supervising the development of the JavaScript specification.");
            add("XHTML added new semantic elements <article>,<section>,<header>,<footer> or <nav> to use instead of the default <div>.");
            add("Since HTML5 the use of the canvas element in combination with JavaScript is recommend instead of relying on tags to increase the separation of concerns.");
            add("HTML forms can only use HTTP GET requests, no POST requests.");
            add("HTML forms can only use HTTP POST requests, no GET requests.");
            add("SVG are resolution dependent.");
            add("PNG are resolution independent.");
            add("The lack of GPU acceleration make WebGL performance limited compared to desktop applications.");
            add("localStorage is deleted when the browser closes");
            add("sessionStorage is a way to keep data until the user uses the log out action, even when the browser closes");
            add("JavaScript uses a separate thread to handle each event, this is done to prevent the ui from being unresponsive");
            add("Web Workers can be used to update the DOM in background tasks.");
            add("The HTML5 geolocation API introduces a privacy risk as any webpage can submit detailed location data to the server without the user being aware.");
        }};
    }
}
