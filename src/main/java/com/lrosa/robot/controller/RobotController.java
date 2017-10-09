package com.lrosa.robot.controller;

import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.entity.Robot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    private final Robot robot = new Robot();

    @GetMapping(value = "/rest/mars/{command}")
    public ResponseEntity<String> move(@PathVariable("command") final String command) {
        try {
            robot.move(command);
            return ResponseEntity.accepted().body(robot.toString());
        } catch (CommandNotFoundException|InvalidRobotPositionException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
