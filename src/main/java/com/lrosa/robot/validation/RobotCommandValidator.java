package com.lrosa.robot.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RobotCommandValidator implements ConstraintValidator<RobotCommand, String> {

  public void initialize(RobotCommand xpath) {}

  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.matches("^[^MRL]*$");
  }
}