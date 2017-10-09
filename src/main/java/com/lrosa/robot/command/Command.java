package com.lrosa.robot.command;

import com.lrosa.robot.command.action.CommandAction;
import com.lrosa.robot.command.action.MoveForwardCommandAction;
import com.lrosa.robot.command.action.MoveLeftCommandAction;
import com.lrosa.robot.command.action.MoveRightCommandAction;
import com.lrosa.robot.command.exception.CommandNotFoundException;
import com.lrosa.robot.command.exception.InvalidCommandException;
import com.lrosa.robot.command.exception.InvalidRobotPositionException;
import com.lrosa.robot.entity.Robot;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Stream;

public enum Command {

    M('M', new MoveForwardCommandAction()),
    L('L', new MoveLeftCommandAction()),
    R('R', new MoveRightCommandAction());

    private final char commandChar;

    private final CommandAction action;

    Command(final char commandChar, final CommandAction action) {
        this.commandChar = commandChar;
        this.action = action;
    }

    public CommandAction getAction() {
        return action;
    }

    private static Command getByChar(final char commandChar) throws CommandNotFoundException {
        return Stream.of(Command.values())
                .filter(command -> commandChar == command.commandChar)
                .findFirst().orElseThrow(CommandNotFoundException::new);
    }

    public static void execute(final String command, final Robot robot) throws CommandNotFoundException, InvalidRobotPositionException {
        for(char commandChar: command.toCharArray()) {
            getByChar(commandChar).getAction().move(robot);
        }
    }


}
