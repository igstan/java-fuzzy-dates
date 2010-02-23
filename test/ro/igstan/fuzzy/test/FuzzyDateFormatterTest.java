package ro.igstan.fuzzy.test;

import java.util.Calendar;

import org.junit.Test;
import static org.junit.Assert.*;

import ro.igstan.fuzzy.FuzzyDateFormatter;
import ro.igstan.fuzzy.FuzzyDateMessages;
import ro.igstan.fuzzy.FuzzyDateRomanianMessages;

/**
 * @author Ionut G. Stan <ionut.g.stan@gmail.com>
 */

public class FuzzyDateFormatterTest {

    @Test
    public void acum1Secundă() {
        FuzzyDateMessages fuzzyMessages = new FuzzyDateRomanianMessages();

        Calendar now = Calendar.getInstance();
        now.set(2010, Calendar.FEBRUARY, 22, 16, 50, 50);

        Calendar before = Calendar.getInstance();
        before.set(2010, Calendar.FEBRUARY, 22, 16, 50, 49);

        FuzzyDateFormatter fuzzyFormatter = new FuzzyDateFormatter(now, fuzzyMessages);
        assertEquals("acum 1 secundă", fuzzyFormatter.timeAgo(before));
    }

    @Test
    public void acum2Secunde() {
        FuzzyDateMessages fuzzyMessages = new FuzzyDateRomanianMessages();

        Calendar now = Calendar.getInstance();
        now.set(2010, Calendar.FEBRUARY, 22, 16, 50, 50);

        Calendar before = Calendar.getInstance();
        before.set(2010, Calendar.FEBRUARY, 22, 16, 50, 48);

        FuzzyDateFormatter fuzzyFormatter = new FuzzyDateFormatter(now, fuzzyMessages);
        assertEquals("acum 2 secunde", fuzzyFormatter.timeAgo(before));
    }

    @Test
    public void acum3Secunde() {
        FuzzyDateMessages fuzzyMessages = new FuzzyDateRomanianMessages();

        Calendar now = Calendar.getInstance();
        now.set(2010, Calendar.FEBRUARY, 22, 16, 50, 50);

        Calendar before = Calendar.getInstance();
        before.set(2010, Calendar.FEBRUARY, 22, 16, 50, 47);

        FuzzyDateFormatter fuzzyFormatter = new FuzzyDateFormatter(now, fuzzyMessages);
        assertEquals("acum 3 secunde", fuzzyFormatter.timeAgo(before));
    }
}
