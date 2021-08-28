package com.kodilla.ecommercee.exception;

public class CreatingObjectWithIdException extends Exception {

    public CreatingObjectWithIdException(Class<?> clazz, long id) {
        super(String.format("Tried to create entity %s with given id: %d.", clazz.getSimpleName(), id));
    }
}
