package com.exam.helper;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User with this Username is not there in DB !!");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

}
