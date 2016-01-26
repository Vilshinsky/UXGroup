package Tests;

import Common.Environments;
import Common.Teh;
import PageObjects.AuthorizationPage;
import PageObjects.HomePage;
import PageObjects.ReviewPage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.FluentWait;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WaiterTest {
    //    @BeforeClass
//    public static void setPrecondition() {
//        Teh.runDriverFullscreen("firefox");
//        Environments.createMailBox();
//        Environments.passRegistration();
//        Teh.quit();
//    }

    @Before
    public void setUp() {
        Teh.runDriverFullscreen("firefox");
    }

    @After
    public void tearDown() {
        Teh.quit();
    }

    @Features("Authorization")
    @Stories("User should be able to log in via existed account")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void userShouldBeAbleToLogIn() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin(Environments.emailValue + "@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        Teh.waitJqueryInactive();
        Teh.waitXpathElement(AuthorizationPage.xpathSubmitButton).click();
        AuthorizationPage.verifyWelcomeMessage();
    }

}
