package com.lrosa.robot.entity;

import com.lrosa.robot.command.Command;
import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.command.exception.InvalidCommandException;
import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.orientation.Orientation;
import com.lrosa.robot.validation.RobotCommandRule;
import com.lrosa.robot.validation.RobotCommandRules;

public class Robot {

    private int positionX;

    private int positionY;

    private Orientation orientation;

    public Robot() {
        positionX = 0;
        positionY = 0;
        orientation = Orientation.NORTH;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) throws InvalidRobotPositionException {
        for(RobotCommandRule rule: RobotCommandRules.get()) {
            rule.validate(positionY);
        }
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) throws InvalidRobotPositionException {
        for(RobotCommandRule rule: RobotCommandRules.get()) {
            rule.validate(positionY);
        }
        this.positionY = positionY;
    }

    public void reset() {
        positionY = 0;
        positionX = 0;
        orientation = Orientation.NORTH;
    }

    public void move(final String command) throws CommandNotFoundException, InvalidRobotPositionException, InvalidCommandException {
        reset();
        Command.execute(command, this);
    }

    @Override
    public String toString() {
        return "("+positionX+", "+positionY+", "+orientation.getPrefix()+")";
    }
}
