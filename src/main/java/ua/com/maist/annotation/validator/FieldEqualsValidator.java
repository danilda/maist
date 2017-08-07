package ua.com.maist.annotation.validator;

import org.apache.log4j.Logger;
import ua.com.maist.annotation.FieldEquals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * Created by dach1016 on 01.08.2017.
 *
 */
public class FieldEqualsValidator implements ConstraintValidator<FieldEquals, Object> {
    private Logger logger = Logger.getLogger(FieldEqualsValidator.class);
    private String message = FieldEquals.MESSAGE;
    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldEquals fieldEquals) {
        this.message = fieldEquals.message();
        this.firstField = fieldEquals.firstField();
        this.secondField = fieldEquals.secondField();
    }

    @Override
    public boolean isValid(Object annotatedObj, ConstraintValidatorContext context) {
        try {
            return unhandledValidation(annotatedObj, context);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    private boolean unhandledValidation(Object annotatedObj, ConstraintValidatorContext context) {
        Object firstFieldValue = getProperty(annotatedObj, firstField, null);
        Object secondFieldValue = getProperty(annotatedObj, secondField, null);
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addPropertyNode(secondField).addConstraintViolation();
        return firstFieldValue == null && secondFieldValue == null ||
                firstFieldValue != null && firstFieldValue.equals(secondFieldValue);
    }

    private Object getProperty(Object annotatedObj, String fieldName,
                               Object defaultValue) {
        Class<?> clazz = annotatedObj.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0))
                + fieldName.substring(1);
        try {
            Method method = clazz.getDeclaredMethod(methodName);
            return method.invoke(annotatedObj);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return defaultValue;
    }
}
