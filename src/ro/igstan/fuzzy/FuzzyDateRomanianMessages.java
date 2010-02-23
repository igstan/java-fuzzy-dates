package ro.igstan.fuzzy;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public class FuzzyDateRomanianMessages implements FuzzyDateMessages {

    public String oneSecondAgo() {
        return "acum 1 secundă";
    }

    public String someSecondsAgo(long diff) {
        return "acum " + diff + " secunde";
    }

    public String oneMinuteAgo() {
        return "acum 1 minut";
    }

    public String someMinutesAgo(long diff) {
        return "acum " + diff + " minute";
    }

    public String oneHourAgo() {
        return "acum 1 oră";
    }

    public String someHoursAgo(long numberOfHours) {
        return "acum " + numberOfHours + " ore";
    }
}
