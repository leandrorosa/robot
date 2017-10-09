package com.lrosa.robot.command.action;

import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.entity.Robot;

public class MoveForwardCommandAction implements CommandAction {

    @Override
    public void move(Robot robot) throws InvalidRobotPositionException {

        switch(robot.getOrientation()) {
            case NORTH:
                robot.setPositionY(robot.getPositionY()+1);
                break;
            case SOUTH:
                robot.setPositionY(robot.getPositionY()-1);
                break;
            case EAST:
                robot.setPositionX(robot.getPositionX()+1);
                break;
            case WEST:
                robot.setPositionX(robot.getPositionX()-1);
                break;
        }
    }
}
