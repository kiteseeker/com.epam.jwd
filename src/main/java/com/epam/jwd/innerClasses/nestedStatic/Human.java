package com.epam.jwd.innerClasses.nestedStatic;

public class Human {
    Relations relations;
    NewRelations newRelations;
    String name;
    int age;

    /**
     * Nested static enum used only inside class <tt>Human</tt> and useless without it.
     * <p>Defined as nested class and undividable of <tt>Human</tt>
     * <p>If placed separately, could be easily missed if <tt>Human</tt> is refactored etc.
     * <p>Enum is always <b>nested static</b>
     */
    static public enum Relations {
        DIVORCED, ACTIVE_SEARCH, SINGLE, MARRIED, COMPLEX, IN_LOVE
    }

    public static class NewRelations {
        private final String NAME;

        public NewRelations(String NAME) {
            this.NAME = NAME;
        }

        public String getName() {
            return  NAME;
        }
    }
}

