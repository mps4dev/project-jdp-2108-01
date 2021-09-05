package com.kodilla.ecommercee.exception;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class<?> clazz, long id) {
        super(String.format("Entity %s with id: %d not found.", clazz.getSimpleName(), id));
    }
}
