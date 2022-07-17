package com.epam.jwd.annotations_lesson;

public class BadController {
    private CommandExecutor executor;

    //show text --> executor.showText()
    //sort words --> sortWords()

    private void executeCommand(String action) {
        switch (action) {
            case "show text":
                executor.showText();
                break;
            case "sort words":
                executor.sortWords();
                break;
            // +1000 more options... So, this controller is bad!
            default:
                System.out.println("Sorry, I don't understand.");
        }
    }
}
