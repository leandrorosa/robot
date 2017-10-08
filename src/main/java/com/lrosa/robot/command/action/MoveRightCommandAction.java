package com.lrosa.robot.command.action;

import com.lrosa.robot.entity.Robot;
import com.lrosa.robot.orientation.Orientation;

public class MoveRightCommandAction implements CommandAction {

    @Override
    public void move(Robot robot) {
        switch(robot.getOrientation()) {
            case NORTH:
                robot.setOrientation(Orientation.EAST);
                break;
            case SOUTH:
                robot.setOrientation(Orientation.WEST);
                break;
            case WEST:
                robot.setOrientation(Orientation.NORTH);
                break;
            case EAST:
                robot.setOrientation(Orientation.SOUTH);
                break;
        }
    }
}
