package com.lrosa.robot.validation;

import com.lrosa.robot.command.exception.InvalidRobotPositionException;

public class MinPositionRobotCommandRule implements RobotCommandRule {

    private static final int MIN_POSITION_RULE = 0;

    @Override
    public void validate(int position) throws InvalidRobotPositionException {
        if(position < MIN_POSITION_RULE) {
            throw new InvalidRobotPositionException();
        }
    }
}
