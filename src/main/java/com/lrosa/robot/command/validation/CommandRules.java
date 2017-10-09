package com.lrosa.robot.command.validation;

import java.util.stream.Stream;

public class CommandRules {

    public static Stream<CommandRule> get() {
        return Stream.of(new EmptyCommandRule(), new RegexCommandRule());
    }
}
