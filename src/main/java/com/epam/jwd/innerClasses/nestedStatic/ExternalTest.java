package com.epam.jwd.innerClasses.nestedStatic;

/*
 *  для обращения к статическим членам вложенного статического класса нужно использовать его имя,
 * а для обращения к НЕстатическим членам вложенного статического класса — нужно использовать
 * имя его экземпляра. При этом, модификаторы доступа не влияют на видимость членов Nested(static) класса,
 * для внешнего класса (private, default (package visible), protected, public).
 */

public class ExternalTest {
    public static void main(String[] args) {
        External.messenger("Before instantiation. instanceCounter = "
                + External.NestedFoo.getInstanceCounter());

        External instance = new External(2, 2);
        // Вызовем у объекта НЕстатический метод с уровнем доступа default:
        System.out.println("After first instance creation: " + instance.sum());

        External.messenger("After first instantiation. instanceCounter = "
                + External.NestedFoo.getInstanceCounter());

        // External.NestedFoo.methodFoExperiments(); // Ошибка! Non-static!

        External.NestedFoo nestedInstance = new External.NestedFoo(); //так сработает
        nestedInstance.methodFoExperiments();
    }
}
