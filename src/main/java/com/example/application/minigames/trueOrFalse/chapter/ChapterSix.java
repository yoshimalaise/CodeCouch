package com.example.application.minigames.trueOrFalse.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterSix extends BaseChapter {
    public static final String NAME = "6. JavaScript";

    public ChapterSix() {
        super(NAME);
    }

    @Override
    public List<String> getTrueStatements() {
        return new ArrayList<>(){{
            add("JavaScript is a high level loosely typed dynamic language.");
            add("Placing the JavaScript code just before the </body> tag might improve page load.");
            add("The global window object is shared among all the code on the webpage.");
            add("By default JavaScript is single threaded meaning that the browser stops responding to input whilst scripts are executed.");
            add("document.write() can be used to add content to the page while loading, but is generally discouraged.");
            add("The log, error, and info methods on the console object can be used to display information on the browser console which is useful for debugging.");
            add("The alert function can be used to show a message to the user in the form of a popup.");
            add("The prompt function can be used to show a message to the user and also ask for input.");
            add("The confirm function can be used to show a message to the user and ask for confirmation.");
            add("The primitive data types in JS are string, number, bigint, boolean and symbol as well as null and undefined.");
            add("JavaScript uses dynamic types which means the datatype of a variable can change at runtime.");
            add("In javascript strings are immutable.");
            add("By default numbers in javascript are stored as 64-bit floating point numbers.");
            add("Executing 'let x = (0.3 * 10 + 0.6 * 10) / 10;' in the console will result in x being equal to 0.9");
            add("Boolean variables in JavaScript are either true or false");
            add("JavaScript has a built-in Math object that supports various Mathematical operations.");
            add("JavaScript has support for Date objects that support operations such as getting the day of the week from a date.");
            add("The code 'student[\"firstName\"];' can be used to access the property 'firstName' of the object stored in the student variable.");
            add("The following code 'delete student.lastName; console.log(student.lastName);' will print undefined.");
            add("In JavaScript objects are passed by reference.");
            add("the code 'console.log(([[3, 1, 2], [9, 6, 4], [5, 7, 8]])[0][1]);' will print '1'.");
            add("In JavaScript functions are objects and they can be stored in variables and passed as arguments.");
            add("Variables declared using the let keyword use block level scoping.");
            add("Variables declared outside of a function have global scope.");
            add("Modules offer a solution to control the scoping to prevent import collisions");
            add("Global variables can lead to name collisions and as such should be avoided.");
            add("Assigning a variable without declaration inside a module will lead to a runtime error.");
            add("The '===' operator should be used to check for equality.");
            add("The document.querySelector method can be used to select elements from the DOM based on CSS selectors.");
            add("By adding or removing entries of the classList array of elements we can update the visual appearance of elements at runtime.");
            add("The addEventListener method defined on DOM elements can be used to register event handlers that react to events such as the 'click' event.");
            add("In order to parse JSON data we should use the JSON.parse() method.");
            add("Valid json syntax is also valid JavaScript syntax.");
        }};
    }

    @Override
    public List<String> getFalseStatements() {
        return new ArrayList<>(){{
            add("JavaScript is a high level strongly typed dynamic language.");
            add("JavaScript is a high level loosely typed static language.");
            add("By default JavaScript is multi-threaded, every event starts a new process.");
            add("JavaScript uses static types which means the datatype of a variable cannot change at runtime.");
            add("In javascript strings are mutable.");
            add("By default numbers in javascript are stored as 32-bit floating point numbers.");
            add("By default numbers in javascript are stored as 128-bit floating point numbers.");
            add("Executing 'let x = (0.3 / 10 + 0.6 / 10) * 10;' in the console will result in x being equal to 0.9");
            add("Without writing custom objects JavaScript has no way to represent numbers larger than  2^53-1 (or Number.MAX_SAFE_INTEGER).");
            add("Number and BigInt operands can safely be mixed in mathematical expressions.");
            add("JavaScript has a primitive Date type.");
            add("The code 'student->firstName;' can be used to access the property 'firstName' of the object stored in the student variable.");
            add("The following code 'delete student.lastName; console.log(student.lastName);' will result in a runtime error.");
            add("In JavaScript objects are passed by value.");
            add("'Object.assign(target, source);' will perform a deep copy of the source object.");
            add("In javascript all elements of an array need to be the same type.");
            add("The var keyword brings block level scoping to javascript");
            add("Variables declared using the let keyword use function scoping.");
            add("If a JavaScript module exports a variable it is automatically added to the global scope when the module is loaded.");
            add("Assigning a variable without declaration will lead to a runtime error by default.");
            add("The '==' operator should be used to check for equality.");
            add("In general XML is easier to produce and faster to parse than JSON.");
            add("In order to parse JSON data we should use the 'eval()' method.");
            add("JavaScript Object Notation (JSON) often still loses out to the more general XML specification as JSON can only be used in JavaScript applications.");
            add("Valid JavaScript syntax is also valid json syntax.");
        }};
    }
}
