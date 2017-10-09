package com.lrosa.robot.validation;

import java.util.Arrays;
import java.util.List;

public class RobotCommandRules {

    public static List<RobotCommandRule> get() {
        return Arrays.asList(new MaxPositionRobotCommandRule(), new MinPositionRobotCommandRule());
    }

}
