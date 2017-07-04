package ru.job4j;

import org.junit.Test;

/**
 * Created by Anton on 04.07.2017.
 */
public class StatisticStringTest {
    /**
     * Test.
     */
    @Test
    public void whenPutStringThenGetStatistic() {
        StatisticString statisticString = new StatisticString();
        statisticString.analysis(" asda sada adas ");
        statisticString.analysis("sda sada adas");
    }
}
