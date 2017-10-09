package com.lrosa.robot.command.exception;

public class InvalidRobotPositionException extends Exception {

    public InvalidRobotPositionException() {
        super("Invalid robot position");
    }
}
