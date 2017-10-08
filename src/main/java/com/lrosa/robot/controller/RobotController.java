package com.lrosa.robot.controller;

import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.entity.Robot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    private final Robot robot = new Robot();

    @GetMapping(value = "/rest/mars/{command}")
    public String move(@PathVariable("command") final String command) throws CommandNotFoundException {
        robot.move(command);
        return robot.toString();
    }
}