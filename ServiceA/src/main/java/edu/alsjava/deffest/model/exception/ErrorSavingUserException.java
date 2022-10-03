package edu.alsjava.deffest.model.exception;

import edu.alsjava.deffest.domain.User;

public class ErrorSavingUserException extends BusinessException {

    public ErrorSavingUserException(User user) {
        super("Cant save user " + user.describe());
    }
}
