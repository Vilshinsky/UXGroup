package PageObjects;

import Common.Teh;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {
    public static String xpathButtonRegistration = "//*[@class='wl-unreg-user-menu']/a[2]";
    public static String xpathButtonLogin = "//*[@class='wl-unreg-user-menu']/a[1]";

    public static String xpathUserAvatar = "//*[contains(@class,'user-picture')]";
    public static String xpathButtonMyProfile = "//a[contains(@href,'.com/profile/')]";

    public static String xpathLinksSocialOnFooter = "//a[contains(@class,'social-btn')]";

    public static String xpathButtonHamburger = "//a[contains(@class,'bt-menu-trigger')]";

    public static String xpathButtonOpenHamburger = "//a[contains(@class,'bt-menu-trigger')]";
    public static String xpathButtonCloseHamburger = "//a[contains(@class,'close-link')]";

    @Step("Click on Register button.")
    public static void clickOnRegisterButton() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathButtonRegistration).isEnabled() &&
                    Teh.waitXpathElement(xpathButtonRegistration).isDisplayed()) {
                Teh.waitXpathElement(xpathButtonRegistration).click();
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Click on Log In button.")
    public static void clickOnLogInButton() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathButtonLogin).isEnabled() &&
                    Teh.waitXpathElement(xpathButtonLogin).isDisplayed()) {
                Teh.waitXpathElement(xpathButtonLogin).click();
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Click on My profile button.")
    public static void goToMyProfile() {
        Teh.waitXpathElement(HomePage.xpathButtonMyProfile).click();
    }

    @Step("Verify that footer have 8 social buttons.")
    public static void verifyThatFooterHaveEightSocialButtons() {
        Assert.assertEquals(8, Teh.driver.findElements(By.xpath(xpathLinksSocialOnFooter)).size());
    }

    @Step("Verify that hamburger menu button is exist.")
    public static void verifyThatHamburgerButtonIsExist() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathButtonHamburger).isEnabled());
    }

    @Step("Click on hamburger menu button.")
    public static void clickOnHamburgerMenuButton() {
        Teh.waitXpathElement(xpathButtonOpenHamburger).click();
    }

    @Step("Verify that hamburger menu is displayed.")
    public static void verifyThatHamburgerMenuIsDisplayed() {
        Assert.assertEquals(true, Teh.waitXpathElement(xpathButtonCloseHamburger).isDisplayed());
    }

    @Step("Click on Close hamburger menu button.")
    public static void clickOnCloseHamburgerMenuButton() {
        Teh.waitXpathElement(xpathButtonCloseHamburger).click();
    }

    @Step("Verify that hamburger menu is closed.")
    public static void verifyThatHamburgerMenuIsNotDisplay() {
        Assert.assertEquals(true, Teh.waitXpathElementNotExist(xpathButtonCloseHamburger));
    }
}
