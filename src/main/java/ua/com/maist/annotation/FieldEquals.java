package ua.com.maist.annotation;


import ua.com.maist.annotation.validator.FieldEqualsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by dach1016 on 01.08.2017.
 * For comparison of fields (using hibernate-validator)
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldEqualsValidator.class)
@Documented
public @interface FieldEquals {
    String MESSAGE = "Fields aren't equal";

    String message() default MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldEquals[] value();
    }

    String firstField();
    String secondField();
}
