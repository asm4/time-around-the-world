package me.andrewmanley.timearoundtheworld;

import com.beust.jcommander.Parameter;

import java.time.ZonedDateTime;

public class DateTimeArgs {
    // Pattern reference https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    /**
     * Formats a {@link ZonedDateTime} object to be in the form: <br />
     * longDayOfTheWeek longMonth day longYear hour:minute:second AM/PM
     */
    public static final String DEFAULT_FORMAT = "eeee MMMM d yyyy h:m:sa";

    /**
     * Format that will be used for displaying the date time. Defaults to {@link DateTimeArgs#DEFAULT_FORMAT}
     */
    @Parameter(names = {"-f", "--format"},
            description = "The format that the date time will be displayed",
            validateWith = DateTimeFormatterValidator.class)
    String dateFormat = DEFAULT_FORMAT;

    /**
     * Represents if the help text should be displayed.
     */
    @Parameter(names = "--help", description = "Displays this help and exits", help = true)
    boolean help;
}
