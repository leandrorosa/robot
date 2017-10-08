package com.lrosa.robot.command.action;

import com.lrosa.robot.entity.Robot;

public class MoveForwardCommandAction implements CommandAction {

    @Override
    public void move(Robot robot) {

        switch(robot.getOrientation()) {
            case NORTH:
                robot.incrementPositionY();
                break;
            case SOUTH:
                robot.decrementPositionY();
                break;
            case EAST:
                robot.incrementPositionX();
                break;
            case WEST:
                robot.decrementPositionX();
                break;
        }
    }
}
