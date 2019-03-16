package inspect;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class ClickLinkByText {
    public static void main(String[] args) throws InterruptedException {
        setBrowser("coccoc");
        visit("https://the-internet.herokuapp.com/redirector");
        //click(How.XPATH, "//a[@id='redirect']");
        click(How.XPATH, "//a[.='here']");
        Thread.sleep(1000);

        click(How.XPATH, "//a[.='200']");
        Thread.sleep(1000);
        back();
        Thread.sleep(1000);

        click(How.XPATH, "//a[.='301']");
        Thread.sleep(1000);
        back();
        Thread.sleep(1000);

        click(How.XPATH, "//a[.='404']");
        Thread.sleep(1000);
        back();
        Thread.sleep(1000);

        click(How.XPATH, "//a[.='500']");
        Thread.sleep(1000);
        back();
        Thread.sleep(1000);

        Thread.sleep(2000);
        quit();
    }
}
