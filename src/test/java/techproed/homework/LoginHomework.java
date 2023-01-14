package techproed.homework;

import org.testng.annotations.Test;

import techproed.pages.TestHomePage;
import techproed.pages.TestLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class LoginHomework {
    //    https://testcenter.techproeducation.com/index.php?page=form-authentication
//    Login the application by using page object model
    /*
    Given
        Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
    When
        Type "techproed" into username input
    And
        Type "SuperSecretPassword" into password input
    And
        Click submit button
    Then
        Verify user singed in
     */
    @Test
    public void loginTest(){
//        Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("test_login_url"));

//        Type "techproed" into "username" input
        TestLoginPage testLoginPage = new TestLoginPage();
        testLoginPage.usernameInput.sendKeys("techproed");

//        Type "SuperSecretPassword" into password input
        testLoginPage.passwordInput.sendKeys("SuperSecretPassword");

//        Click submit button
        testLoginPage.submitButton.click();


//        Verify user singed in
        TestHomePage testHomePage = new TestHomePage();
        assertTrue(testHomePage.loginSuccessMessage.isDisplayed());

    }
}