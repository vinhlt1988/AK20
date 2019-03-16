package inspect;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.List;

import static supports.CommonFunctions.*;

public class TableTest {
    public static void main(String[] args) {
        setBrowser("coccoc");
        visit("https://the-internet.herokuapp.com/tables");

        List<WebElement> rows = getElements(How.XPATH, "//table[@id='table1']/tbody/tr");
        List<WebElement> columns = getElements(How.XPATH, "//table[@id='table1']/thead/tr/th");

        System.out.println(rows.size() + "   " + columns.size());

        for(int i = 1; i <= rows.size(); i++)
            for (int j=1; j <= columns.size(); j++)
            {
                System.out.println();
                String value = getElement(How.XPATH, String.format("//table[@id='table1']//tbody/tr[%d]/td[%d]", i, j)).getText();
                System.out.println(value);
            }

        //table[@id='table1']//thead/tr/th
        //table[@id='table1']//tbody/tr[1]/td[3]
        quit();
    }
}
