package Tests;

import Common.TestHelper;
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
        TestHelper.runDriver(browser);
        TestHelper.quit();
    }
}
