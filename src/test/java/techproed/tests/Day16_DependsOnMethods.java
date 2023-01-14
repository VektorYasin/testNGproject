package techproed.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_DependsOnMethods {

    /*
    depends on method is not common.
     */

    @Test
    public void homePage(){
        System.out.println("I am on the home page");
    }

    @Test
    public void searchPage(){
        System.out.println("I am on the search page");
        Assert.fail();
    }
    /*
    dependsOnMethods = "searchPage"  -> connecting checkOutPage to searchPage
    searchPage will execute right before checkOutPage
    If searchPage PASS -> execute checkoutPage
    If searchPage FAIL -> SKIP checkoutPage
     */

    @Test(dependsOnMethods = "searchPage")
    public void checkOutPage(){
        System.out.println("I am on the checkout page");
    }
}
    /*
    hard assertion: when one line fails, test stops.
    softAssert--verification: when one line fails, it continues to execute.
    en sona assertAll() yapmayı unutmamamız lazım, yoksa testlerin hepsi geçti gözükür.
    Hatayı işaretlemez.
    */