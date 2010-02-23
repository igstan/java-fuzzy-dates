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
}
