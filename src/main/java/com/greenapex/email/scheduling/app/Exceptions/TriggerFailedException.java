package com.greenapex.email.scheduling.app.Exceptions;

public class TriggerFailedException extends RuntimeException {
    public TriggerFailedException(String msg) {
        super(msg);
    }
}
