package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Week3 {
    public static void main(String[] args) throws InterruptedException {
        // Auto setup chromedriver
        WebDriverManager.chromedriver().setup();
        // Create options
        ChromeOptions options = new ChromeOptions();
        // Set headless
        //options.addArguments("--headless");
        // Set path for CocCoc
        options.setBinary("C:\\Users\\Vinh\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
        // Create driver with prepared options
        WebDriver driver = new ChromeDriver(options);
        // Start browser
        driver.get("https://the-internet.herokuapp.com/login");
        //driver.findElement(By.tagName("input")).sendKeys("tomsmith");
        //driver.findElement(By.name("input")).sendKeys("tomsmith");
        //driver.findElement(By.id("input")).sendKeys("tomsmith");

        //driver.findElement(By.cssSelector("input")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("input[id='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");

        //driver.findElement(By.xpath("//input")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//input[contains(@name, 'username')]")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//*[contains(@name, 'username')]")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.xpath("//input[@aria-label='Tìm kiếm']")).sendKeys("hello\n");
        //driver.findElement(By.cssSelector("input[aria-label='Tìm kiếm']")).sendKeys("hello\n");

        // xpath navigation:
        //driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//label[.='Username']/following-sibling::input")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='username']/../../../div[2]/div/input")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
