package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteControlTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.127:4444/wd/hub"),DesiredCapabilities.chrome());
        driver.get("https://google.com");
        Thread.sleep(2500);
        driver.quit();

    }
}
