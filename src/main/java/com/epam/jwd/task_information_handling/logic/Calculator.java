package com.epam.jwd.task_information_handling.logic;

import com.epam.jwd.task_information_handling.entity.InputElement;
import com.epam.jwd.task_information_handling.parser.StringToElementParser;
import com.epam.jwd.task_information_handling.validator.Validator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Calculator {

    private Calculator() {
        throw new IllegalStateException("Utility class");
    }

    private static List<InputElement> inputToRPN(List<InputElement> elementList) {
        List<InputElement> inputToRPN = new ArrayList<>();
        Deque<InputElement> inputElementDeque = new ArrayDeque<>();
        int priority;

        for (InputElement element : elementList) {
            if (element.isNumber()) {
                inputToRPN.add(element);
            } else if (element.isOperator()) {
                priority = element.getPriority();
                while (!inputElementDeque.isEmpty()) {
                    if (inputElementDeque.peek().getPriority() >= priority) {
                        inputToRPN.add(inputElementDeque.pop());
                    } else break;
                }
                inputElementDeque.push(element);
            } else if (element.isBracket()) {
                priority = element.getPriority();
                if (priority == 1) {
                    inputElementDeque.push(element);
                } else {
                    while ((inputElementDeque.peek() != null ? inputElementDeque.peek().getPriority() : 0) != 1) {
                        inputToRPN.add(inputElementDeque.pop());
                    }
                    inputElementDeque.pop();
                }
            }
        }

        while (!inputElementDeque.isEmpty()) {
            inputToRPN.add(inputElementDeque.pop());
        }

        return inputToRPN;
    }

    public static double calculateFromPRN(String userInput) {
        Validator validator = new Validator();
        validator.validateUserInput(userInput);
        List<InputElement> inputElementList = StringToElementParser.parseStringToElement(userInput);
        List<InputElement> inputToRPN = inputToRPN(inputElementList);
        Deque<Double> currentActionStack = new ArrayDeque<>();

        for (InputElement element : inputToRPN) {

            if (element.isNumber()) {
                currentActionStack.push(Double.parseDouble(element.toString()));
            } else {
                switch (element.toString()) {
                    case "+":
                        currentActionStack.push(Double.parseDouble(currentActionStack.pop().toString()) +
                                Double.parseDouble(currentActionStack.pop().toString()));
                        break;
                    case "*":
                        currentActionStack.push(Double.parseDouble(currentActionStack.pop().toString()) *
                                Double.parseDouble(currentActionStack.pop().toString()));
                        break;
                    case "/":
                        double temp = Double.parseDouble(currentActionStack.pop().toString());
                        currentActionStack.push(Double.parseDouble(currentActionStack.pop().toString()) / temp);
                        break;
                }
            }

        }
        return Double.parseDouble(currentActionStack.pop().toString());
    }
}
