package ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions;


public class InvalidUserDateException extends Exception {

    private String target;

    public InvalidUserDateException(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
}
