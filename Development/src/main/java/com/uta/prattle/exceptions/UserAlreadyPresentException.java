package com.uta.prattle.exceptions;

import com.uta.prattle.model.User;

/**
 * An representation of an error which is thrown where a request has been made
 * for creation of a user object that already exists in the system.
 * Refer {@link User#equals}
 * Refer {@link com.uta.prattle.service.UserService#addUser(User)}
 *
 * @author CS5500 Fall 2019 Teaching staff
 * @version dated 2019-10-06
 */
public class UserAlreadyPresentException extends RuntimeException {
    private static final long serialVersionUID = -4845176561270017896L;

    /**
     * Class constructor.
     *
     * @param message custom message for the exception
     */
    public UserAlreadyPresentException(String message) {
        super(message);
    }
}
