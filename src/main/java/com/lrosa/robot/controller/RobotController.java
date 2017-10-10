package com.lrosa.robot.controller;

import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.command.exception.InvalidCommandException;
import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.entity.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    private static final Logger LOG = LoggerFactory.getLogger(RobotController.class);


    private final Robot robot = new Robot();

    @GetMapping(value = "/rest/mars/{command}")
    public ResponseEntity<String> move(@PathVariable("command") final String command) {
        try {
            robot.move(command);
            return ResponseEntity.accepted().body(robot.toString());
        } catch (CommandNotFoundException|InvalidRobotPositionException|InvalidCommandException e) {
            LOG.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body("400 - Bad request");
        }
    }
}
