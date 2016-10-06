# time-around-the-world
This project simply gets the current time from around the world

## Building
To build the application from the root directory run 

    ./gradlew fatJar

To remove the previous build files run

    ./gradlew clean

## Using
To run the application run

    java -jar build/libs/TimeAroundTheWorld-all-1.0.0.jar

You can optionally specify -f or --format at the end to specify a specific
format string for the DateTime. For reference on valid formats please refer
to the [java api](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns).

E.g. The following would display January 1st 2016 11:59:00 PM as 1/01/2016 23:59:00
    
    java -jar build/libs/TimeAroundTheWorld-all-1.0.0.jar -f "d/MM/yyyy k:m:s"
