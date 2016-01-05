package Tests;

import Common.Teh;
import org.junit.Test;

public class ResponseTime {
    @Test
    public void test() {
        Teh.runDriver("firefox");
        long startTime = System.currentTimeMillis();
        Teh.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
        Teh.waitIdElement("Calculate");
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Page Load Time: " + totalTime + "milliseconds");
    }
}
