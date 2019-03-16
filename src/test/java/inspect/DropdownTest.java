package inspect;
import org.openqa.selenium.support.How;

import static supports.MyWebDriver.*;

public class DropdownTest {
    public static void main(String[] args) throws InterruptedException {
        setBrowser("coccoc");
        visit("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(500);

        click(How.XPATH, "//option[@value='1']");
        Thread.sleep(500);

        click(How.XPATH, "//option[@value='2']");
        Thread.sleep(500);

        Thread.sleep(2000);
        quit();
    }
}
