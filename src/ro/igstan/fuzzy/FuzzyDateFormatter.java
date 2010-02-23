package ro.igstan.fuzzy;

import java.util.Calendar;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public class FuzzyDateFormatter {

    private final static int SECONDS = 1;
    private final static int MINUTES = 60 * SECONDS;
    private final static int HOURS   = 60 * MINUTES;
    private final static int DAYS    = 24 * HOURS;
    private final static int WEEKS   =  7 * DAYS;
    private final static int MONTHS  =  4 * WEEKS;
    private final static int YEARS   = 12 * MONTHS;

    private final Calendar currentTime;

    private final FuzzyDateMessages fuzzyMessages;


    public FuzzyDateFormatter(Calendar currentTime, FuzzyDateMessages fuzzyMessages) {
        this.currentTime   = currentTime;
        this.fuzzyMessages = fuzzyMessages;
    }

    public String timeAgo(Calendar before) {
        int beforeSeconds = (int) (before.getTimeInMillis() / 1000);
        int nowSeconds = (int) (currentTime.getTimeInMillis() / 1000);
        int timeDifference = nowSeconds - beforeSeconds;

        int unit;

        if (timeDifference < MINUTES) {
            unit = SECONDS;
        } else if (timeDifference < HOURS) {
            unit = MINUTES;
            timeDifference = timeDifference / MINUTES;
        } else if (timeDifference < DAYS) {
            unit = HOURS;
            timeDifference = timeDifference / HOURS;
        } else if (timeDifference < WEEKS) {
            unit = DAYS;
            timeDifference = timeDifference / DAYS;
        } else if (timeDifference < MONTHS) {
            unit = WEEKS;
            timeDifference = timeDifference / WEEKS;
        } else if (timeDifference < YEARS) {
            unit = MONTHS;
            timeDifference = timeDifference / MONTHS;
        } else {
            unit = YEARS;
            timeDifference = timeDifference / YEARS;
        }

        return callUnit(unit, timeDifference);
    }

    private String callUnit(int unit, int difference) {
        if (difference == 1) {
            return callSingleUnit(unit);
        } else {
            return callMultiUnit(unit, difference);
        }
    }

    private String callMultiUnit(int unit, int difference) {
        switch (unit) {
            case SECONDS:
                return fuzzyMessages.someSecondsAgo(difference);
            case MINUTES:
                return fuzzyMessages.someMinutesAgo(difference);
            case HOURS:
                return fuzzyMessages.someHoursAgo(difference);
            case DAYS:
                return fuzzyMessages.someDaysAgo(difference);
            case WEEKS:
                return fuzzyMessages.someWeeksAgo(difference);
            case MONTHS:
                return fuzzyMessages.someMonthsAgo(difference);
            case YEARS:
                return fuzzyMessages.someYearsAgo(difference);
            default:
                throw new RuntimeException("Unknown multi unit");
        }
    }

    private String callSingleUnit(int unit) {
        switch (unit) {
            case SECONDS:
                return fuzzyMessages.oneSecondAgo();
            case MINUTES:
                return fuzzyMessages.oneMinuteAgo();
            case HOURS:
                return fuzzyMessages.oneHourAgo();
            case DAYS:
                return fuzzyMessages.oneDayAgo();
            case WEEKS:
                return fuzzyMessages.oneWeekAgo();
            case MONTHS:
                return fuzzyMessages.oneMonthAgo();
            case YEARS:
                return fuzzyMessages.oneYearAgo();
            default:
                throw new RuntimeException("Unknown single unit");
        }
    }
}
