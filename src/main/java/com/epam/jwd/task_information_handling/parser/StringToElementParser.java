package com.epam.jwd.task_information_handling.parser;

import com.epam.jwd.task_information_handling.entity.BracketElement;
import com.epam.jwd.task_information_handling.entity.NumberElement;
import com.epam.jwd.task_information_handling.entity.InputElement;
import com.epam.jwd.task_information_handling.entity.OperatorElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringToElementParser {
    private static final String REGEXP_WHITESPACE = "\\s";
    private static final String REGEXP_OPERATOR = "[+*/]";
    private static final String REGEXP_BRACKETS = "[()]";
    private static final String REGEXP_NEGATIVE_OPERATION = "-";

    private StringToElementParser() {
        throw new IllegalStateException("Utility class");
    }

    public static List<InputElement> parseStringToElement(String userInputString) {
        String inputWoutWhitespaces = removeWhiteSpaces(userInputString);
        String inputWoutNegatives = replaceNegativeOperations(inputWoutWhitespaces);

        String element = "";
        List<InputElement> inputElementList = new ArrayList<>();

        for (Character character : inputWoutNegatives.toCharArray()) {
            if (Character.isDigit(character)) {
                element = element.concat(character.toString());
            } else if (character.equals('.') || character.equals(',')) {
                element = element.concat(".");
            } else if (character.equals('-')) {
                element = element.concat("-");
            } else if (Pattern.matches(REGEXP_OPERATOR, character.toString())) {
                element = addOperatorElement(element, inputElementList, character);
            } else if (Pattern.matches(REGEXP_BRACKETS, character.toString())) {
                element = addBracketElement(element, inputElementList, character);
            }
        }

        if (element.length() != 0) {
            inputElementList.add(new NumberElement(Double.parseDouble(element)));
        }

        return inputElementList;
    }

    private static String addBracketElement(String element, List<InputElement> inputElementList, Character character) {
        if (element.length() != 0) {
            inputElementList.add(new NumberElement(Double.parseDouble(element)));
            inputElementList.add(new BracketElement(character.toString()));
            element = "";
        } else {
            inputElementList.add(new BracketElement(character.toString()));
        }
        return element;
    }

    private static String addOperatorElement(String element, List<InputElement> inputElementList, Character character) {
        if (element.length() != 0) {
            inputElementList.add(new NumberElement(Double.parseDouble(element)));
            inputElementList.add(new OperatorElement(character.toString()));
            element = "";
        } else {
            inputElementList.add(new OperatorElement(character.toString()));
        }
        return element;
    }

    private static String removeWhiteSpaces(String userInputString) {
        return userInputString.replaceAll(REGEXP_WHITESPACE, "");
    }

    private static String replaceNegativeOperations(String userInputString) {
        String temp = userInputString.replace(REGEXP_NEGATIVE_OPERATION, "+-");
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '+') {
                temp = temp.replaceFirst("^\\+", "");
                break;
            }
        }
        return temp;
    }
}