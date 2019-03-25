package modules.inspect;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class iFrameTest {
    public static void main(String[] args) {
        setBrowser(browserType.COCOC);
        visit("https://the-internet.herokuapp.com/iframe");

        //getDriver().switchTo().frame("mce_0_ifr");
        //getDriver().switchTo().frame(0);
        getDriver().switchTo().frame(getElement(How.TAG_NAME, "iframe"));

        getElement(How.XPATH, "//p[.='Your content goes here.']").clear();

        quit();
    }
}
