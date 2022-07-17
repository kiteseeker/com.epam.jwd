package com.epam.jwd.annotations_homework;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        JsonCreator addPerson = new JsonCreator(new Person("Ivan", "Ivanov", 24,
                "3778885554411", "Minsk"));
        JsonCreator addPerson2 = new JsonCreator(new Person("Anna", "Soltanovich", 28,
                "255887774414", "Brest"));



       /* Class personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        Map<String, Object> fieldToList = new HashMap<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Public.class)) {
                //System.out.println(field.getName() + ", " + field.get(person1));
                fieldToList.put(field.getName(), field.get(person1));
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(person1.getLastName() + ".json"), fieldToList);*/
    }
}
