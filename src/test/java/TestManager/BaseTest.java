package TestManager;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class BaseTest {

    protected WebDriver driver ;

    @Parameters("browser")
    @BeforeTest
    public void setUp (@Optional("chrome") String browser) {
        driver = DriverCross.getDriver(browser);
    }

    /*@AfterTest
    public void tearDown () {
        DriverCross.closeDriver();
    }*/



}
