package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final long TIMEOUT_IN_SECONDS = 60;

    public static WebDriver getDriver() {
        return driver;
    }

    public enum tableType {
        HEADER1, HEADER2, TABLE1, TABLE2
    }

    public static String getCellLocator (tableType type) {
        String cellLocator = "";
        switch (type){
            case HEADER1:
                cellLocator = "//table[@id='table1']//thead/tr[%d]/th[%d]";
                break;
            case HEADER2:
                cellLocator = "//table[@id='table2']//thead/tr[%d]/th[%d]";
                break;
            case TABLE1:
                cellLocator = "//table[@id='table1']//tbody/tr[%d]/td[%d]";
                break;
            case TABLE2:
                cellLocator = "//table[@id='table2']//tbody/tr[%d]/td[%d]";
                break;
        }
        return cellLocator;
    }

    // getElement using How package
    public static WebElement getElement (How how, String locator)
    {
        return driver.findElement(how.buildBy(locator));
    }

    public static String getText (How how, String locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how, locator).getText();
    }
    // get a list of elements
    public static List<WebElement> getElements (How how, String locator) {
        return driver.findElements(how.buildBy(locator));
    }
    // get a table Cell
    public static WebElement getCell (tableType type, int row, int column)
    {
        String cellLocator = getCellLocator(type);
        return getElement(How.XPATH, String.format(cellLocator, row, column));
    }
    // find a table's header column index by text
    public static int findHeaderColumnIndex (String searchText, int columnSize){
        int columnIndex = 0;
        String cellValue = "";
        for (int column = 1; column <= columnSize; column++){
            cellValue = getCell(tableType.HEADER1, 1, column).getText();
            if (searchText.equalsIgnoreCase(cellValue)) {
                columnIndex = column;
            }
        }
        return columnIndex;
    }

    // fill using How package
    public static void fill (How how, String locator, String inputText)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(inputText);
    }

    // click using How package
    public static void click (How how, String locator)
    {
        //wait.until(ExpectedConditions.elementToBeClickable(how.buildBy(locator)));
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
    public enum browserType{
        CHROME, COCOC, FIREFOX, HEADLESS
    }


    public static void setBrowser(browserType type) {

        if(type == browserType.CHROME){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (type == browserType.FIREFOX){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (type == browserType.COCOC){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Vinh\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        } else if(type == browserType.HEADLESS){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Vinh\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
    }

    public static void captureScreenShot(String name){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotImage = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotImage, new File("./"+name+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void waitImplicit(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static boolean isChecked(How how, String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how, locator).isSelected();
    }

    public static boolean isDisplayed(How how, String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how, locator).isDisplayed();
    }

    public static boolean isEnabled(How how, String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how, locator).isEnabled();
    }

    public static void select(How how, String locator, String selectValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        Select dropdown = new Select(getElement(how,locator));
        dropdown.selectByVisibleText(selectValue);
    }

    public static void check(How how, String locator, String checkValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        //wait.until(ExpectedConditions.elementToBeClickable(how.buildBy(locator)));
        if(!isChecked(how, locator)){
            click(how,locator);
        }
    }

    public static void quit ()
    {
        driver.quit();
    }

}
