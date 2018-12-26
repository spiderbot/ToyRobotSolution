package com.toy.robot.exceptions.toyrobotexception;

public class ToyRobotException extends Exception {

    private static final long serialVersionUID = 23432432432432432L;
    private int code;

    public ToyRobotException(String message) {
        super(message);
    }

    public ToyRobotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToyRobotException(Throwable cause) {
        super(cause);
    }

    public ToyRobotException(int code, String message) {
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
