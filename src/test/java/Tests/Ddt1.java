package Tests;

import Common.Teh;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Ddt1 {
    private String browser;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"chrome"}
        });
    }

    public Ddt1(String browser) {
        this.browser = browser;
    }

    @Test
    public void multipleTests() {
        Teh.runDriver(browser);
        Teh.waitSec(3);
        Teh.quit();
    }
    @Test
    public void multipleTests2() {
        Teh.runDriver(browser);
        Teh.waitSec(3);
        Teh.quit();
    }
    @Test
    public void multipleTests3() {
        Teh.runDriver(browser);
        Teh.waitSec(3);
        Teh.quit();
    }



}
