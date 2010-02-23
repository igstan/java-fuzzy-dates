package ro.igstan.fuzzy;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public interface FuzzyDateMessages {

    public String oneSecondAgo();

    public String someSecondsAgo(long diff);

    public String oneMinuteAgo();

    public String someMinutesAgo(long diff);

}
