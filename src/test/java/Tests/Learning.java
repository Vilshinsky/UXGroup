package Tests;

import Common.Teh;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Learning {
    @Test
    public void ssertionTest() {
        Teh.runDriver("firefox");
        Teh.get("http://twitter.com");
        Assert.assertEquals("Page title is not expected.", "Twitt", Teh.driver.getTitle());
        Teh.quit();
    }
}
