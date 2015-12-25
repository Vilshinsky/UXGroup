package PageObjects;

import Common.TestHelper;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class ReviewPage {
    public static String xpathReviewInReviews = "//a[contains(@href,'/story')]";
    public static String xpathFirstStar = "//i[contains(@class,'vp_star-star_1')]";
    public static String xpathSecondStar = "//i[contains(@class,'vp_star-star_2')]";
    public static String xpathThirdStar = "//i[contains(@class,'vp_star-star_3')]";
    public static String xpathFourthStar = "//i[contains(@class,'vp_star-star_4')]";
    public static String xpathFifthStar = "//i[contains(@class,'vp_star-star_5')]";
    public static String xpathButtonNextOrGoBack = "//input[@type='submit']";
    public static String xpathTextareaReview = "//textarea";
    public static String xpathButtonSubmitReview = "//input[contains(@class,'submit-my-review')]";
    public static String xpathTextReview = "//*[contains(@class,'comment')]/*[contains(@class,'wl-review-answer')]";

    public static String xpathNoRateErrorMessage = "//*[contains(@class,'status-message')]/div[text()]";
    public static String xpathNoTextErrorMessage = "//*[contains(@class,'status-message') and text()]";

    public static String xpathLovesCounterReview = "//p[contains(@class,'wl-like-widget-result')]/span";
    public static String xpathButtonLoveReview = "//a[contains(@href,'/like')]";
    public static String xpathButtonUnLoveReview = "//a[contains(@href,'/unlike')]";

    @Step
    public static void setRate() {
        TestHelper.waitXpathElement(xpathFirstStar).click();
    }
    @Step
    public static void clickOnNextButton() {
        TestHelper.waitXpathElement(xpathButtonNextOrGoBack).isDisplayed();
        TestHelper.waitXpathElement(xpathButtonNextOrGoBack).isEnabled();
        TestHelper.waitSec(1);
        TestHelper.waitXpathElement(xpathButtonNextOrGoBack).click();
    }
    @Step
    public static void fillInTextarea() {
        TestHelper.waitXpathElement(xpathTextareaReview).sendKeys("Selenium review body text.");
    }
    @Step
    public static void clickOnSubmitMyReviewButton() {
        TestHelper.waitXpathElement(xpathButtonSubmitReview).click();
    }
    @Step
    public static void verifyThatReviewIsAdded() {
        Assert.assertEquals("Selenium review body text.", TestHelper.waitXpathElement(xpathTextReview).getText());
    }

    @Step
    public static void verifyThatNoRateErrorMessageIsDisplayed() {
        Assert.assertEquals(true, TestHelper.waitXpathElement(xpathNoRateErrorMessage).isDisplayed());
    }

    @Step
    public static void verifyThatNoTextErrorMessageIsDisplayed() {
        Assert.assertEquals(true, TestHelper.waitXpathElement(xpathNoTextErrorMessage).isDisplayed());
    }

    public static int initialLoveCounterReview = 0;
    public static int finalLoveCounterReview = 0;
    public static int getReviewLoveState() {
        int intCounter = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounterReview).getText());
        return intCounter;
    }
    @Step("Add Love in review.")
    public static void loveReview() {
        TestHelper.scrollPage(500);
        initialLoveCounterReview = getReviewLoveState();
        TestHelper.waitXpathElement(xpathButtonLoveReview).click();
        int getInt = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounterReview).getText());
        for(int i = 0; i < 450; i++) {
            if(getInt > initialLoveCounterReview) {
                break;
            }
            TestHelper.waitMsec(100);
            getInt = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounterReview).getText());
        }
    }
    @Step("Remove love in review.")
    public static void unLoveReview() {
        TestHelper.scrollPage(500);
        initialLoveCounterReview = getReviewLoveState();
        TestHelper.waitXpathElement(xpathButtonUnLoveReview).click();
        int getInt = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounterReview).getText());
        for(int i = 0; i < 450; i++) {
            if(getInt < initialLoveCounterReview) {
                break;
            }
            TestHelper.waitMsec(100);
            getInt = Integer.parseInt(TestHelper.waitXpathElement(xpathLovesCounterReview).getText());
        }
    }

    @Step("Verify that loves counter in review is increased by 1")
    public static void verifyThatLovesCounterIsIncreased() {
        finalLoveCounterReview = getReviewLoveState();
        System.out.println("Should increase in review. Loves before: " +
                initialLoveCounterReview + " Loves after: " + finalLoveCounterReview);
        Assert.assertEquals(initialLoveCounterReview + 1,finalLoveCounterReview);
    }

    @Step("Verify that loves counter in article is decreased by 1")
    public static void verifyThatLovesCounterIsDecreased() {
        getReviewLoveState();
        finalLoveCounterReview = getReviewLoveState();
        System.out.println("Should decrease in review. Loves before: " + initialLoveCounterReview +
                " Loves after: " + finalLoveCounterReview);
        Assert.assertEquals(initialLoveCounterReview - 1,finalLoveCounterReview);
    }
}
