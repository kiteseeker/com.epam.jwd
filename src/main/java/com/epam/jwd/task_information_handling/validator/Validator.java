package com.epam.jwd.task_information_handling.validator;

import com.epam.jwd.task_information_handling.exception.LetterInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);
    private static final String REGEXP_LETTERS = ".*[a-zA-Z]+.*";

    public void validateUserInput(String userInput) {
        validateLettersInput(userInput);
        validateBracketsQuantity(userInput);
    }

    private void validateLettersInput(String userInput) {
        try {
            if (Pattern.matches(REGEXP_LETTERS, userInput)) {
                throw new LetterInputException();

            } else {
                logger.info("Letters absence test passed.");
            }
        } catch (LetterInputException e) {
            logger.error("Incorrect input! Please Only numbers, operators and brackets are allowed!");
        }
    }

    private void validateBracketsQuantity(String userInput) {
        int openedBracket = 0;
        int closedBracket = 0;

        for (Character character : userInput.toCharArray()) {
            if (character.equals('(')) {
                openedBracket++;
            } else if (character.equals(')')) {
                closedBracket++;
            }
        }

        try {
            if (openedBracket == closedBracket) {
                logger.info("Bracket quantity test passed.");
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            logger.error(String.format("Incorrect input! Check brackets usage. Opened brackets: %d, " +
                    "closed brackets: %d", openedBracket, closedBracket));
            System.exit(1);
        }
    }
}
