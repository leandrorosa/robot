package com.lrosa.robot.command.action;

import com.lrosa.robot.entity.Robot;
import com.lrosa.robot.orientation.Orientation;

public class MoveLeftCommandAction implements CommandAction {

    @Override
    public void move(Robot robot) {
        switch(robot.getOrientation()) {
            case NORTH:
                robot.setOrientation(Orientation.WEST);
                break;
            case SOUTH:
                robot.setOrientation(Orientation.EAST);
                break;
            case WEST:
                robot.setOrientation(Orientation.SOUTH);
                break;
            case EAST:
                robot.setOrientation(Orientation.NORTH);
                break;
        }
    }
}
