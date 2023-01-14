package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
    POM:
    1. Locate the page object in the pages package
    - username
    - password
    - button
    Note: Use constructor to instantiate page objects
     */

    public OpenSourcePage(){   //constructor
        //Used to instantiate page object
        PageFactory.initElements(Driver.getDriver(),this);
        //this: this page elements
    }

    //WebElement username=driver.findElement(By.name("username")); traditional
    @FindBy(name = "username") //hangi tür locater (name) ile tespit ettiysek onu yazarız
    public WebElement userName;

    @FindBy(name = "password") //name locator
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']") //xpath locator
    public WebElement logInSubmit;

    /*
    Page Factory is a class provided by Selenium WebDriver
    to support Page Object Design patterns.

    In Page Factory, testers use @FindBy annotation.
    The initElements() method is used to initialize web elements.

    @FindBy: An annotation used in Page Factory to locate and
    declare web elements using different locators
    */
}