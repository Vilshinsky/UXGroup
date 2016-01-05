package PageObjects;

import Common.Teh;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class AuthorizationPage {
    public static String xpathInputLogin = "//*[@id='edit-name']";
    public static String xpathInputPassword = "//*[@id='edit-pass']";
    public static String xpathRememberMeButton = "//*[@id='edit-remember-me']";
    public static String xpathSubmitButton = "//*[@id='edit-submit']";
    public static String xpathButtonFacebookSignIn = "//a[contains(@class,'button-primary facebook')]";
    public static String xpathLinkForgotPassword = "//a[contains(@title,'user/password')]";

    @Step("Fill Email input with valid value.")
    public static void fillInputLogin(String login) {
        Teh.waitXpathElement(xpathInputLogin).sendKeys(login);
    }

    @Step("Fill Password input with valid value.")
    public static void fillInputPassword(String password) {
        Teh.waitXpathElement(xpathInputPassword).sendKeys(password);
    }

    @Step("Click on Submit button.")
    public static void submitAuthorization() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathSubmitButton).isEnabled()) {
                Teh.waitXpathElement(xpathSubmitButton).click();
                break;
            }
            Teh.waitMsec(100);
        }
        Teh.longWaitXpathElement("//*[contains(@class,'wl-user-menu')]//*[contains(@class,'user-picture')]");
    }

    @Step("Make sure that welcome message appeared.")
    public static void verifyWelcomeMessage() {
        Assert.assertEquals(true, Teh.waitXpathElement(HomePage.xpathUserAvatar).isDisplayed());
    }

    @Step("Make sure that Sign In with Facebook button is exist and enabled.")
    public static void verifyAvailabilityOfFacebookButton() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathButtonFacebookSignIn).isEnabled());
    }

    @Step("Make sure that Forgot your password? link is exist and enabled.")
    public static void verifyAvailabilityOfForgorPasswordLink() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathLinkForgotPassword).isEnabled());
    }
}
