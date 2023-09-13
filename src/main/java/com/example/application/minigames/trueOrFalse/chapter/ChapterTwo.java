package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterTwo extends BaseChapter {
    public static final String NAME= "2. Architecture";

    public ChapterTwo() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("A Domain Name Service (DNS) is used to obtain an IP address for a given website (e.g. www.google.be).");
            add("HTTP uses a TCP connection to transfer data.");
            add("HTTP 1.0 communication always has to be initiated by the client.");
            add("Both Uniform Resource Locator (URL) and Uniform Resource Name (URN) are types of Uniform Resource Identifiers (URI)");
            add("'https://vub.academia.edu/BeatSigner' is an example of a URL");
            add("'urn:ISBN:3837027139' is a valid example of a URN");
            add("'urn:ISBN:3837027139' is a valid example of a URI");
            add("'https://vub.academia.edu/BeatSigner' is an example of a URI");
            add("The HTTP Message Format consists of a start line, header fields a blank line and an optional message body");
            add("Multiple HTTP methods exist, each with their own semantics.");
            add("A HTTP GET request does not contain a message body.");
            add("A HTTP DELETE request should be used if the intention is to delete a resource on the server.");
            add("The status codes 100-199 indicate an informational response.");
            add("The status codes 200-299 indicate a success.");
            add("The status codes 300-399 indicate a redirection.");
            add("The status codes 400-499 indicate a client error.");
            add("The status codes 500-599 indicate a server error.");
            add("The status code 200 means 'OK'.");
            add("The status code 404 means that the resource could not be found.");
            add("The status code 503 means that the service is unavailable.");
            add("The 'Accept' header can be used to define the preferred Media Type.");
            add("The 'User-Agent' header contains information about the type of client.");
            add("The 'Content-Type' header specifies the body's MIME type.");
            add("'text/plain', 'text/html' and 'img/jpg' are examples of valid MIME types.");
            add("A web proxy is situated between the client and the server and can be used as a firewall and content filter.");
            add("If a developer wants to have more control over the caching strategy they can do so utilising the cache control header fields.");
            add("The act of tunneling is transmitting one protocol encapsulated inside another protocol.");
            add("Running SSL over an HTTP port is an example of tunneling.");
            add("A gateway can be used to translate between protocols (e.g. from HTTP to FTP)");
            add("HTTP is a stateless protocol");
            add("Session management using Authenticate headers can be used to fake a stateful connection over the stateless HTTP");
            add("Cookies can be used as a session management technique over stateless HTTP connections");
            add("The browser will send back all cookies created by a server each time that same server is accessed.");
            add("Common Gateway Interfaces are an example of server side processing.");
            add("Java Servlets are an example of server side processing.");
            add("PHP is an example of server side processing.");
            add("JavaScript is an example of client side processing.");
            add("FastCGI was created to solve the issue that a new process had to be created for each request in regular CGI.");
            add("FastCGI uses persistent processes and process pools");
            add("The Java servlet is a Java Class that overrides 4 main methods from the HttpServlet class.");
            add("In a Java servlet the init method is called only once when the servlet is loaded.");
            add("In a Java servlet the doGet method can be overridden to return dynamic content based on the request.");
            add("Java Applets had access to the full JDK, however unless the built was signed certain api calls would throw runtime exceptions due to the sand-boxed environment");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>() {{
            add("In contrast to telnet, HTTP communication is full duplex by default.");
            add("HTTP Slim, often abbreviated as HTTPS is a lightweight version of HTTP designed for IoT settings");
            add("Multiple Resources can share the same URN.");
            add("'https://vub.academia.edu/BeatSigner' is an example of a URN");
            add("'urn:ISBN:3837027139' is an example of a URL");
            add("The body is a required part of the HTTP Message Format");
            add("Except for the start line all parts of the HTTP Message Format are optional");
            add("TRACE is not a valid HTTP method");
            add("The CREATE HTTP method should be used to send data to the server to create a new resource");
            add("A HTTP HEAD request can be used to limit the amount of resources returned by the server to only the first X amount.");
            add("The status codes 300-399 indicate an informational response.");
            add("The status codes 100-199 indicate a success.");
            add("The status codes 400-499 indicate a redirection.");
            add("The status codes 200-299 indicate a client error.");
            add("The status codes 400-499 indicate a server error.");
            add("The status code 200 means that the service is temporarily unavailable.");
            add("The status code 401 means that the resource could not be found.");
            add("The status code 404 means that the service is unavailable.");
            add("The 'Content-Type' header can be used to define the preferred Media Type.");
            add("The 'Accept' header specifies the body's MIME type.");
            add("'image', 'audio' and 'video' are examples of valid MIME types.");
            add("Due to the secure nature of HTTP there is no need to worry about Man-in-the-Middle attacks when using a proxy.");
            add("Sending image files using HTTP messages is an example of tunneling.");
            add("HTTP is a stateful protocol.");
            add("In modern browsers by default all cookies will be removed as soon as the browser window is closed.");
            add("Common Gateway Interfaces are an example of browsers' Client-Side processing capabilities.");
            add("Java Servlets are an example of client side processing.");
            add("PHP is an example of client side processing.");
            add("Java Applets are an example of server side programming.");
            add("CGIs became popular due to their persistent processes.");
            add("In a Java servlet the init method is called once for every incoming request.");
            add("One of the advantages of Java Servlets are that it is easy for content developers to change the look of the website without having to redeploy the application.");
            add("Java applets posed a big risk as anyone could share Java programs online that would have access to the visitors file system using the Java API.");
        }};
    }
}
