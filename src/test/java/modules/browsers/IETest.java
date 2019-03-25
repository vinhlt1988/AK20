package modules.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {
    public void runBrowser () {
        //System.setProperty("webdriver.edge.driver", "Drivers/IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.google.com");
    }
}
