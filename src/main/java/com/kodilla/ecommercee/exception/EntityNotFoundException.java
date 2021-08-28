package com.kodilla.ecommercee.exception;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class<?> clazz, long id) {
        super("Entity " + clazz.getSimpleName() + " with id: " + id + " not found.");
    }
}
