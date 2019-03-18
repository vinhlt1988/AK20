package inspect;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static supports.CommonFunctions.*;

public class TableTest {
    public static void main(String[] args) {
        setBrowser("headless");
        visit("https://the-internet.herokuapp.com/tables");

        List<WebElement> rows = getElements(How.XPATH, "//table[@id='table1']/tbody/tr");
        List<WebElement> columns = getElements(How.XPATH, "//table[@id='table1']/thead/tr/th");

        List<List<String>> table = new ArrayList<List<String>>();

        for(int i = 1; i <= rows.size(); i++) {
            List<String> row = new ArrayList<>();
            for (int j = 1; j <= columns.size(); j++) {
                //System.out.println();
                String value = getCell(i,j).getText();
                row.add(value);
                //System.out.println(value);
            }
            table.add(row);
        }

        for (int i = 0; i < table.size(); i++) {
            //System.out.println(table.get(i));
            if (table.get(i).get(3).equalsIgnoreCase("$50.00"))
            {
                System.out.println(table.get(i));
            }
            /*
            for (int j = 0; j < table.get(i).size(); j++) {
                System.out.println(table.get(i).get(j));
            }
            */

        }

        //table[@id='table1']//thead/tr/th
        //table[@id='table1']//tbody/tr[1]/td[3]

        //string buffer, string formatter, +chuỗi
        //bt1: validation gia tri
        //bt2: click 1 cell, voi gia tri coi trc
        //broken image
        //frame
        //jquery
        //alerts

        quit();
    }
}
