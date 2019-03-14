package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;

import java.util.Scanner;

public class SelectBrowserTest {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Create Scanner
        //Scanner myScanner = new Scanner(System.in);
        //System.out.println("Please enter browser name: ");
        // Read input from Scanner
        //String input = myScanner.next();
        // Call runBrowser class with input String

        /*
        openBrowser("coccoc");
        visit("https://the-internet.herokuapp.com/login");
        fill("name", "username", "tomsmith");
        fill("name", "password", "SuperSecretPassword!");
        click("tagname", "button");
        */

        nevismetaLogin();
        Thread.sleep(1000);

        nevismetaAddNewSetup();
        Thread.sleep(10000);

        driver.quit();

    }

    public static void nevismetaLogin ()
    {
        openBrowser("firefox");
        visit("https://nevismeta-test4.adnovum.vn/nevismeta/");
        fill("xpath", "//input[contains(@id,'userid')]", "admin");
        fill("css", "input[id*='passwd']", "Nevismeta1!");
        click("tagname", "button");
    }

    public static void nevismetaAddNewSetup () throws InterruptedException {

        click("xpath", "//a[contains(@id,'addNewSetup')]");
        Thread.sleep(1000);

        fill("xpath", "//input[contains(@id,'newSetupName')]", "vinh_selenium_test_setup");
        click("xpath", "//*[.='Default Scope Policies:']/following-sibling::*//span[.='Implicit Flow']/following-sibling::a[4]");
        click("xpath", "//*[.='Default Scope Policies:']/following-sibling::*//span[.='Authorization Code Flow']/following-sibling::a[3]");
        click("xpath", "//*[.='Default Scope Policies:']/following-sibling::*//span[.='Refresh Token Request']/following-sibling::a[2]");
        click("xpath", "//*[.='Default Scope Policies:']/following-sibling::*//span[.='Force Reauthentication']/following-sibling::a[1]");

        click("xpath", "//*[.='Grant Types allowed per default:']/following-sibling::*//span[.='Implicit Grant']/following-sibling::a[1]");
        click("xpath", "//*[.='Grant Types allowed per default:']/following-sibling::*//span[.='Authorization Code Grant']/following-sibling::a[1]");
        click("xpath", "//*[.='Grant Types allowed per default:']/following-sibling::*//span[.='Client Credential Grant']/following-sibling::a[1]");
        click("xpath", "//*[.='Grant Types allowed per default:']/following-sibling::*//span[.='Refresh Token Grant']/following-sibling::a[1]");

        fill("xpath", "//*[@id=\"addNewSetupModalForm:j_idt1639:ttlInput\"]", "1");
        fill("xpath", "//*[@id=\"addNewSetupModalForm:j_idt1640:ttlInput\"]", "2");
        fill("xpath", "//*[@id=\"addNewSetupModalForm:j_idt1641:ttlInput\"]", "3");
        fill("xpath", "//*[@id=\"addNewSetupModalForm:j_idt1642:ttlInput\"]", "4");

        click("xpath", "//*[@id=\"addNewSetupModalForm:createNewSetup\"]");
    }

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
        driver.get(url);
    }
    // check string and select driver
    public static void openBrowser(String name) {

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




}
