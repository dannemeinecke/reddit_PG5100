package com.pg5100_Reddit.validation;

import com.pg5100_Reddit.entity.User;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserClassConstraintValidator implements ConstraintValidator<UserClassConstraints, User> {

    @Override
    public void initialize(UserClassConstraints userClassConstraints) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext){

        if(user.getBirthDate() == null || user.getRegistrationDate() == null){
            return false;
        }
        return user.getRegistrationDate().compareTo(user.getBirthDate()) > 0;
    }
}