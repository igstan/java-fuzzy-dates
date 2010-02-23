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
    private static final int ONE_WEEK   =  7 * ONE_DAY;
    private static final int ONE_MONTH  =  4 * ONE_WEEK;
    private static final int ONE_YEAR   = 12 * ONE_MONTH;

    private final static int UNIT_SECONDS = 1;
    private final static int UNIT_MINUTES = 2;
    private final static int UNIT_HOURS   = 3;
    private final static int UNIT_DAYS    = 4;
    private final static int UNIT_WEEKS   = 5;
    private final static int UNIT_MONTHS  = 6;
    private final static int UNIT_YEARS   = 7;

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

        if (timeDifference < ONE_MINUTE) {
            return timeAgoSeconds(timeDifference);
        } else if (timeDifference < ONE_HOUR) {
            return timeAgoMinutes(timeDifference / ONE_MINUTE);
        } else if (timeDifference < ONE_DAY) {
            return timeAgoHours(timeDifference / ONE_HOUR);
        } else if (timeDifference < ONE_WEEK) {
            return timeAgoDays(timeDifference / ONE_DAY);
        } else if (timeDifference < ONE_MONTH) {
            return timeAgoWeeks(timeDifference / ONE_WEEK);
        } else if (timeDifference < ONE_YEAR) {
            return timeAgoMonths(timeDifference / ONE_MONTH);
        } else {
            return timeAgoYears(timeDifference / ONE_YEAR);
        }
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
            case UNIT_SECONDS:
                return fuzzyMessages.someSecondsAgo(difference);
            case UNIT_MINUTES:
                return fuzzyMessages.someMinutesAgo(difference);
            case UNIT_HOURS:
                return fuzzyMessages.someHoursAgo(difference);
            case UNIT_DAYS:
                return fuzzyMessages.someDaysAgo(difference);
            case UNIT_WEEKS:
                return fuzzyMessages.someWeeksAgo(difference);
            case UNIT_MONTHS:
                return fuzzyMessages.someMonthsAgo(difference);
            case UNIT_YEARS:
                return fuzzyMessages.someYearsAgo(difference);
            default:
                return "Unknown multi unit";
        }
    }

    private String callSingleUnit(int unit) {
        switch (unit) {
            case UNIT_SECONDS:
                return fuzzyMessages.oneSecondAgo();
            case UNIT_MINUTES:
                return fuzzyMessages.oneMinuteAgo();
            case UNIT_HOURS:
                return fuzzyMessages.oneHourAgo();
            case UNIT_DAYS:
                return fuzzyMessages.oneDayAgo();
            case UNIT_WEEKS:
                return fuzzyMessages.oneWeekAgo();
            case UNIT_MONTHS:
                return fuzzyMessages.oneMonthAgo();
            case UNIT_YEARS:
                return fuzzyMessages.oneYearAgo();
            default:
                return "Unknown single unit";
        }
    }

    private String timeAgoSeconds(int numberOfSeconds) {
        return callUnit(UNIT_SECONDS, numberOfSeconds);
    }

    private String timeAgoMinutes(int numberOfMinutes) {
        return callUnit(UNIT_MINUTES, numberOfMinutes);
    }

    private String timeAgoHours(int numberOfHours) {
        return callUnit(UNIT_HOURS, numberOfHours);
    }

    private String timeAgoDays(int numberOfDays) {
        return callUnit(UNIT_DAYS, numberOfDays);
    }

    private String timeAgoWeeks(int numberOfWeeks) {
        return callUnit(UNIT_WEEKS, numberOfWeeks);
    }

    private String timeAgoMonths(int numberOfMonths) {
        return callUnit(UNIT_MONTHS, numberOfMonths);
    }

    private String timeAgoYears(int numberOfYears) {
        return callUnit(UNIT_YEARS, numberOfYears);
    }
}
