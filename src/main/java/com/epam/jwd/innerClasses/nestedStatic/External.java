package com.epam.jwd.innerClasses.nestedStatic;

public class External {
    private static int instanceCounter;
    private int a;
    int b;

    public External(int a, int b) {
        this.a = a;
        this.b = b;
        instanceCounter++;
    }

    //  private // Смело экспериментируйте!
    static void messenger(String incomeMessage) {
        String someMessage = "No message!";
        if (incomeMessage != null && !incomeMessage.isEmpty()) {
            someMessage = incomeMessage;
        }
        System.out.printf("The static method 'messenger()' of the outer class. Message: "
                        + "\"%s\"\n\n",
                someMessage);
    }

    // Все, что нам нужно от объектов External.
    String sum() {
        int result = a + b;
        return String.format("The non-static method 'sum()' of the outer class. %d + %d = %d",
                a,
                b,
                result);
    }

    static class NestedFoo {

        static String getInstanceCounter() {
            // Свободный доступ к статическому полю внешнего класса:
            return instanceCounter
                    + " (the information is provided by a static method 'getInstanceCounter()' "
                    + "from an inner class.)";
        }

        void methodFoExperiments() {
            System.out.println("'methodFoExperiments()' method in inner class.");

            // a = 5; // Ошибка! Ответьте себе почему?!
            // b = 5; // Ошибка! Т.к. "а" не статическое поле.

            // Свободный доступ к статическому методу внешнего класса,
            // даже без упоминания имени внешнего класса или его объектов:
            messenger("ПРЯМОЙ вызов 'messenger()' из 'methodFoExperiments()'");
            // Или с упоминанием его имени:
            External.messenger("ЧЕРЕЗ ИМЯ КЛАССА вызов 'messenger()' из "
                    + "'methodFoExperiments()'");

            // Создадим объект внешнего класса с псевдослучайными значениями полей:
            External instanceInInner = new External(10, 10);
            // теперь пощупаем эти поля через имя объекта:
            instanceInInner.a = 5; // Доступ к private  полю через объект.
            instanceInInner.b = 5; // Доступ к default (package visible) полю через объект.

            System.out.println(instanceInInner.sum());

            messenger("After second instantiation in inner class. Counter = "
                    + External.NestedFoo.getInstanceCounter());
        }
    }
}
