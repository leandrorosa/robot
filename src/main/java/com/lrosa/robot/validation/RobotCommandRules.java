package com.lrosa.robot.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RobotCommandRules {

    public static List<RobotCommandRule> get() {
        return Arrays.asList(new MaxPositionCommandRule(), new MinPositionCommandRule());
    }

}
