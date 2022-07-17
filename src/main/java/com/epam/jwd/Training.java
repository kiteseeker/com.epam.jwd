package com.epam.jwd;

import java.util.regex.Pattern;

public class Training {
    public static void main(String[] args) {

        String[] expressions = {"sfd2ds", "sfsadfd", "1dsfd"};
        String regex = "[0-9]";

        for (String expression : expressions) {
            if (Pattern.matches(regex, expression)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
