package Tests;

import Common.TestHelper;
import PageObjects.*;
import Common.Environments;
import org.junit.*;
import org.junit.runners.MethodSorters;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("Smoke Test Suite")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestsSmoke {
    @BeforeClass
    public static void setPrecondition() {
        TestHelper.runDriverFullscreen("firefox");
        Environments.createMailBox();
        Environments.passRegistration();
        TestHelper.quit();
    }
    @Before
    public void setUp() {
        TestHelper.runDriverFullscreen("firefox");
    }
    @After
    public void tearDown() {
        TestHelper.quit();
    }

    @Features("Authorization")
    @Stories("User should be able to log in via existed account")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void userShouldBeAbleToLogIn() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.fillInputLogin(Environments.emailValue + "@mailforspam.com");
        AuthorizationPage.fillInputPassword(Environments.validPassword);
        AuthorizationPage.submitAuthorization();
        AuthorizationPage.verifyWelcomeMessage();
    }

    @Features("Comments")
    @Stories("User should be able to leave comments in articles")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void a_shouldBeAbleToAddCommentInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.fillTextAreaByComment();
        ArticlePage.clickOnPostMyCommentButton();
        ArticlePage.verifyThatCommentIsAdded();
    }

    @Features("Comments")
    @Stories("User should be able to see comments section in account profile")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void b_shouldSeeLeftCommentsInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.goToCommentsSection();
        ProfilePage.verifyThatCommentInSectionIsDisplayed();
    }

    @Features("Comments")
    @Stories("User should be able to delete comments in account profile")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void c_shouldBeAbleDeleteCommentInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.goToCommentsSection();
        ProfilePage.deleteComment();
        ProfilePage.confirmDeleteComment();
        ProfilePage.verifyThatCommentIsDeleted();
    }

    @Features("Loves")
    @Stories("User should be able to add loves in articles")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void a_shouldBeAbleToAddLoveInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.loveArticle();
        ArticlePage.verifyThatLovesCounterIsIncreased();
    }

    @Features("Loves")
    @Stories("User should be able to unlove in article")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void b_shouldBeAbleToDeleteLoveInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.unLoveArticle();
        ArticlePage.verifyThatLovesCounterIsDecreased();
    }

    @Features("Loves")
    @Stories("User should be able to overview loves section in account profile")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void c_shouldSeeLovesInProfile() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.loveArticle();
        HomePage.goToMyProfile();
        ProfilePage.goToLovesSection();
        ProfilePage.verifyLoveInLovesSection();
    }

    @Features("Loves")
    @Stories("User should be able to delete love in loves section of account profile")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void d_shouldBeAbleToDeleteLoveInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.goToLovesSection();
        ProfilePage.deleteLoveInProfile();
        ProfilePage.confirmDeleteLove();
        ProfilePage.verifyLoveDeleted();
    }

    @Features("Authorization")
    @Stories("Unauthorized user should be redirected to the authorization when add love in article")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void unauthorizedUserShouldBeRedirectedToAuthorizationWhenAddLove() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        ArticlePage.loveArticleUnauthorized();
        ArticlePage.verifyRedirectionToLogInAfterTryToAddLove();
    }

    @Features("Authorization")
    @Stories("Unauthorized user shouldn't be able to write comments in article")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void unauthorizedUserShouldNotBeAbleWriteCommentsInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        ArticlePage.verifyInabilityToLeaveCommentsByUnauthorizedUser();
    }

    @Features("Authorization")
    @Stories("Unauthorized user should see Sign In and Register buttons instead of comments textarea")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void unauthorizedUserShouldSeeLogInAndRegisterButtonInsteadCommentBlock() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        ArticlePage.verifyAvailabilityOfSignInAndRegisterButtonsInsteadCommentsBlock();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with empty First Name input")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessagesInRegistrationFormWhenLeftFirstNameEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyFirstNameErrorMessage();

    }
    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with empty Last Name input")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftLastNameEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyLastNameErrorMessage();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with empty Email input")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftEmailEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyEmailErrorMessage();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with empty Password input")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftPasswordEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyPasswordErrorMessage();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with empty Verify Password input")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenLeftVerifiedPasswordEmpty() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.verifyPasswordConfirmationErrorMessage();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with not defined date of birth")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenDateOfBirthNotDefined() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotDefinedDateOfBirth();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with not defined gender")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenGenderNotDefined() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotDefinedDateOfBirth();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to pass registration with disabled T&C checkbox")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenTCCheckboxNotAgreed() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotDefinedGender();
    }

    @Features("Authorization")
    @Stories("User should see error message in registration form when tries to fill in Verify Password input with wrong value")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageInRegistrationFormWhenConfirmationPasswordIsFailed() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnRegisterButton();
        RegistrationPage.submitRegistration();
        RegistrationPage.verifyErrorMessageForNotCheckedTCCheckbox();
    }

    @Features("Authorization")
    @Stories("User should stay logged in article page if he pass authorization from article page")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("WL-1918")
    @Test
    public void shouldStayAtArticleAfterLogInArticle() {
        Environments.goTo(Environments.BASE_URL + Environments.ARTICLE);
        Environments.logIn();
        ArticlePage.verifyThatCurrentPageIsArticle();
    }

    @Features("Profile")
    @Stories("User should be able to change biography text in profile")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldBeAbleToEditBio() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.fillInBioTextArea();
        ProfilePage.submitBioChanges();
        ProfilePage.verifyThatChangesInProfileIsAppeared();
    }

    @Features("Profile")
    @Stories("User should see welcome message in user profile")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeWelcomeMessageInProfile() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatWelcomeMessageInProfileIsAppeared();
    }

    @Features("Authorization")
    @Stories("User should see Sign In with Facebook button in authorization form.")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldSeeSignViaFacebookButton() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.verifyAvailabilityOfFacebookButton();
    }

    @Features("Authorization")
    @Stories("User should see Forgot your password? link in authorization form")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldSeeForgotYourPasswordLink() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnLogInButton();
        AuthorizationPage.verifyAvailabilityOfForgorPasswordLink();
    }

    @Features("Authorization")
    @Stories("User should see eight social buttons on the footer")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeEightSocialButtonsOnFooter() {
        Environments.goTo(Environments.BASE_URL);
        TestHelper.scrollPage(1500);
        HomePage.verifyThatFooterHaveEightSocialButtons();
    }

    @Features("Authorization")
    @Stories("User should see hamburger button is exist and enabled")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldSeeHamburgerButton() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.verifyThatHamburgerButtonIsExist();
    }

    @Features("Profile")
    @Stories("User should see enabled Connect with Facebook button")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldConnectFacebookButton() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatConnectFacebookEnabled();
    }

    @Features("Profile")
    @Stories("User should see enabled Connect with Twitter button")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldConnectTwitterButton() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatConnectTwitterEnabled();
    }

    @Features("Profile")
    @Stories("User should see enabled Connect Your Blog button")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldConnectBlogButton() {
        Environments.goTo(Environments.BASE_URL);
        Environments.logIn();
        HomePage.goToMyProfile();
        ProfilePage.verifyThatConnectBlogEnabled();
    }

    @Features("Reviews")
    @Stories("User should be able to left review")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldBeAbleToLeftReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        Environments.logIn();
        ReviewPage.setRate();
        ReviewPage.clickOnNextButton();
        ReviewPage.fillInTextarea();
        ReviewPage.clickOnSubmitMyReviewButton();
        ReviewPage.verifyThatReviewIsAdded();
    }

    @Features("Reviews")
    @Stories("User should see error message when tries to continue reviewing without setting of rate")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void shouldSeeErrorMessageWhenNoStarsSetInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.clickOnNextButton();
        ReviewPage.verifyThatNoRateErrorMessageIsDisplayed();
    }

    @Features("Reviews")
    @Stories("User should see error message when tries to continue reviewing without filling of textarea")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void shouldSeeErrorMessageWhenNoTextInTextarea() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        ReviewPage.setRate();
        ReviewPage.clickOnNextButton();
        ReviewPage.clickOnSubmitMyReviewButton();
        ReviewPage.verifyThatNoTextErrorMessageIsDisplayed();
    }

    @Features("Hamburger")
    @Stories("User should be able to open hamburger menu")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldBeAbleToOpenHamburgerMenu() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnHamburgerMenuButton();
        HomePage.verifyThatHamburgerMenuIsDisplayed();
    }

    @Features("Hamburger")
    @Stories("User should be able to close hamburger menu")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void shouldBeAbleToCloseHamburgerMenu() {
        Environments.goTo(Environments.BASE_URL);
        HomePage.clickOnHamburgerMenuButton();
        HomePage.clickOnCloseHamburgerMenuButton();
        HomePage.verifyThatHamburgerMenuIsNotDisplay();
    }

    @Features("Loves")
    @Stories("User should be able to add loves in review")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void a_shouldBeAbleToAddLoveInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        Environments.logIn();
        ReviewPage.loveReview();
        ReviewPage.verifyThatLovesCounterIsIncreased();
    }

    @Features("Loves")
    @Stories("User should be able to unlove in review")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void b_shouldBeAbleToDeleteLoveInReview() {
        Environments.goTo(Environments.BASE_URL + Environments.REVIEW);
        Environments.logIn();
        ReviewPage.unLoveReview();
        ReviewPage.verifyThatLovesCounterIsDecreased();
    }
}
