package com.epam.jwd.task_information_handling.entity;

public class OperatorElement implements InputElement {
    private final String element;

    public OperatorElement(String element) {
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
        return true;
    }

    @Override
    public boolean isBracket() {
        return false;
    }

    @Override
    public String toString() {
        return element;
    }

    @Override
    public int getPriority() {
        if (String.valueOf(this).equals("*") || String.valueOf(this).equals("/")) return 3;
        else return 2;
    }
}
