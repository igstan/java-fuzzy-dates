package ro.igstan.fuzzy;

import java.util.Calendar;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public class FuzzyDateFormatter {

    private final Calendar currentTime;

    private final FuzzyDateMessages fuzzyMessages;


    public FuzzyDateFormatter(Calendar currentTime, FuzzyDateMessages fuzzyMessages) {
        this.currentTime   = currentTime;
        this.fuzzyMessages = fuzzyMessages;
    }

    public String timeAgo(Calendar before) {
        long beforeSeconds = before.getTimeInMillis() / 1000;
        long nowSeconds = currentTime.getTimeInMillis() / 1000;
        long numberOfSeconds = nowSeconds - beforeSeconds;

        if (numberOfSeconds < 60) {
            return timeAgoSeconds(numberOfSeconds);
        } else if (numberOfSeconds < 3600) {
            return timeAgoMinutes(numberOfSeconds);
        } else if (numberOfSeconds < 3600 * 24) {
            return timeAgoHours(numberOfSeconds);
        } else {
            return timeAgoDays(numberOfSeconds);
        }
    }

    private String timeAgoSeconds(long numberOfSeconds) {
        if (numberOfSeconds == 1) {
            return fuzzyMessages.oneSecondAgo();
        } else {
            return fuzzyMessages.someSecondsAgo(numberOfSeconds);
        }
    }

    private String timeAgoMinutes(long numberOfSeconds) {
        long numberOfMinutes = numberOfSeconds / 60;

        if (numberOfMinutes == 1) {
            return fuzzyMessages.oneMinuteAgo();
        } else {
            return fuzzyMessages.someMinutesAgo(numberOfMinutes);
        }
    }

    private String timeAgoHours(long numberOfSeconds) {
        long numberOfHours = numberOfSeconds / 3600;

        if (numberOfHours == 1) {
            return fuzzyMessages.oneHourAgo();
        } else {
            return fuzzyMessages.someHoursAgo(numberOfHours);
        }
    }

    private String timeAgoDays(long numberOfSeconds) {
        long numberOfDays = numberOfSeconds / 3600 / 24;

        if (numberOfDays == 1) {
            return fuzzyMessages.oneDayAgo();
        } else {
            return fuzzyMessages.someDaysAgo(numberOfDays);
        }
    }
}
