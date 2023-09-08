package com.example.application.views.desktop.components;

import de.f0rce.ace.AceEditor;
import de.f0rce.ace.enums.AceMode;
import de.f0rce.ace.enums.AceTheme;

public class CodeSnippet extends AceEditor {
    public CodeSnippet(String code) {
        this.setReadOnly(true);
        this.setTheme(AceTheme.github);
        this.setMode(AceMode.javascript);
        this.setValue(code);
    }
}
