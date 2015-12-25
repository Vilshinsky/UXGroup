package Tests;

import Common.Environments;
import Common.TestHelper;
import PageObjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Temp {
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
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin("20151225183833@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        AuthorizationPage.submitAuthorization();
        ReviewPage.loveReview();
        ReviewPage.verifyThatLovesCounterIsIncreased();
    }
    @Features("Comments")
    @Stories("User should be able to leave comments in articles")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void a_shouldBeAbleToAddCommentInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin("20151225183833@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        AuthorizationPage.submitAuthorization();
        ArticlePage.fillTextAreaByComment();
        ArticlePage.clickOnPostMyCommentButton();
        ArticlePage.verifyThatCommentIsAdded();
    }
    @Features("Loves")
    @Stories("User should be able to unlove in review")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void b_shouldBeAbleToDeleteLoveInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin("20151225183833@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        AuthorizationPage.submitAuthorization();
        ReviewPage.unLoveReview();
        ReviewPage.verifyThatLovesCounterIsDecreased();
    }
}
