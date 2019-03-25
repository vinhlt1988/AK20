package modules.inspect;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class DropdownTest {
    public static void main(String[] args) throws InterruptedException {
        setBrowser(browserType.COCOC);
        visit("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(500);

        selectOption(How.XPATH, "//select[@id='dropdown']", "1");

        //click(How.XPATH, "//option[@value='1']");
        //Thread.sleep(500);

        //click(How.XPATH, "//option[@value='2']");
        //Thread.sleep(500);

        Thread.sleep(2000);
        quit();
    }
}
