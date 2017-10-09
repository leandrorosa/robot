package com.lrosa.robot.command.validation;


import org.springframework.util.StringUtils;

public class EmptyCommandRule implements CommandRule {

    @Override
    public boolean validate(String command) {
        return StringUtils.isEmpty(command);
    }

}
