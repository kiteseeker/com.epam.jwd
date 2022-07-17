package com.epam.jwd.annotations_lesson;

public class Controller {
    @Command("show text")
    public void showText() {
        System.out.println("Showing text.");
    }

    @Command("sort words")
    public void sortWords() {
        System.out.println("Sorting words.");
    }

    @Command()
    public void defaultImpl() {
        System.out.println("Sorry, I don't understand.");
    }
}
