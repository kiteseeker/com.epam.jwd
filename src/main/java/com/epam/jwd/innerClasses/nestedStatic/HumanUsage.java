package com.epam.jwd.innerClasses.nestedStatic;

/*
* Nested classes have static keyword (enumerators are static by default);
* nested classes are normal classes except:
*   definition is nested to the definition of the parent class.
* */

public class HumanUsage {
    public static void main(String[] args) {
        final Human max = new Human();
        max.relations = Human.Relations.COMPLEX;
        // для того, чтобы обратиться к вложенному enum нам нужно указать и его внешний класс
        // вложенный enum Relations по сути является static field класса Human

        max.newRelations = new Human.NewRelations("Single");
    }
}
