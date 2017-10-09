package com.lrosa.robot.entity;

import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.command.exception.InvalidCommandException;
import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.orientation.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void moveRightTest() throws CommandNotFoundException, InvalidRobotPositionException, InvalidCommandException {
        final Robot robot = new Robot();
        robot.move("MMRMMRMM");
        assertEquals(2, robot.getPositionX());
        assertEquals(0, robot.getPositionY());
        assertEquals(Orientation.SOUTH, robot.getOrientation());
    }

    @Test
    public void moveLeftTest() throws CommandNotFoundException, InvalidRobotPositionException, InvalidCommandException {
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

    @Test
    public void invalidPositionTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid robot position", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(5, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }

    @Test
    public void invalidCommandWithNumbersTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move("123");
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid command", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(0, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }

    @Test
    public void invalidCommandWithLettersTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move("QWRAS");
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid command", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(0, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }

    @Test
    public void invalidCommandWithLetters2Test() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move("MMRRLLA");
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid command", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(0, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }

    @Test
    public void invalidCommandWithLetters3Test() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move("mmrl");
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid command", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(0, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }

    @Test
    public void nullCommandTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move(null);
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid command", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(0, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }

    @Test
    public void emptyCommandTest() throws CommandNotFoundException {
        final Robot robot = new Robot();
        try {
            robot.move("");
        } catch(InvalidCommandException|InvalidRobotPositionException e) {
            assertEquals("Invalid command", e.getMessage());
        } finally {
            assertEquals(0, robot.getPositionX());
            assertEquals(0, robot.getPositionY());
            assertEquals(Orientation.NORTH, robot.getOrientation());
        }
    }


}