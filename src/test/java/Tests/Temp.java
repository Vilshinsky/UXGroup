package Tests;

import Common.Environments;
import Common.TestHelper;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import PageObjects.ReviewPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Temp {
    @Before
    public void setUp() {
        TestHelper.runDriverFullscreen("firefox");
    }
    @After
    public void tearDown() {
        TestHelper.quit();
    }

    @Test
    public void shouldSeeErrorMessageWhenNoTextInTextarea() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.setRate();
        ReviewPage.clickOnNextButton();
        ReviewPage.clickOnSubmitMyReviewButton();
        ReviewPage.verifyThatNoTextErrorMessageIsDisplayed();
    }
}
