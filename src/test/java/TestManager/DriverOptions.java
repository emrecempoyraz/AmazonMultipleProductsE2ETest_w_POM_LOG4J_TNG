package TestManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverOptions {

    protected WebDriver driver ;

    public ChromeOptions chromeOptions () {
        ChromeOptions options = new ChromeOptions() ;
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("disable-popup-blocking");
        return options ;
    }
}
