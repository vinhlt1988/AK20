package modules.inspect;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class JavaScriptPopupTest {
    public static void main(String[] args) throws InterruptedException {
        setBrowser(browserType.COCOC);
        visit("https://the-internet.herokuapp.com/javascript_alerts");

        //getElement(How.XPATH, "//button[.='Click for JS Alert']").click();
        //getElement(How.XPATH, "//button[.='Click for JS Confirm']").click();
        getElement(How.XPATH, "//button[.='Click for JS Prompt']").click();
        getDriver().switchTo().alert().sendKeys("abcxyz");
        getDriver().switchTo().alert().accept();
        captureScreenShot("javapopuptest");

        Thread.sleep(1000);
        quit();
    }
}
