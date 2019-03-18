package inspect;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static supports.CommonFunctions.*;

public class PrintLastnameDue50 {
    public static void main(String[] args) {
        setBrowser("headless");
        visit("https://the-internet.herokuapp.com/tables");

        int numberOfRows = getElements(How.XPATH, "//table[@id='table1']/tbody/tr").size();
        int numberOfColumns = getElements(How.XPATH, "//table[@id='table1']/thead/tr/th").size();

        List<String> lastnameDue50 = new ArrayList<>();

        for(int row = 1; row <= numberOfRows; row++) {
            for (int column = 1; column <= numberOfColumns; column++) {
                String value = getCell(row,column).getText();
                if (value.equalsIgnoreCase("$50.00"))
                    lastnameDue50.add(getCell(row,1).getText());
            }
        }
        quit();
        System.out.println("Last name of people with due = $50: " + lastnameDue50);
    }
}
