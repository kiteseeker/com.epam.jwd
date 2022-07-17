package com.epam.jwd.annotations_lesson;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        CommandDispatcher dispatcher = new CommandDispatcher(new Controller());
        dispatcher.executeCommand("show text");
        dispatcher.executeCommand("sort words");
        dispatcher.executeCommand("sdfdgdfg");
    }
}
