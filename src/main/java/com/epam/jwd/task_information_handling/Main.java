package com.epam.jwd.task_information_handling;

import com.epam.jwd.task_information_handling.logic.Calculator;

public class Main {
    public static void main(String[] args) {
        String input = "21,6 + 18,2 * (12-17/(2*(114.3-16)))";
        System.out.println(Calculator.calculateFromPRN(input));
    }
}