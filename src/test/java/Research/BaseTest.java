package Research;

import org.junit.After;
import org.junit.Before;

/**
 * Created by Alexander on 02.02.2016.
 */
public class BaseTest {

    @Before
    public void pre() {
        Driver.start();
    }

    @After
    public void post() {
        Driver.finish();
    }
}
