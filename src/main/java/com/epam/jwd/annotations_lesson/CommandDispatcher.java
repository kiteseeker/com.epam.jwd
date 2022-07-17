package com.epam.jwd.annotations_lesson;

import org.reflections.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CommandDispatcher {
    private Map<String, Method> actionToMethod = new HashMap<>();
    private Controller controller;
    private Method defaultMethod;

    public CommandDispatcher(Controller controller) {
        Objects.requireNonNull(controller);
        this.controller = controller;

        Set<Method> allMethods = ReflectionUtils.getAllMethods(controller.getClass());
        for (Method method : allMethods) {
            Command annotation = method.getAnnotation(Command.class);
            if (annotation != null) {
                String action = annotation.value();
                if (action.isEmpty()) {
                    defaultMethod = method;
                } else {
                    actionToMethod.put(action, method);
                }
            }
        }
    }

    public void executeCommand(String action) throws InvocationTargetException, IllegalAccessException {
        Method method = actionToMethod.get(action);
        method.invoke(controller);
    }


}
