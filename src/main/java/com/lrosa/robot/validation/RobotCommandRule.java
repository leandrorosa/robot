package com.lrosa.robot.validation;

import com.lrosa.robot.command.exception.InvalidRobotPositionException;

public interface RobotCommandRule {

    void validate(final int position) throws InvalidRobotPositionException;
}
