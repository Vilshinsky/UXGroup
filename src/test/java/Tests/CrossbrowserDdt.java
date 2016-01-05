package Tests;

import Common.Teh;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CrossbrowserDdt {
    private String browser;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"firefox"},
                {"ie"}
        });
    }

    public CrossbrowserDdt(String browser) {
        this.browser = browser;
    }

    @Test
    public void multipleTests() {
        Teh.runDriver(browser);
        Teh.quit();
    }
}
