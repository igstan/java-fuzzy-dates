package ro.igstan.fuzzy;

import java.util.Calendar;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public class FuzzyDateFormatter {

    private static final int SECONDS    = 1;
    private static final int ONE_MINUTE = 60 * SECONDS;
    private static final int ONE_HOUR   = 60 * ONE_MINUTE;
    private static final int ONE_DAY    = 24 * ONE_HOUR;

    private final Calendar currentTime;

    private final FuzzyDateMessages fuzzyMessages;


    public FuzzyDateFormatter(Calendar currentTime, FuzzyDateMessages fuzzyMessages) {
        this.currentTime   = currentTime;
        this.fuzzyMessages = fuzzyMessages;
    }

    public String timeAgo(Calendar before) {
        long beforeSeconds = before.getTimeInMillis() / 1000;
        long nowSeconds = currentTime.getTimeInMillis() / 1000;
        long timeDifference = nowSeconds - beforeSeconds;

        if (timeDifference < ONE_MINUTE) {
            return timeAgoSeconds(timeDifference);
        } else if (timeDifference < ONE_HOUR) {
            return timeAgoMinutes(timeDifference / ONE_MINUTE);
        } else if (timeDifference < ONE_DAY) {
            return timeAgoHours(timeDifference / ONE_HOUR);
        } else {
            return timeAgoDays(timeDifference / ONE_DAY);
        }
    }

    private String timeAgoSeconds(long numberOfSeconds) {
        if (numberOfSeconds == 1) {
            return fuzzyMessages.oneSecondAgo();
        } else {
            return fuzzyMessages.someSecondsAgo(numberOfSeconds);
        }
    }

    private String timeAgoMinutes(long numberOfMinutes) {
        if (numberOfMinutes == 1) {
            return fuzzyMessages.oneMinuteAgo();
        } else {
            return fuzzyMessages.someMinutesAgo(numberOfMinutes);
        }
    }

    private String timeAgoHours(long numberOfHours) {
        if (numberOfHours == 1) {
            return fuzzyMessages.oneHourAgo();
        } else {
            return fuzzyMessages.someHoursAgo(numberOfHours);
        }
    }

    private String timeAgoDays(long numberOfDays) {
        if (numberOfDays == 1) {
            return fuzzyMessages.oneDayAgo();
        } else {
            return fuzzyMessages.someDaysAgo(numberOfDays);
        }
    }
}
