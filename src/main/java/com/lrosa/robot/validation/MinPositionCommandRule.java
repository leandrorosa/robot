package com.lrosa.robot.validation;

import com.lrosa.robot.command.exception.InvalidRobotPositionException;

public class MinPositionCommandRule implements RobotCommandRule {

    private static final int MIN_POSITION_RULE = 0;

    @Override
    public void validate(int position) throws InvalidRobotPositionException {
        if(position < 0) {
            throw new InvalidRobotPositionException();
        }
    }
}
