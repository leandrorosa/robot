package com.lrosa.robot.command.action;

import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.entity.Robot;

public interface CommandAction {

    void move(Robot robot) throws InvalidRobotPositionException;
}
