package PageObjects;

import Common.Environments;
import Common.Teh;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class RegistrationPage {
    public static String xpathInputFirstName = "//*[@id='wrapper-first-name']//input";
    public static String xpathInputLastName = "//*[@id='wrapper-last-name']//input";
    public static String xpathInputEmail = "//*[@id='wrapper-mail']//input";
    public static String xpathInputPassword = "//*[@id='wrapper-pass1']//input";
    public static String xpathInputConfirmedPassword = "//*[@id='wrapper-pass2']//input";
    public static String xpathButtonDropdownMonth = "//span[text()='Month']/parent::a|//span[text()='Mes']/parent::a";
    public static String xpathJanuaryMonth = "//span[text()='Month']/../..//li[text()='Jan']|//span[text()='Mes']/../.." +
            "//li[text()='Jan']";
    public static String xpathButtonDropdownDay = "//span[text()='Day']/parent::a|//span[text()='Día']/parent::a";
    public static String xpath1Day = "//span[text()='Day']/../..//li[text()='1']|//span[text()='Día']/../.." +
            "//li[text()='1']";
    public static String xpathButtonDropdownYear = "//span[text()='Year']/parent::a|//span[text()='Año']/parent::a";
    public static String xpath1993Year = "//span[text()='Year']/../..//li[text()='1993']|//span[text()='Año']/../.." +
            "//li[text()='1993']";
    public static String xpathRadiobuttonGender = "//input[@type='radio']";
    public static String xpathTCCheckbox = "//*[@id='edit-accept-agreement']";
    public static String xpathButtonSubmitRegistration = "//*[@id='edit-submit']";
    public static String xpathAfterRegistrationSentEmailPopUp = "//*[@class='mfp-content']";

    public static String xpathFirstNameErrorMessage = "//*[contains(text(),'Please enter First Name.')]" +
            "|//*[contains(text(),'Sorry chica, necesitamos un nombre y apellido válidos.')]";
    public static String xpathLastNameErrorMessage = "//*[contains(text(),'Please enter Last Name.')]" +
            "|//*[contains(text(),'Sorry chica, necesitamos un nombre y apellido válidos.')]";
    public static String xpathEmailErrorMessage = "//*[contains(text(),'Please enter a valid email address.')]" +
            "|//*[contains(text(),'Sorry chica, necesitamos un correo electrónico válido.')]";
    public static String xpathPasswordErrorMessage = "//*[@id='wrapper-pass1']//*[contains(text(),'Please enter a valid password containing at least')]" +
            "|//*[@id='wrapper-pass1']//*[contains(text(),'Tu contraseña debe tener')]";
    public static String xpathVerifyPasswordErrorMessage = "//*[@id='wrapper-pass2']//*[contains(text(),'Please enter a valid password containing at least')]" +
            "|//*[@id='wrapper-pass2']//*[contains(text(),'Tu contraseña debe tener')]";
    public static String xpathDateOfBirthErrorMessage = "//*[contains(text(),'Please enter your date of birth.')]" +
            "|//*[contains(text(),'Necesitamos tu fecha de nacimiento (Es solo para asegurarnos que tienes más de 18 años).')]";
    public static String xpathGenderErrorMessage = "//*[contains(text(),'Please select Gender.')]" +
            "|//*[contains(text(),'Por favor seleccione el género.')]";
    public static String xpathTCErrorMessage = "//*[contains(text(),'Please read and agree with the Terms and Conditions.')]" +
            "|//*[contains(text(),'Debes aceptar los términos y condiciones para poder registrarte.')]";

    public static String engRegister = "//*[contains(text(),'Register')]";
    public static String spaRegistrate = "//*[contains(text(),'Regístrate')]";


    @Step("Fill First Name input with valid value.")
    public static void fillFirstNameInput() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathInputFirstName).isEnabled()) {
                Teh.waitXpathElement(xpathInputFirstName).sendKeys(Environments.emailValue);
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Fill Last Name input with valid value.")
    public static void fillLastNameInput() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathInputLastName).isEnabled()) {
                Teh.waitXpathElement(xpathInputLastName).sendKeys("Smith");
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Fill Email input with valid value.")
    public static void fillEmailInput() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathInputEmail).isEnabled()) {
                Teh.waitXpathElement(xpathInputEmail).sendKeys(Environments.emailValue + "@mailforspam.com");
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Fill Password input with valid value.")
    public static void fillPasswordInput() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathInputPassword).isEnabled()) {
                Teh.waitXpathElement(xpathInputPassword).sendKeys(Environments.validPassword);
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Fill Verify Password input with valid value.")
    public static void fillConfirmedPasswordInput() {
        for (int i = 0; i < 450; i++) {
            if (Teh.waitXpathElement(xpathInputConfirmedPassword).isEnabled()) {
                Teh.waitXpathElement(xpathInputConfirmedPassword).sendKeys(Environments.validPassword);
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Set month of birth.")
    public static void setBirthMonth() {
        Teh.scrollPage(400);
        Teh.waitXpathElement(xpathButtonDropdownMonth).click();
        Teh.waitXpathElement(xpathJanuaryMonth).click();
        for (int i = 0; i < 450; i++) {
            if (Teh.driver.findElements(By.xpath("//span[contains(text(),'Jan')]")).size() > 0) {
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Set day of birth.")
    public static void setBirthDay() {
        Teh.waitXpathElement(xpathButtonDropdownDay).click();
        Teh.waitXpathElement(xpath1Day).click();
        for (int i = 0; i < 450; i++) {
            if (Teh.driver.findElements(By.xpath("//span[contains(text(),'1')]")).size() > 0) {
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Set year of birth.")
    public static void setBirthYear() {
        Teh.waitXpathElement(xpathButtonDropdownYear).click();
        Teh.waitXpathElement(xpath1993Year).click();
        for (int i = 0; i < 450; i++) {
            if (Teh.driver.findElements(By.xpath("//span[contains(text(),'1993')]")).size() > 0) {
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Set gender.")
    public static void setGender() {
        Teh.waitXpathElement(xpathRadiobuttonGender).click();
        for (int i = 0; i < 450; i++) {
            if (Teh.driver.findElements(By.xpath("//*[contains(@class,'checked') and contains(@class,'radio-wrap')]")).size() > 0) {
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Click on Terms & Conditions checkbox.")
    public static void agreeWithTCCheckbox() {
        Teh.waitXpathElement(xpathTCCheckbox).click();
        for (int i = 0; i < 450; i++) {
            if (Teh.driver.findElements(By.xpath("//*[contains(@class,'checked') and contains(@class,'checkbox-wrap')]")).size() > 0) {
                break;
            }
            Teh.waitMsec(100);
        }
    }

    @Step("Submit registration by click on Register button.")
    public static void submitRegistration() {
        Teh.waitXpathElement(xpathButtonSubmitRegistration).click();
    }

    @Step("Verify that creation of new account is complete.")
    public static void verifyThatAccountIsCreated() {
        Teh.waitXpathElement(xpathAfterRegistrationSentEmailPopUp);
    }

    @Step("Verify First Name empty input error message.")
    public static void verifyFirstNameErrorMessage() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter First Name.",
                    Teh.waitXpathElement(xpathFirstNameErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Sorry chica, necesitamos un nombre y apellido válidos.",
                    Teh.waitXpathElement(xpathFirstNameErrorMessage).getText());
        }
    }

    @Step("Verify Last Name empty input error message.")
    public static void verifyLastNameErrorMessage() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter Last Name.",
                    Teh.waitXpathElement(xpathLastNameErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Sorry chica, necesitamos un nombre y apellido válidos.",
                    Teh.waitXpathElement(xpathLastNameErrorMessage).getText());
        }
    }

    @Step("Verify Email empty input error message.")
    public static void verifyEmailErrorMessage() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter a valid email address.",
                    Teh.waitXpathElement(xpathEmailErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Sorry chica, necesitamos un correo electrónico válido.",
                    Teh.waitXpathElement(xpathEmailErrorMessage).getText());
        }
    }

    @Step("Verify Password empty input error message.")
    public static void verifyPasswordErrorMessage() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter a valid password containing at least 8 characters with 1 uppercase letter and 1 number.",
                    Teh.waitXpathElement(xpathPasswordErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Tu contraseña debe tener 8 caracteres, una mayúscula y un número.",
                    Teh.waitXpathElement(xpathPasswordErrorMessage).getText());
        }
    }

    @Step("Verify Password Confirmation empty input error message.")
    public static void verifyPasswordConfirmationErrorMessage() {
        Teh.waitXpathElement(xpathInputConfirmedPassword).click();
        Teh.driver.findElement(By.xpath(xpathRadiobuttonGender)).click();
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter a valid password containing at least 8 characters with 1 uppercase letter and 1 number.",
                    Teh.waitXpathElement(xpathVerifyPasswordErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Tu contraseña debe tener 8 caracteres, una mayúscula y un número.",
                    Teh.waitXpathElement(xpathVerifyPasswordErrorMessage).getText());
        }
    }

    @Step("Verify error message when Date Of Birth is not defined.")
    public static void verifyErrorMessageForNotDefinedDateOfBirth() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please enter your date of birth.", Teh.waitXpathElement(xpathDateOfBirthErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Necesitamos tu fecha de nacimiento (Es solo para asegurarnos que tienes más de 18 años).",
                    Teh.waitXpathElement(xpathDateOfBirthErrorMessage).getText());
        }
    }

    @Step("Verify error message when Gender is not defined.")
    public static void verifyErrorMessageForNotDefinedGender() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please select Gender.",
                    Teh.waitXpathElement(xpathGenderErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Por favor seleccione el género.",
                    Teh.waitXpathElement(xpathGenderErrorMessage).getText());
        }
    }

    @Step("Verify error message when Terms and Conditions checkbox is not enabled.")
    public static void verifyErrorMessageForNotCheckedTCCheckbox() {
        if (Teh.waitXpathElement(engRegister).isDisplayed()) {
            Assert.assertEquals("Please read and agree with the Terms and Conditions.",
                    Teh.waitXpathElement(xpathTCErrorMessage).getText());
        } else if (Teh.waitXpathElement(spaRegistrate).isDisplayed()) {
            Assert.assertEquals("Debes aceptar los términos y condiciones para poder registrarte.",
                    Teh.waitXpathElement(xpathTCErrorMessage).getText());
        }
    }

    @Step("Verify that registration is passed correctly.")
    public static void verifyCompletionOfRegistration() {
        Teh.waitXpathElement("//*[@class='row registration-successful-dialog']");
    }
}
