package com.kodilla.ecommercee.exception;

public class CreatingObjectWithIdException extends Exception {

    public CreatingObjectWithIdException(Class<?> clazz, long id) {
        super("Tried to create entity " + clazz.getSimpleName() + " with given id: " + id + ".");
    }
}
