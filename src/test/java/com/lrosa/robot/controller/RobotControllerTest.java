package com.lrosa.robot.controller;

import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.command.exception.InvalidCommandException;
import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RobotControllerTest {

    @Autowired
    private RobotController robotController;

    @Test
    public void moveRightTest() throws CommandNotFoundException, InvalidRobotPositionException, InvalidCommandException {
        ResponseEntity<String> response = robotController.move("MMRMMRMM");
        assertEquals("(2, 0, S)", response.getBody());
    }

    @Test
    public void moveLeftTest() throws CommandNotFoundException, InvalidRobotPositionException, InvalidCommandException {
        ResponseEntity<String> response = robotController.move("MML");
        assertEquals("(0, 2, W)", response.getBody());
        response = robotController.move("MML");
        assertEquals("(0, 2, W)", response.getBody());
    }

    @Test
    public void invalidPositionTest() throws CommandNotFoundException {
        ResponseEntity<String> response = robotController.move("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void invalidCommandWithNumbersTest() throws CommandNotFoundException {
        ResponseEntity<String> response = robotController.move("123");
        assertEquals(400, response.getStatusCodeValue());
    }

}