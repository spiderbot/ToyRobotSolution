package com.toy.robot.exceptions.boardexception;

public class BoardException extends Exception {

    private static final long serialVersionUID = 343243243243243241L;
    private int code;

    public BoardException(String message) {
        super(message);
    }

    public BoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardException(Throwable cause) {
        super(cause);
    }

    public BoardException(int code, String message) {
        super(message);
        setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
