package PageObjects;

import Common.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class ArticlePage {
    public static String xpathTextAreaComment = "//textarea[contains(@class,'form-textarea')]";
    public static String xpathButtonPostComment = "//*[@class='wl-upload-media-submit']//input[@type='submit']";
    public static String xpathComment = "//*[@class='users-comment']//a[contains(@class,'username')]";
    public static String xpathButtonLoveArticle = "//a[contains(@href,'/node/')]";
    public static String xpathLovesCounter = "//a[contains(@href,'/node/')]/following-sibling::p/span[contains(@content,'UserLikes')]";
    public static String xpathButtonUnLoveArticle = "//a[contains(@href,'/node/')][contains(@href,'/unlike')]";

    public static String xpathTitlesArticle = "//*[@itemprop='name']";

    public static String xpathLoveUnauthorized = "//*[contains(@class,'wl-article-page-content')]//a[contains(@class,'like-btn')]";
    public static String xpathCommentsBlockUnauthorized = "//*[contains(@class,'wl-comments-auth')]";
    public static String xpathCommentsBlockLoginUnauthorized = "//*[contains(@class,'wl-comments-auth')]/a[contains(@href,'/login')]";
    public static String xpathCommentsBlockRegisterUnauthorized = "//*[contains(@class,'wl-comments-auth')]/a[contains(@href,'/register')]";


    @Step("Go to the text area for user's comment and fill it by some text.")
    public static void fillTextAreaByComment() {
        TestHelper.waitXpathElement(xpathTextAreaComment).sendKeys("Selenium autotest comment.");
    }
    @Step("Click on Post My comment button.")
    public static void clickOnPostMyCommentButton() {
        TestHelper.waitXpathElement(xpathButtonPostComment).click();
    }
    @Step("Verify that comment appears on the page.")
    public static void verifyThatCommentIsAdded() {
        TestHelper.waitXpathElement(xpathComment);
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathComment).isDisplayed());
    }

    public static int initialLoveCounter = 0;
    public static int finalLoveCounter = 0;
    public static int getLoveState() {
        int intCounter = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounter).getText());
        return intCounter;
    }
    @Step("Add Love in article.")
    public static void loveArticle() {
        initialLoveCounter = getLoveState();
        TestHelper.waitXpathElement(xpathButtonLoveArticle).click();
        TestHelper.waitSec(1);
    }
    @Step("Remove love in article.")
    public static void unLoveArticle() {
        initialLoveCounter = getLoveState();
        TestHelper.waitXpathElement(xpathButtonUnLoveArticle).click();
        TestHelper.waitSec(1);
    }

    @Step("Verify that loves counter in article is increased by 1")
    public static void verifyThatLovesCounterIsIncreased() {
        finalLoveCounter = getLoveState();
        System.out.println("Should increase in article. Loves before: " + initialLoveCounter + " Loves after: " + finalLoveCounter);
        Assert.assertEquals(initialLoveCounter + 1,finalLoveCounter);
    }

    @Step("Verify that loves counter in article is decreased by 1")
    public static void verifyThatLovesCounterIsDecreased() {
        getLoveState();
        finalLoveCounter = getLoveState();
        System.out.println("Should decrease in article. Loves before: " + initialLoveCounter + " Loves after: " + finalLoveCounter);
        Assert.assertEquals(initialLoveCounter - 1,finalLoveCounter);
    }

    @Step("Verify that current page is article")
    public static void verifyThatCurrentPageIsArticle() {
        TestHelper.waitXpathElement(HomePage.xpathButtonMyProfile);
        Assert.assertEquals("Selenium Article",TestHelper.driver.findElement(By.xpath(xpathTitlesArticle)).getText());
    }

    @Step("Add Love in article as unauthorized user.")
    public static void loveArticleUnauthorized() {
        TestHelper.waitXpathElement(xpathLoveUnauthorized).click();
        TestHelper.waitSec(1);
    }
    @Step("Verify that redirection to the authorization form is happened.")
    public static void verifyRedirectionToLogInAfterTryToAddLove() {
        TestHelper.waitXpathElement(AuthorizationPage.xpathInputLogin);
        Assert.assertEquals(true,TestHelper.driver.findElement(By.xpath(AuthorizationPage.xpathInputLogin)).isDisplayed());
    }

    @Step("Verify that comment block doesn't available to unauthorized user.")
    public static void verifyInabilityToLeaveCommentsByUnauthorizedUser() {
        TestHelper.waitXpathElement(xpathCommentsBlockUnauthorized);
        Assert.assertEquals(true,TestHelper.waitXpathElementNotExist(xpathTextAreaComment));
    }

    @Step("Verify that instead the comment block unauthorized user sees Sign In and Register buttons.")
    public static void verifyAvailabilityOfSignInAndRegisterButtonsInsteadCommentsBlock() {
        TestHelper.waitXpathElement(xpathCommentsBlockUnauthorized);
        Assert.assertEquals(true,TestHelper.driver.findElement(By.xpath(xpathCommentsBlockLoginUnauthorized)).isDisplayed());
        Assert.assertEquals(true,TestHelper.driver.findElement(By.xpath(xpathCommentsBlockRegisterUnauthorized)).isDisplayed());
    }
}
