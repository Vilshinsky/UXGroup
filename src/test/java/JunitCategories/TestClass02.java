package JunitCategories;

import Common.Teh;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by Alexander on 15.02.2016.
 */
public class TestClass02 {
    @Test
    @Category({CategoryClass01.class, CategoryClass02.class})
    public void name1() {
        Teh.waitSec(2);
    }
    @Test
    @Category({CategoryClass01.class, CategoryClass02.class})
    public void name2() {
        Teh.waitSec(2);
    }
    @Test
    @Category({CategoryClass01.class, CategoryClass02.class})
    public void name3() {
        Teh.waitSec(2);
    }
    @Test
    @Category({CategoryClass01.class, CategoryClass02.class})
    public void name4() {
        Teh.waitSec(2);
    }
    @Test
    @Category({CategoryClass01.class, CategoryClass02.class})
    public void name5() {
        Teh.waitSec(2);
    }
}
