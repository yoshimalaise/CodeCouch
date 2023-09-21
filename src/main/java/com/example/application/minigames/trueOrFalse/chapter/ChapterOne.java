package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterOne extends BaseChapter {

    public static final String NAME = "1. Introduction";

    public ChapterOne() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("The Dewey decimal system is a hierarchical classification consisting of 10 main classes, each with 10 divisions and 10 sections per division.");
            add("Documents can appear in more than one class of the Dewy decimal system. This can cause issues as there is typically only one physical copy.");
            add("The library of Congress (LC) classification is an alternative to the Dewey decimal system");
            add("The basic idea behind associative indexing is a provision whereby any item may be used to select immediately and automatically another");
            add("One of the main contributions of the memex was that it allows tying items together using a form of associative indexing");
            add("Ted Nelson coined the term Hypertext in 1960");
            add("Transclusion is the act of embedding parts of a document in another document via reference rather than by copying.");
            add("According to Ted Nelson the WYSIWYG paradigm limited the shape of digital documents as they became stuck as closed rectangular objects that cannot be penetrated by outside markings.");
            add("The mouse was first shown by Douglas Engelbart in his talk which is now dubbed \"The mother of all demos\"");
            add("HyperCard was a hypermedia system where information was stored in a series of cards tht are arranged into stacks");
            add("The Advanced Research Projects Agency Network (ARPANET) presented the first operational packet switching network");
            add("In 1971 Email was released as one of the applications on ARPANET.");
            add("The Transmission Control Protocol (TCP) replaced the earlier Network Control Protocol (NCP) and provided reliable and ordered transmission of byte stream between two endpoins");
            add("TCP/IP contains 4 abstraction layers: The application layer, The transport layer, the Internet layer and the Link layer");
            add("The Internet layer in TCP/IP is responsible for addressing hosts and packet routing.");
            add("The application layer is the top layer in TCP/IP.");
            add("The original public release of the World Wide Web in 1991 already contained the HyperText Transfer Protocol, the HyperText Markup Language a HTTP Server and a Web browser");
            add("Web 2.0 is characterised by users becoming authors that are creating information");
            add("Web 3.0 adds explicit semantics to web resources through the use of ontologies in order to create a Machine-interpretable web");
            add("Internet of Things (IoT) devices are physical objects with embedded computing functionality that actively or passively participate in the web.");
            add("RFID tagged objects whose location can be determined and shared in an online system form part of the Internet of Things");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>(){{
            add("The Dewey decimal system contains a total of around 100.000 sections for quick retrieval of documents according to subject.");
            add("Classes in the Dewey decimal system are mutually exclusive, so there is never any confusion on where to retrieve the physical document.");
            add("Whenever the human mind tries to remember something it does so by ");
            add("The memex was a device proposed by Vannevar Bush in 1945 for the efficient retrieval of documents using the Dewey Decimal system or the Library of Congress (LC) classification");
            add("The term Hypertext was first used in early 2000");
            add("HTML allows bidirectional (bivisible) links");
            add("The mouse was first shown by Ted Nelson in his talk which is now dubbed \"The mother of all demos\"");
            add("The first email application became available in 1993.");
            add("The Network Control Protocol (NCP) replaced the earlier Transmission Control Protocol (TCP) and provided reliable and ordered transmission of byte stream between two endpoins");
            add("The internet layer is the lowest layer in TCP/IP");
            add("TCP/IP contains 7 layers ranging from the Application layer at the top to the Physical layer at the bottom");
            add("Web 2.0 is characterised by new technologies such as websockets and server push that allow real-time collaboration.");
            add("Web 3.0 is characterised by new technologies such as websockets and server push that allow real-time collaboration.");
            add("Web 3.0 is characterised by users becoming authors that are creating information.");
            add("In the paper \"As We May Think\" Vannevar Bush explains how Web 3.0 semantics can be used to power automatic reasoners for AI applications");
            add("UDP lives in the Application layer of TCP/IP");
            add("FTP is part of the Internet layer of TCP/IP");
            add("TCP is an unordered transmission protocol for a byte stream between two endpoints.");
        }};
    }
}
