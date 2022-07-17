package com.epam.jwd.task_information_handling.entity;

public class NumberElement implements InputElement {
    private final double element;

    public NumberElement(double element) {
        this.element = element;
    }

    public double getElement() {
        return element;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean isBracket() {
        return false;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
