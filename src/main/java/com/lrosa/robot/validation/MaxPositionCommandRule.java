package com.lrosa.robot.validation;

import com.lrosa.robot.command.exception.InvalidRobotPositionException;

public class MaxPositionCommandRule implements RobotCommandRule {

    private static final int MAX_POSITION = 5;

    @Override
    public void validate(int position) throws InvalidRobotPositionException {
        if(position > MAX_POSITION) {
            throw new InvalidRobotPositionException();
        }
    }
}
