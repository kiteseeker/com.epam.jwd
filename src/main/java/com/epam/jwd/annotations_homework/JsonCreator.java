package com.epam.jwd.annotations_homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonCreator {
    private Map<String, Object> publicFieldsToExport;
    private Class personClass;
    private Field[] fields;

    public JsonCreator(Person person) throws IllegalAccessException, IOException {
        Objects.requireNonNull(person);
        publicFieldsToExport = new HashMap<>();
        personClass = Person.class;
        fields = personClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Public.class)) {
                field.setAccessible(true);
                publicFieldsToExport.put(field.getName(), field.get(person));
                field.setAccessible(false);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(person.getLastName() + ".json"), publicFieldsToExport);
    }
}
