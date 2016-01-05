package Tests;

import Common.Teh;
import org.junit.Assert;
import org.junit.Test;

public class Learning {
    @Test
    public void ssertionTest() {
        Teh.runDriver("firefox");
        Teh.get("http://twitter.com");
        Assert.assertEquals("Page title is not expected.", "Twitt", Teh.driver.getTitle());
        Teh.quit();
    }
}
