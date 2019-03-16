package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;

public class MyWebDriver {
    private static WebDriver driver;

    // get string how, locator string, return WebElement
    public static WebElement getElement(String how, String locator){

        WebElement element = null;

        if (how.equalsIgnoreCase("name")){
            element = driver.findElement(By.name(locator));
        } else if (how.equalsIgnoreCase("id")){
            element = driver.findElement(By.id(locator));
        } else if (how.equalsIgnoreCase("tagname")){
            element = driver.findElement(By.tagName(locator));
        } else if (how.equalsIgnoreCase("css")){
            element = driver.findElement(By.cssSelector(locator));
        } else if (how.equalsIgnoreCase("xpath")){
            element = driver.findElement(By.xpath(locator));
        } else {
            System.err.println("locator how " + how + "not found");
        }

        return element;
    }
    // getElement using How package
    public static WebElement getElement (How how, String locator)
    {
        return driver.findElement(how.buildBy(locator));
    }
    // get WebElement, and input text
    public static void fill (String how, String locator, String inputText)
    {
        getElement(how, locator).sendKeys(inputText);
    }
    // fill using How package
    public static void fill (How how, String locator, String inputText)
    {
        getElement(how, locator).sendKeys(inputText);
    }
    // get WebElement, and click
    public static void click (String how, String locator)
    {
        getElement(how, locator).click();
    }
    // click using How package
    public static void click (How how, String locator)
    {
        getElement(how, locator).click();
    }
    // check url string and open website
    public static void visit (String url)
    {
        driver.navigate().to(url);
    }
    // check string and select driver
    public static void setBrowser(String name) {

        if(name.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (name.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (name.equalsIgnoreCase("coccoc")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Vinh\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        } else {
            System.err.println("Browser " + name + "not found");
        }
    }

    public static void back ()
    {
        driver.navigate().back();
    }

    public static void quit ()
    {
        driver.quit();
    }

}
