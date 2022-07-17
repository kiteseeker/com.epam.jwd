package com.epam.jwd.task_information_handling.entity;

public class BracketElement implements InputElement {
    private final String element;

    public BracketElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean isBracket() {
        return true;
    }

    @Override
    public String toString() {
        return element;
    }

    @Override
    public int getPriority() {
        if (String.valueOf(this).equals("(")) return 1;
        else return -1;
    }

}
