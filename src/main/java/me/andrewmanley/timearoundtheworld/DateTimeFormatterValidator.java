package me.andrewmanley.timearoundtheworld;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterValidator implements IParameterValidator {

    /**
     * Validates that the parameter is a valid {@link DateTimeFormatter} pattern.
     *
     * @param name The name of the parameter.
     * @param value The value of the parameter.
     * @throws ParameterException If the pattern is invalid.
     */
    @Override
    public void validate(String name, String value) throws ParameterException {
        try {
            DateTimeFormatter.ofPattern(value);
        } catch (IllegalArgumentException e) {
            throw new ParameterException(e.getMessage(), e);
        }
    }
}
