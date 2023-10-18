package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterSeven extends BaseChapter {
    public static final String NAME = "7. XML";

    public ChapterSeven() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("XML is a meta language used for defining other markup languages.");
            add("XML is often used to export/import data from one system to another.");
            add("A well-formed XML document always contains exactly one root node.");
            add("attribute nodes are key value pairs that can be added to element nodes.");
            add("element nodes can contain any number of attribute nodes.");
            add("Text belonging to element or attribute nodes is represented as a text node.");
            add("A comment node will be ignored by the parser and can be used to provide additional information for people reading the XML file.");
            add("The '<? ... ?>' syntax is used to denote instruction processing nodes used to pass information to a specific application.");
            add("An XML document is well-formed if it follows the rules of the XML specification.");
            add("An XML document is valid if it satisfies its Document Type Definition or XML Schema.");
            add("Every valid and well-formed XHTML document is a valid and well-formed XML document.");
            add("In a XHTML document the <title> element must be the first element in the <head>.");
            add("XML Schema introduces datatypes and inheritance which does not exist in Document Type Definition (DTD)");
            add("XPath can be used to address XML documents.");
            add("SAX is an event based programming API for reading XML documents");
            add("The DOM parser must read and parse the entire document before it can be manipulated.");
            add("XML Transformations can be used to create websites by converting XML to XHTML.");
            add("XML-RPC is a technology that makes remote procedure calls possible between systems written in different programming languages.");
            add("The eXtensible Information Management Architecture (XIMA) provides a generic XML database interface instead of interacting with an object database directly.");
            add("The eXtensible Information Management Architecture (XIMA) can select an appropriate XSLT stylesheet based on the User-Agent HTTP header field.");
            add("Scalable Vector Graphics (SVG) are an application of XML.");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>() {{
            add("XML is a programming language.");
            add("XML is a database.");
            add("An XML document is valid if it follows the rules of the XML specification.");
            add("An XML document is well-formed if it satisfies its Document Type Definition or XML Schema.");
            add("XML is a presentation language.");
            add("The matching of XML tags is case insensitive.");
            add("Every valid and well-formed XML document is a valid and well-formed XHTML document.");
            add("In an XHTML document the <head> and <body> elements can be omitted.");
            add("The DOM is an event based programming API for reading XML documents");
            add("The Document Object Model only exists for HTML");
            add("The DOM parser is suited for large applications because of its low memory usage");
            add("A DOM Parser needs less memory than SAX parser");
            add("XML-RPC is often faster than specialised protocols that are used in closed networks.");
            add("The eXtensible Information Management Architecture (XIMA) is based on relational database technology.");
            add("The eXtensible Information Management Architecture (XIMA) is built on top of CGI technology.");
        }};
    }
}
