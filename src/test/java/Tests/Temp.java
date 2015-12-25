package Tests;

import Common.Environments;
import Common.TestHelper;
import PageObjects.*;
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
}
