package com.lrosa.robot.entity;

import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.orientation.Orientation;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    @Test
    public void moveRightTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        robot.move("MMRMMRMM");
        assertEquals(2, robot.getPositionX());
        assertEquals(0, robot.getPositionY());
        assertEquals(Orientation.SOUTH, robot.getOrientation());
    }

    @Test
    public void moveLeftTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        robot.move("MML");
        assertEquals(0, robot.getPositionX());
        assertEquals(2, robot.getPositionY());
        assertEquals(Orientation.WEST, robot.getOrientation());

        robot.move("MML");
        assertEquals(0, robot.getPositionX());
        assertEquals(2, robot.getPositionY());
        assertEquals(Orientation.WEST, robot.getOrientation());
    }




}