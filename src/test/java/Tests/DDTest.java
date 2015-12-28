package Tests;

import Common.TestHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DDTest {
    private static StringBuffer verificationErrors = new StringBuffer();

    //Declare instance variables for the parameterized values in the 'DDTest' class.
    private String password;
    private String sitename;
    private String generatedPassword;

    //Define a method that will return the collection of parameters to the 'DDTest' class by using the @Parameters annotation.
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"blablabla", "blablabla", "e706b652"},
                {"asdasdasd", "asdasdasd", "18559b67"},
                {"wwwwwwwww", "wwwwwwwww", "bf10287e"}
        });
    }

    //Add a constructor to the 'DDTest' class, which will be used by the test runner to pass the parameters to the 'DDTest' class instance.
    public DDTest(String password, String sitename, String generatedPassword) {
        this.password = password;
        this.sitename = sitename;
        this.generatedPassword = generatedPassword;
    }

    //Finally, add the test case method 'testPasswordGenerator()' that uses parameterized variables. Also, add the setup() and teardown() methods to the 'DDTest' class.
    @Test
    public void testPasswordGenerator() throws Exception {
        TestHelper.runDriverAndGo("firefox", 1280, 900, "http://angel.net/~nic/passwd.html");
//Get the 'inputPassword' element and set the value using parameterised 'password' variable
        WebElement inputPassword = TestHelper.waitXpathElement("//*[@name='master']");
        inputPassword.clear();
        inputPassword.sendKeys(password);
//Get the 'siteName' element and set the value using parameterised 'sitename' variable
        WebElement siteName = TestHelper.waitXpathElement("//*[@name='site']");
        siteName.clear();
        siteName.sendKeys(sitename);
//Click on 'Generate' button
        TestHelper.waitXpathElement("//*[@type='submit']").click();
        try {
//Get the Generated Password input element and verify its value using parameterised 'generatedPassword' variable
            WebElement inputGeneratedPassword = TestHelper.waitXpathElement("//*[@name='password']");
            Assert.assertEquals(generatedPassword, inputGeneratedPassword.getAttribute("value"));
        } catch (Error e) {
//Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
            System.err.println("Assertion Fail " + verificationErrors.toString());
        }
        TestHelper.quit();
    }
}
