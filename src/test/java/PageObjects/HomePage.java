package PageObjects;

import Common.TestHelper;
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
        TestHelper.waitXpathElement(HomePage.xpathButtonRegistration).click();
    }

    @Step("Click on Log In button.")
    public static void clickOnLogInButton() {
        TestHelper.waitXpathElement(HomePage.xpathButtonLogin).click();
    }

    @Step("Click on My profile button.")
    public static void goToMyProfile() {
        TestHelper.waitXpathElement(HomePage.xpathButtonMyProfile).click();
    }

    @Step("Verify that footer have 8 social buttons.")
    public static void verifyThatFooterHaveEightSocialButtons() {
        Assert.assertEquals(8,TestHelper.driver.findElements(By.xpath(xpathLinksSocialOnFooter)).size());
    }

    @Step("Verify that hamburger menu button is exist.")
    public static void verifyThatHamburgerButtonIsExist() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonHamburger).isEnabled());
    }

    @Step("Click on hamburger menu button.")
    public static void clickOnHamburgerMenuButton() {
        TestHelper.waitXpathElement(xpathButtonOpenHamburger).click();
    }
    @Step("Verify that hamburger menu is displayed.")
    public static void verifyThatHamburgerMenuIsDisplayed() {
        Assert.assertEquals(true,TestHelper.waitXpathElement(xpathButtonCloseHamburger).isDisplayed());
    }

    @Step("Click on Close hamburger menu button.")
    public static void clickOnCloseHamburgerMenuButton() {
        TestHelper.waitXpathElement(xpathButtonCloseHamburger).click();
    }
    @Step("Verify that hamburger menu is closed.")
    public static void verifyThatHamburgerMenuIsNotDisplay() {
        Assert.assertEquals(true, TestHelper.waitXpathElementNotExist(xpathButtonCloseHamburger));
    }
}
