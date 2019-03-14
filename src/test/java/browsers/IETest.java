package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {
    public void runBrowser () {
        //System.setProperty("webdriver.edge.driver", "Drivers/IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.google.com");
    }
}
