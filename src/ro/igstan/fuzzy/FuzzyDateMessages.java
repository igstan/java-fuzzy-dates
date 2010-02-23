package ro.igstan.fuzzy;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public interface FuzzyDateMessages {

    public String oneSecondAgo();

    public String someSecondsAgo(int diff);

    public String oneMinuteAgo();

    public String someMinutesAgo(int diff);

    public String oneHourAgo();

    public String someHoursAgo(int numberOfHours);

    public String oneDayAgo();

    public String someDaysAgo(int numberOfDays);

    public String oneWeekAgo();

    public String someWeeksAgo(int numberOfWeeks);

    public String oneMonthAgo();

    public String someMonthsAgo(int numberOfMonths);

    public String oneYearAgo();

    public String someYearsAgo(int numberOfYears);

}
