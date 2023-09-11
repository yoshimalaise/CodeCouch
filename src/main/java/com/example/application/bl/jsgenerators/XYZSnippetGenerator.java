package com.example.application.bl.jsgenerators;

import com.example.application.bl.utils.MyUtils;

import java.util.*;
import java.util.function.Supplier;

public abstract class XYZSnippetGenerator {
    private static Random r;

    private static ArrayList<String> declaredVars = new ArrayList<>();

    private static final ArrayList<Supplier<String>> generators =  new ArrayList<>(){{
       add(XYZSnippetGenerator::generateDirectAssignment);
    }};

    private static final ArrayList<String> endSetVars = new ArrayList<>(){{
        add("x");
        add("y");
        add("z");
    }};

    private static final ArrayList<String> comparators = new ArrayList<>(){{
        add("<");
        add("<=");
        add("===");
        add("!==");
        add(">=");
        add(">=");
    }};

    private static int varCtr = 1;

    /**
     * In direct assignment we assign a var between -30 and 30 to one of the vars
     * @return the snippet for the assignment
     */
    private static String generateDirectAssignment() {
        return MyUtils.getRandomElFromList(endSetVars) + " = " + r.nextInt(-30, 31) + ";\n";
    }

    private static String generateVarDeclarationSnippet(){
        return "let x = " + r.nextInt(-30, 31) + ";\n" +
                "let y = " + r.nextInt(-30, 31) + ";\n" +
                "let z = " + r.nextInt(-30, 31) + ";\n";
    }


    public static String generateXYZSnippet() {
        r = new Random();
        declaredVars = new ArrayList<>();
        StringBuilder res = new StringBuilder(generateVarDeclarationSnippet());
        int noOfBlocks = r.nextInt(2, 5);
        for (int i = 0; i < noOfBlocks; i++) {
            res.append(MyUtils.getRandomElFromList(generators).get());
        }
        return res.toString();
    }



}
