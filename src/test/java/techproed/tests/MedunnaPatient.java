package techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.MedunnaHomePage;
import techproed.pages.MedunnaLoginPage;
import techproed.pages.MedunnaPatientPage;
import techproed.utilities.*;

public class MedunnaPatient {
    //Admin can create patients
    //https://medunna.com/

    /*
Given
    Go to https://medunna.com/
When
    Click on "user icon"
And
    Click on "Sign In" option
And
    Enter username into "Username" input
And
    Enter password into "Password" input
And
    Click on "Remember me" check box
And
    Click on "Sign in" submit button
And
    Click on "Items&Titles" menu
And
    Click on "Patient" option
And
    Click on "Create a new patient" button
And
    Enter firstname into "First Name" input
And
    Enter lastname into "Last Name" input
And
    Enter email into "Email" input
And
    Enter phone number into "Phone" input
And
    Click on "Save" button
 */

    @DataProvider
    public Object[][] medunnaCredentials(){

        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/MedunnaCredentials.xlsx","medunna01");
        //ExcelUtils(excelfile path, sheet name)

        Object[][] arr = excelUtils.getDataArrayWithoutFirstRow();
//    {
//
//                {"john_doe11", "John.123","Mary","Terry", "a@b.com", "1234567890"},
//                {"john_doe12", "John.123","Mary","Terry", "a@b.com", "1234567890"},
//                {"john_doe13", "John.123","Mary","Terry", "a@b.com", "1234567890"},
//                {"john_doe14", "John.123","Mary","Terry", "a@b.com", "1234567890"},
//                {"john_doe14", "John.123","Mary","Terry", "a@b.com", "1234567890"},
//
//     };
        return arr;

    }


    @Test(dataProvider = "medunnaCredentials")
    public void createPatient(String username, String password, String patientFN, String patientLN, String patientEmail, String patientPhone){

//    Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));



        //*********HOMEPAGE***************

//    Click on "user icon"
        MedunnaHomePage medunnaHomePage=new MedunnaHomePage();

        medunnaHomePage.userIcon.click();

//    Click on "Sign In" option
        medunnaHomePage.signInOption.click();




        //*********LOGINPAGE***************

//    Enter username into "Username" input
        MedunnaLoginPage medunnaLoginPage=new MedunnaLoginPage();

        medunnaLoginPage.usernameInput.sendKeys(username);
        //birçok kez kullanılacaksa config.prop'a konması gerekir, ancak sınırılı sayıda kullanılacaksa dogrudan sendKeys() kullanıabilir.

//    Enter password into "Password" input
        medunnaLoginPage.passwordInput.sendKeys(password);

//    Click on "Remember me" check box
        medunnaLoginPage.rememberMeCheckBox.click();

//    Click on "Sign in" submit button
        medunnaLoginPage.signInSubmitButton.click();


//*********HOMEPAGE***************
//    Click on "Items&Titles" menu
        medunnaHomePage.itemsAndTitlesMenu.click();

//    Click on "Patient" option
        medunnaHomePage.patientOption.click();

//    Click on "Create a new patient" button
        MedunnaPatientPage medunnaPatientPage=new MedunnaPatientPage();

        medunnaPatientPage.createNewPatientButton.click();

//    Enter firstname into "First Name" input
        medunnaPatientPage.patientFirstNameInput.sendKeys(patientFN);

//    Enter lastname into "Last Name" input
        medunnaPatientPage.patientLastNameInput.sendKeys(patientLN);

//    Enter email into "Email" input
        medunnaPatientPage.patientEmailInput.sendKeys(patientEmail);

//    Enter phone number into "Phone" input
        medunnaPatientPage.patientPhoneInput.sendKeys(patientPhone);

//    Click on "Save" button
        JSUtils.clickElementByJS(medunnaPatientPage.saveSubmitButton);


    }

//@AfterMethod
//    public void closeDriver(){
//    ReusableMethods.waitFor(2);
//    closeDriver();
//
//}



}
