package Common;

import PageObjects.AuthorizationPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class Environments {
    public static String BASE_URL = "http://test2.vocalpoint.com";
    public static String ARTICLE = "/articles/selenium-article";
    public static String REVIEW = "/reviews/8318/story";
    public static String emailValue = "default";
    public static String validPassword = "Uxgpassword1";

    public static String TEST_VOCALPOINT_BASE_URL = "http://test2.vocalpoint.com";
    public static String UAT_VOCALPOINT_BASE_URL = "http://uat.vocalpoint.com";
    public static String TEST_UNRATOJUNTAS_BASE_URL = "http://test2.unratojuntas.com";
    public static String UAT_UNRATOJUNTAS_BASE_URL = "https://uat.unratojuntas.com";
    public static String TEST_VOCALPOINT_BASE_URL_ARTICLES = "http://test2.vocalpoint.com/articles";

    public static void createMailBox() {
        String mail = TestHelper.generateStringValue();
        TestHelper.get("http://www.mailforspam.com/");
        TestHelper.waitXpathElement("//*[@name='spammail']").sendKeys(mail);
        System.out.println("Email used for confirmation of registration is " + mail +
                "@mailforspam.com, check on " + "http://www.mfsa.info/mail/" + mail);
        TestHelper.waitXpathElement("//*[@value='Check']").click();
        TestHelper.waitXpathElement("//*[text()='Your Inbox:']");
        emailValue = mail;
    }
    @Step("Confirmation of registration in mail.")
    public static void confirmRegistrationInMail() {
        TestHelper.get("http://www.mfsa.info/mail/" + emailValue);
        for (int i = 0; i < 60; i++) {
            if (TestHelper.driver.findElements(By.xpath("//td[contains(text(),'White Label')]")).size() > 0) {
                break;
            }
            TestHelper.waitXpathElement("//*[@value='Check']").click();
            TestHelper.waitMsec(3000);
        }
        TestHelper.waitXpathElement("//*[contains(text(),'White')]").click();
        TestHelper.waitXpathElement("//a[contains(@href,'.com/user/confirmaccount')]").click();
        TestHelper.waitXpathElement("//*[@class='row registration-successful-dialog']");
    }
    public static void passRegistration() {
        goTo(BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.fillFirstNameInput();
        RegistrationPage.fillLastNameInput();
        RegistrationPage.fillEmailInput();
        RegistrationPage.fillPasswordInput();
        RegistrationPage.fillConfirmedPasswordInput();
        RegistrationPage.setBirthMonth();
        RegistrationPage.setBirthDay();
        RegistrationPage.setBirthYear();
        RegistrationPage.setGender();
        RegistrationPage.agreeWithTCCheckbox();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyThatAccountIsCreated();
        Environments.confirmRegistrationInMail();
        RegistrationPage.verifyCompletionOfRegistration();
    }
    @Step("Pass authorization with valid credentials.")
    public static void logIn() {
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin(Environments.emailValue + "@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        AuthorizationPage.submitAuthorization();
    }

    @Step("Go to the testable environment.")
    public static void goTo(String url) {
        TestHelper.get(url);
    }
}