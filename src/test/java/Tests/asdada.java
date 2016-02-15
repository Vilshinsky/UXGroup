package Tests;

import Common.Teh;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Alexander on 14.02.2016.
 */
public class asdada {
    @Before
    public void setUp() {
        Teh.runDriver("firefox");
    }

    @After
    public void tearDown() {
        Teh.quit();
    }

    @Test
    public void name1() {
        Teh.waitSec(2);
    }
    @Test
    public void name2() {
        Teh.waitSec(2);
    }
    @Test
    public void name3() {
        Teh.waitSec(2);
    }
    @Test
    public void name4() {
        Teh.waitSec(2);
    }
    @Test
    public void name5() {
        Teh.waitSec(2);
    }
}
