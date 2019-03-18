package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CommonFunctions {
    private static WebDriver driver;
    private static String cellLocator = "//table[@id='table1']//tbody/tr[%d]/td[%d]";

    // getElement using How package
    public static WebElement getElement (How how, String locator)
    {
        return driver.findElement(how.buildBy(locator));
    }
    // get a list of elements
    public static List<WebElement> getElements (How how, String locator) {
        return driver.findElements(how.buildBy(locator));
    }
    // get a table Cell
    public static WebElement getCell (int row, int column)
    {
        return getElement(How.XPATH, String.format(cellLocator, row, column));
    }
    // fill using How package
    public static void fill (How how, String locator, String inputText)
    {
        getElement(how, locator).sendKeys(inputText);
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

    // select an option in dropdownlist by value
    public static void selectOption(How how, String locator, String value)
    {
        WebElement element = getElement(how, locator);
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);

    }


    // back to previous page
    public static void back ()
    {
        driver.navigate().back();
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
        } else if(name.equalsIgnoreCase("headless")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Vinh\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            System.err.println("Browser " + name + "not found");
        }
    }



    public static void quit ()
    {
        driver.quit();
    }

}
