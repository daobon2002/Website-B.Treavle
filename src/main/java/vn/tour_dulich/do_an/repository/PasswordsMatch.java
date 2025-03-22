package vn.tour_dulich.do_an.repository;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.tour_dulich.do_an.validators.PasswordsMatchValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = PasswordsMatchValidator.class)
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {
    String message() default "Mật khẩu và xác nhận mật khẩu không khớp.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
