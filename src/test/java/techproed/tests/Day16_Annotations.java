package techproed.tests;
import jdk.jfr.Enabled;
import org.testng.annotations.*;

public class Day16_Annotations {
    /*
    suite > test > group > class > method
    @Test : creates test case
    @Before and @After : 10 before and after annotations.
                         They are used to control FLOW and DESIGN of the tests
     --there can be only one suite in the package
     @Ignore: to skip test case(s).if we put @ignore annotation before a test method,
              that test case is skipped
     @Test(enable=false) : Disable the test case. by default, enable=true.
     --In the same class, testNG runs in alphabetical order.
     --we can change the order. "priority"
     --test that has no priority parameter has a priority of 0. test(priority=0)
     --We should use priority when there are multiple test cases in the same class.
     --Negative numbers comes first(-3, 0, 4,9) if there is no priority defined.
     --We can not give the same priority to different test cases.
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("test4");
    }
    @Test(priority = 1)
    public void test5(){
        System.out.println("test5");
    }
    @Test
    public void test6(){
        System.out.println("test6");
    }
}