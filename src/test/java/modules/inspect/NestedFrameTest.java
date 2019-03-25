package modules.inspect;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class NestedFrameTest {
    public static void main(String[] args) throws InterruptedException {
        setBrowser(browserType.COCOC);
        visit("https://the-internet.herokuapp.com/nested_frames");

        //getDriver().switchTo().frame("frame-bottom");

        getDriver().switchTo().frame("frame-top");
        getDriver().switchTo().frame("frame-left");

        System.out.println((getElement(How.XPATH, "/html/body").getText()));

        Thread.sleep(1000);
        quit();
    }
}
