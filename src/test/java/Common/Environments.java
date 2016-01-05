package Common;

import PageObjects.AuthorizationPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class Environments {
    public static String BASE_URL = "http://test2.vocalpoint.com";
    public static String ARTICLE = "/articles/selenium-article";
    public static String REVIEW = "/reviews/selenium/submit";
    public static String emailValue = "default";
    public static String validPassword = "Uxgpassword1";

    public static String TEST_VOCALPOINT_BASE_URL = "http://test2.vocalpoint.com";
    public static String UAT_VOCALPOINT_BASE_URL = "http://uat.vocalpoint.com";
    public static String TEST_UNRATOJUNTAS_BASE_URL = "http://test2.unratojuntas.com";
    public static String UAT_UNRATOJUNTAS_BASE_URL = "https://uat.unratojuntas.com";
    public static String TEST_VOCALPOINT_BASE_URL_ARTICLES = "http://test2.vocalpoint.com/articles";

    public static void createMailBox() {
        String mail = Teh.generateStringValue();
        Teh.get("http://www.mailforspam.com/");
        Teh.waitXpathElement("//*[@name='spammail']").sendKeys(mail);
        System.out.println("Email used for confirmation of registration is " + mail +
                "@mailforspam.com, check on " + "http://www.mfsa.info/mail/" + mail);
        Teh.waitXpathElement("//*[@value='Check']").click();
        Teh.waitXpathElement("//*[text()='Your Inbox:']");
        emailValue = mail;
    }

    @Step("Confirmation of registration in mail.")
    public static void confirmRegistrationInMail() {
        Teh.get("http://www.mfsa.info/mail/" + emailValue);
        for (int i = 0; i < 60; i++) {
            if (Teh.driver.findElements(By.xpath("//td[contains(text(),'White Label')]")).size() > 0) {
                break;
            }
            Teh.waitXpathElement("//*[@value='Check']").click();
            Teh.waitMsec(3000);
        }
        Teh.waitXpathElement("//*[contains(text(),'White')]").click();
        Teh.waitXpathElement("//a[contains(@href,'.com/user/confirmaccount')]").click();
        Teh.waitXpathElement("//*[@class='row registration-successful-dialog']");
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
        Teh.get(url);
    }
}