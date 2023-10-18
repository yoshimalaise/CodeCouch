package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterEight extends BaseChapter{
    public final static String NAME = "8. Web 2.0";
    public ChapterEight() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("Web 2.0 refers to the use of the web as a platform through the use of user-generated content.");
            add("In the Social Web the end user is not only a participant but also a content creator (prosumer) and democratic elements are added to the system (e.g. user ratings).");
            add("Rich Internet Applications (RIA) are web applications that bring the desktop experience to the browser through the use of interactions such as drag and drop.");
            add("In Web 2.0 the use of Service Oriented Architectures (SOAs) enable the sharing of information and services between multiple applications.");
            add("Wikipedia is a prime example of a Web 2.0 application.");
            add("Youtube is a prime example of a Web 2.0 application.");
            add("reddit is a prime example of a Web 2.0 application.");
            add("A key characteristic of a Wiki is the fact that any user can create new wiki pages or edit existing ones with requiring special software on the client.");
            add("Contrary to a Wiki a blog requires a Chronological order of the content.");
            add("One reason blogs are often a powerful channel in politics is the fact that they are harder to control than print or broadcasting networks.");
            add("Instagram tags are an example of folksonomy.");
            add("X (formerly known as Twitter) can be seen as a mirco-blogging platform");
            add("Many Web 2.0 applications offer their content for free and make their money by serving advertisements.");
            add("Google AdSense makes use of a lot knowledge about the user to recommend relevant ads to the specific user visiting the website.");
            add("Pay-per-click payment means that the advertiser will have to pay a certain amount for every time a user clicks on their advertisement.");
            add("Pay-per-impression payment means that the advertiser will have to pay a certain amount for every time a user is served advertisement.");
            add("Software-as-a-Service is a pattern in which you rent out access to a piece of software (for example via a hosted online service) via a recurring fee rather than selling a direct license that gives the customer ownership.");
            add("In order for RIAs to become highly responsive they often rely on asynchronous and partial content upgrades.");
            add("HTML5 and Open Web APIs make it possible to develop RIAs that run directly in the browser without requiring any plugins.");
            add("Asynchronous Javascript and XML (AJAX) is a possibility how partial updates of resources can be realised on the web.");
            add("Despite the name, the data transferred during AJAX calls does not have to be in the XML format.");
            add("In a typical AJAX call, the client would send a request to server which would send data back to client. The client would then make use of the DOM to dynamically change the presented information based on the received data.");
            add("Service-Oriented Architectures provide interoperability between different programming languages and even operating systems.");
            add("REST is an architectural style for distributed systems that requires separation of concerns between client and server such that they can be developed and replaced independently.");
            add("Big Web Services make use of Universal Description, Discovery and Integration, a sort of registry describing all available business services.");
            add("A SOAP message consists of an <Envelope> element which contains and optional <Header> element and a <Body> element.");
            add("A SOAP request is often sent via a HTTP POST request and will invoke a remote procedure call.");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>() {{
            add("Web 2.0 refers to new technology that makes real-time collaboration easier.");
            add("Folksonomies are taxonomies that arise naturally by the community for example through the use of tags.");
            add("Web 2.0 drastically reduced the collaboration between online services due to increased cost of using scrapers on Rich Internet Applications");
            add("The idea of the Long Tail states that only a small portion of the content gets the majority of the attention, so if you cannot make it in the top 5% your project is not economically viable");
            add("www.vub.be is a prime example of a Web 2.0 application.");
            add("The website of the world health organisation is a prime example of a web 2.0 application.");
            add("For a folksonomy to work efficiently a top-down approach with fixed terminology is needed.");
            add("The process to enrol to AdSense is very complicated and expensive, making add supported websites only accessible for big players.");
            add("Using AdSense the creator of the website can pick exactly which ads are shown on their website.");
            add("Web 2.0 came with a new legal framework on how ownership and copyright issues were handled.");
            add("Web 2.0 presents a shift of power from communities to large controlled media.");
            add("Rich Internet Applications are applications that are installed on the clients PC, but that can be launched by opening a url from the browser, thus creating a more streamlined experience.");
            add("HTTP 1.0 allows the server to initiate updates to the client (e.g. when there is an incoming message in a chat application)");
            add("AJAX is a new technology introduced in Web 2.0 for the partial updating of web pages.");
            add("The introduction of AJAX in Web 2.0. came with the downside that managing application state across multiple pages became a lot more challenging.");
            add("One of the advantages of the new AJAX technology is that it makes partial page updates possible, even in browsers with disabled JavaScript functionality.");
            add("Service Oriented Architectures often become very brittle as many services are tightly coupled.");
            add("The REST architectural style adds a stateful layer on top of the stateless HTTP protocol.");
            add("A SOAP request is often sent via a HTTP GET request and will invoke a remote procedure call.");
            add("SOAP went out of favor because it was very tied to the Java eco system.");
        }};
    }
}
