package vn.tour_dulich.do_an.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.repository.PasswordsMatch;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getPassword().equals(userDto.getConfirmPassword());
    }
}