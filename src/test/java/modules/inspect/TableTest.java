package modules.inspect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static supports.CommonFunctions.*;

public class TableTest {
    public static void main(String[] args) {
        setBrowser(browserType.COCOC);
        visit("https://the-internet.herokuapp.com/tables");

        //List<WebElement> rows = getElements(How.XPATH, "//table[@id='table1']/tbody/tr");
        //List<WebElement> columns = getElements(How.XPATH, "//table[@id='table1']/thead/tr/th");



        WebElement table1 = getDriver().findElement(By.id("table1"));
        List<String> columnNames = table1.findElements(By.tagName("th"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        Map<String, Integer> columnMap = IntStream.range(0, columnNames.size())
                .boxed()
                .collect(Collectors.toMap(columnNames::get,
                        Function.identity()));

        List<String> filterByDueValue = table1.findElements(By.tagName("tr")) //get all rows
                .stream()
                .skip(1) // skip first row as we do not need header
                .map(tr -> tr.findElements(By.tagName("td"))) // get all cells for each rows
                .filter(tds -> tds.get(columnMap.get("Due")).getText().equals("$50.00")) // Get cell have due = $50.00
                .map(tds -> tds.get(columnMap.get("Last Name"))) // get cell of last name
                .map(WebElement::getText)
                .collect(Collectors.toList());


        //System.out.println(columnNames);
        //System.out.println(columnMap);
        //System.out.println(filterByDueValue);
        int numberOfRows = getElements(How.XPATH, "//table[@id='table1']//tbody/tr").size();
        int numberOfColumns = getElements(How.XPATH, "//table[@id='table1']//thead/tr/th").size();
        List<List<String>> tabletest = new ArrayList<List<String>>();
        for (int row = 1; row <= numberOfRows; row++){
            List<String> arow = new ArrayList<>();
            for (int column = 1; column <= numberOfRows; column++){
                String value = getCell(tableType.TABLE1, row, column).getText();
                arow.add(value);
                System.out.println("Row: " + row + "Column: " + column + "Value: "+ value);
            }
            tabletest.add(arow);
        }

        System.out.println(tabletest);

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
