package com.example.application.bl.jsgenerators;

import com.example.application.bl.utils.MyUtils;

import java.util.*;
import java.util.function.Supplier;

public abstract class XYZSnippetGenerator {
    private static Random r;

    private static ArrayList<String> declaredVars = new ArrayList<>();

    private static final ArrayList<Supplier<String>> generators =  new ArrayList<>(){{
       add(XYZSnippetGenerator::generateDirectAssignment);
       add(XYZSnippetGenerator::generateIfBlock);
       add(XYZSnippetGenerator::generateSwapBlock);
       add(XYZSnippetGenerator::generateAdditionBlock);
       add(XYZSnippetGenerator::generateSubtractionBlock);
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

    private static String generateSwapBlock() {
        String newVar = getNextVar();
        String el1 = MyUtils.getRandomElFromList(endSetVars);
        String el2 = MyUtils.getRandomElFromList(endSetVars.stream().filter(el -> !el.equals(el1)).toList());
        return  "let " + newVar+ " = " + el1 + ";\n" +
                el1 + " = " + el2 + ";\n" +
                el2 + " = " + newVar + ";\n";
    }

    private static String generateAdditionBlock() {
        if (declaredVars.size() > 0 && r.nextInt(1, 3) == 1) {
            Collections.shuffle(declaredVars);
            return  MyUtils.getRandomElFromList(endSetVars) + " += " + declaredVars.get(0) + ";\n";
        }
        return  MyUtils.getRandomElFromList(endSetVars) + " += " + r.nextInt(-20, 20) + ";\n";
    }

    private static String generateSubtractionBlock() {
        if (declaredVars.size() > 0 && r.nextInt(1, 3) == 1) {
            Collections.shuffle(declaredVars);
            return  MyUtils.getRandomElFromList(endSetVars) + " -= " + declaredVars.get(0) + ";\n";
        }
        return  MyUtils.getRandomElFromList(endSetVars) + " -= " + r.nextInt(-20, 20) + ";\n";
    }

    private static String generateIfBlock() {
        String newVarName = getNextVar();
        return ("let " + newVarName + " = " + r.nextInt(0, 21) + ";\n" +
                "if (" + newVarName + " " + MyUtils.getRandomElFromList(comparators) + " " + r.nextInt(0, 21) + "){\n" +
                "    " + generateDirectAssignment() +
                "}\n");
    }

    private static String getNextVar() {
        String nextVar = List.of("a", "b", "c", "d", "e", "f", "g", "h", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "foo", "bar", "buzz").get(varCtr++);
        declaredVars.add(nextVar);
        return nextVar;
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
