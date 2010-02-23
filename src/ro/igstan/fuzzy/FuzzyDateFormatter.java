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
        long diff = nowSeconds - beforeSeconds;

        if (diff == 1) {
            return fuzzyMessages.oneSecondAgo();
        } else {
            if (diff < 60) {
                return fuzzyMessages.someSecondsAgo(diff);
            } else {
                diff = diff / 60;

                if (diff == 1) {
                    return fuzzyMessages.oneMinuteAgo();
                } else {
                    return fuzzyMessages.someMinutesAgo(diff);
                }
            }
        }
    }
}
