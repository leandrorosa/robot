package com.lrosa.robot.entity;

import com.lrosa.robot.command.Command;
import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.orientation.Orientation;
import com.lrosa.robot.validation.RobotCommand;

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

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void incrementPositionY() {
        positionY++;
    }

    public void incrementPositionX() {
        positionX++;
    }

    public void decrementPositionY() {
        positionY--;
    }

    public void decrementPositionX() {
        positionX--;
    }

    private void reset() {
        positionY = 0;
        positionX = 0;
        orientation = Orientation.NORTH;
    }

    public void move(@RobotCommand final String command) throws CommandNotFoundException {
        reset();
        Command.execute(command, this);
    }

    @Override
    public String toString() {
        return "("+positionX+", "+positionY+", "+orientation.getPrefix()+")";
    }
}
