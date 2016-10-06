package me.andrewmanley.timearoundtheworld;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

public class TimeAroundTheWorld {
    private DateTimeFormatter format;

    /**
     * Creates a new TimeAroundTheWorld object that will display the DateTimes with the given format.
     *
     * @param args The {@link DateTimeArgs} that determine how the data will be displayed.
     */
    public TimeAroundTheWorld(DateTimeArgs args) {
        format = DateTimeFormatter.ofPattern(args.dateFormat);
    }

    /**
     * Displays a list of times based on different time zones.
     */
    public void displayTimes() {
        // Get all the different zones
        Collection<String> zoneIds = ZoneId.getAvailableZoneIds();
        // Sort the zones so it is easier to look through the list
        String[] sortedZoneIds = zoneIds.toArray(new String[zoneIds.size()]);
        Arrays.sort(sortedZoneIds);
        for (String zoneId : sortedZoneIds) {
            ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(zoneId));
            System.out.println(zoneId + " - " + dateTime.format(format));
        }
    }

    public static void main(String[] argv) {
        DateTimeArgs args = new DateTimeArgs();
        // Parse the command line arguments
        try {
            JCommander jc = new JCommander(args, argv);
            // If the help option was specified display the usage and exit
            if (args.help) {
                jc.usage();
                return;
            }
        } catch (ParameterException e) {
            // If there is an error parsing the arguments print out a message and display the proper usage and exit
            System.err.println(e.getMessage());
            new JCommander(args).usage();
            System.exit(1);
        }

        // Display the times
        new TimeAroundTheWorld(args).displayTimes();
    }
}
