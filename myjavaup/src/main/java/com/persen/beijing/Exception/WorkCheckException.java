package com.persen.beijing.Exception;

@SuppressWarnings("serial")
public class WorkCheckException extends Exception {
    public WorkCheckException(String mess) {
        super(mess);
    }

    public WorkCheckException(String mess, Throwable cause) {
        super(mess, cause);
    }
}
