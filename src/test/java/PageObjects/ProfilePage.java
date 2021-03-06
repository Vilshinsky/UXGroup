package PageObjects;

import Common.Environments;
import Common.Teh;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class ProfilePage {
    public static String xpathLinkToCommentsSection = "//a[contains(@href,'/comments')]";
    public static String xpathCommentInCommentsSection = "//*[contains(text(),'Selenium autotest comment')]";
    public static String xpathButtonDeleteCommentLove = "//a[text()='delete']";
    public static String xpathButtonYesDeleteComment = "//button[text()='Yes']";

    public static String xpathLinkToLovesSection = "//*[@class='vp_tab_loves']";
    public static String xpathLoveInLovesSection = "//*[@class='topic-title']//a";

    public static String xpathBioTextArea = "//*[contains(@class,'edit-bio-wrap')]//textarea";
    public static String xpathButtonBioSubmit = "//*[contains(@class,'edit-bio-wrap')]/input";
    public static String xpathTextBio = "//*[contains(@class,'biography-inner')]/p";

    public static String xpathWelcomeMessageInProfile = "//*[contains(@class,'biography-inner')]//h2";

    public static String xpathButtonConnectFacebook = "//a[contains(@class,'social-btn-connect facebook')]";
    public static String xpathButtonConnectTwitter = "//a[contains(@class,'social-btn-connect twitter')]";
    public static String xpathButtonConnectBlog = "//a[contains(@href,'/blog')]";

    @Step("Click on Comments section link in profile.")
    public static void goToCommentsSection() {
        Teh.waitXpathElement(xpathLinkToCommentsSection).click();
    }

    @Step("Verify that previously added comments are displayed.")
    public static void verifyThatCommentInSectionIsDisplayed() {
        Assert.assertEquals("Selenium autotest comment.", Teh.waitXpathElement(xpathCommentInCommentsSection).getText());
    }

    @Step("Click on Delete button to remove comment.")
    public static void deleteComment() {
        Teh.waitXpathElement(xpathButtonDeleteCommentLove).click();
    }

    @Step("Confirm deleting by click on Yes button in pop up.")
    public static void confirmDeleteComment() {
        Teh.waitMsec(1500);
        Teh.waitXpathElement(xpathButtonYesDeleteComment).click();
    }

    @Step("Make sure that deleted comment isn't displays now.")
    public static void verifyThatCommentIsDeleted() {
        Assert.assertEquals(true, Teh.waitXpathElementNotExist(xpathCommentInCommentsSection));
    }

    @Step("Click on Loves section link in profile.")
    public static void goToLovesSection() {
        Teh.waitXpathElement(xpathLinkToLovesSection).click();
    }

    @Step("Verify that there is Love in Loves section.")
    public static void verifyLoveInLovesSection() {
        Teh.waitXpathElement(xpathLoveInLovesSection);
        Assert.assertEquals("Selenium Article", Teh.waitXpathElement(xpathLoveInLovesSection).getText());
    }

    @Step("Click delete button in Loves section of user profile.")
    public static void deleteLoveInProfile() {
        Teh.waitXpathElement(xpathButtonDeleteCommentLove).click();
    }

    @Step("Confirm deleting by click on Yes button in pop up.")
    public static void confirmDeleteLove() {
        Teh.waitMsec(1500);
        Teh.waitXpathElement(xpathButtonYesDeleteComment).click();
    }

    @Step("Verify that deleted love isn't displays in Loves section of user profile.")
    public static void verifyLoveDeleted() {
        Assert.assertEquals(true, Teh.waitXpathElementNotExist(xpathLoveInLovesSection));
    }

    @Step("Fill in bio text area.")
    public static void fillInBioTextArea() {
        Teh.waitXpathElement(xpathBioTextArea).sendKeys("Some biographical text about user.");
    }

    @Step("Click on Submit button.")
    public static void submitBioChanges() {
        Teh.scrollPage(100);
        Teh.waitXpathElement(xpathButtonBioSubmit).isDisplayed();
        Teh.waitXpathElement(xpathButtonBioSubmit).isEnabled();
        Teh.waitXpathElement(xpathButtonBioSubmit).click();
    }

    @Step("Verify that changes in bio is appeared in profile.")
    public static void verifyThatChangesInProfileIsAppeared() {
        Assert.assertEquals("Some biographical text about user.", Teh.waitXpathElement(xpathTextBio).getText());
    }

    @Step("Verify that welcome message is appeared.")
    public static void verifyThatWelcomeMessageInProfileIsAppeared() {
        if (Teh.waitXpathElement("//h3[contains(text(),'Hello,')]").isDisplayed()) {
            Assert.assertEquals(Environments.emailValue + " S.", Teh.waitXpathElement(xpathWelcomeMessageInProfile).getText().replace("Hi. I'm ", ""));
        } else if (Teh.waitXpathElement("//h3[contains(text(),'Hola,')]").isDisplayed()) {
            Assert.assertEquals(Environments.emailValue + " S.", Teh.waitXpathElement(xpathWelcomeMessageInProfile).getText().replace("Hola, soy ", ""));
        }
    }

    @Step("Verify that Connect with Facebook button is enabled.")
    public static void verifyThatConnectFacebookEnabled() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathButtonConnectFacebook).isEnabled());
    }

    @Step("Verify that Connect with Twitter button is enabled.")
    public static void verifyThatConnectTwitterEnabled() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathButtonConnectTwitter).isEnabled());
    }

    @Step("Verify that Connect Your Blog button is enabled.")
    public static void verifyThatConnectBlogEnabled() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathButtonConnectBlog).isEnabled());
    }
}
