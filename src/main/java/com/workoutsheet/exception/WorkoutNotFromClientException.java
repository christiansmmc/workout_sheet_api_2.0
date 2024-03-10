package com.workoutsheet.exception;

public class WorkoutNotFromClientException extends RuntimeException {

    public WorkoutNotFromClientException(String message) {
        super(message);
    }

    public WorkoutNotFromClientException() {
        super("The provided workout is not from logged client!");
    }
}
