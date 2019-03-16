package inspect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;



public class CheckboxTest {
    public static void main(String[] args) throws InterruptedException {
        setBrowser("coccoc");
        visit("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(1000);

        WebElement element = getElement(How.XPATH, "//*[@id='checkboxes']//input[1]");
        if (element.isSelected() == false)
        {
            element.click();
        }

        element = getElement(How.XPATH, "//*[@id='checkboxes']//input[2]");
        if (element.isSelected() == false)
        {
            element.click();
        }

        //click(How.XPATH, "//*[@id='checkboxes']//input[1]");
        //click(How.XPATH, "//*[@id='checkboxes']//input[2]");

        Thread.sleep(2000);
        quit();

    }
}
