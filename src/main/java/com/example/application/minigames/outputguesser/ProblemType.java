package com.example.application.minigames.outputguesser;

public enum ProblemType {
    X_PROBLEM, Y_PROBLEM, Z_PROBLEM;

    @Override
    public String toString() {
        return this.name().toLowerCase().replace("_problem", "");
    }
}
