package com.epam.jwd.task_information_handling.entity;

public interface InputElement {
    boolean isNumber();

    boolean isOperator();

    boolean isBracket();

    int getPriority();
}
