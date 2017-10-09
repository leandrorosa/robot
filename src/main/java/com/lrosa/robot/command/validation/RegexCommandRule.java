package com.lrosa.robot.command.validation;

public class RegexCommandRule implements CommandRule {
    @Override
    public boolean validate(String command) {
        return !command.matches("^[MLR]*$");
    }
}
