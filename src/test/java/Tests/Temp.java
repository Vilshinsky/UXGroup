package Tests;

import Common.Environments;
import Common.TestHelper;
import PageObjects.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Temp {
    @BeforeClass
    public static void setPrecondition() {
        TestHelper.runDriverFullscreen("firefox");
        Environments.createMailBox();
        Environments.passRegistration();
        TestHelper.quit();
    }
    @Before
    public void setUp() {
        TestHelper.runDriverFullscreen("firefox");
    }
    @After
    public void tearDown() {
        TestHelper.quit();
    }

    @Features("Loves")
    @Stories("User should be able to add loves in review")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void a_shouldBeAbleToAddLoveInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        Environments.logIn();
        ReviewPage.loveReview();
        ReviewPage.verifyThatLovesCounterIsIncreased();
    }

    @Features("Loves")
    @Stories("User should be able to unlove in review")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void b_shouldBeAbleToDeleteLoveInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        Environments.logIn();
        ReviewPage.unLoveReview();
        ReviewPage.verifyThatLovesCounterIsDecreased();
    }

    @Features("Reviews")
    @Stories("User should see error message when tries to continue reviewing without filling of textarea")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void shouldSeeErrorMessageWhenNoTextInTextarea() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.setRate();
        ReviewPage.clickOnNextButton();
        ReviewPage.clickOnSubmitMyReviewButton();
        ReviewPage.verifyThatNoTextErrorMessageIsDisplayed();
    }

    @Features("Reviews")
    @Stories("User should see error message when tries to continue reviewing without setting of rate")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageWhenNoStarsSetInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.clickOnNextButton();
        ReviewPage.verifyThatNoRateErrorMessageIsDisplayed();
    }
}
