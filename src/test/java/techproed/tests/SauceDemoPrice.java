package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.SauceDemoHomePage;
import techproed.pages.SauceDemoProductsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import static org.testng.AssertJUnit.assertEquals;

public class SauceDemoPrice {
    /*
Given
  Go to  https://www.saucedemo.com/
When
  Enter the username  as "standard_user"
And
  Enter the password as "secret_sauce"
And
  Click on login button
Then
  Assert that total price of all products is 129.94 dollars
And
  Flash each web element you used
 */
    @Test
    public void totalPrice(){
//        Go to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauce_demo_url"));

        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();

//        Enter the username  as "standard_user"
        sauceDemoHomePage.usernameInput.sendKeys(ConfigReader.getProperty("sauce_demo_username"));
        JSUtils.flash(sauceDemoHomePage.usernameInput);

//        Enter the password as "secret_sauce"
        sauceDemoHomePage.passwordInput.sendKeys(ConfigReader.getProperty("sauce_demo_password"));
        JSUtils.flash(sauceDemoHomePage.passwordInput);

//        Click on login button
        sauceDemoHomePage.loginButton.click();
        JSUtils.flash(sauceDemoHomePage.loginButton);

//        Assert that total price of all products is 129.94 dollars
        double sum=0;
        SauceDemoProductsPage sauceDemoProductsPage=new SauceDemoProductsPage();

        for(WebElement w : sauceDemoProductsPage.pricesList){

            JSUtils.flash(w);

            sum += Double.valueOf(w.getText().replaceAll("\\$",""));

        }

        assertEquals(129.94, sum);

//        Flash each web element you used


    }
}