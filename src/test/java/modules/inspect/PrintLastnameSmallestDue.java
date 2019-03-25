package modules.inspect;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static supports.CommonFunctions.*;

public class PrintLastnameSmallestDue {
    public static void main(String[] args) {

        setBrowser(browserType.COCOC);
        visit("https://the-internet.herokuapp.com/tables");

        int numberOfRows = getElements(How.XPATH, "//table[@id='table1']//tbody/tr").size();
        int numberOfColumns = getElements(How.XPATH, "//table[@id='table1']//thead/tr/th").size();

        int dueColumn = findHeaderColumnIndex("Due", numberOfColumns);
        int lastnameColumn = findHeaderColumnIndex("Last name", numberOfColumns);

        List<String> lastnameBySmallestDue = new ArrayList<>();

        //getting the smallestDue
        //set smallestDue = due amount of 1st row
        double smallestDue = Double.parseDouble(getCell(tableType.TABLE1, 1,dueColumn).getText().replaceAll("\\$", ""));

        for(int row = 1; row <= numberOfRows; row++) {
            double value = Double.parseDouble(getCell(tableType.TABLE1,row,dueColumn).getText().replaceAll("\\$", ""));
            if (smallestDue > value) {
                smallestDue = value;
            }
        }

        //getting Lastname by smallestDue, and add them to List
        for(int row = 1; row <= numberOfRows; row++) {
            double value = Double.parseDouble(getCell(tableType.TABLE1,row,dueColumn).getText().replaceAll("\\$", ""));
            if (value==smallestDue)
                lastnameBySmallestDue.add(getCell(tableType.TABLE1,row,lastnameColumn).getText());

        }

        System.out.println("Smallest due is: " + smallestDue + ", belong to: " + lastnameBySmallestDue);

        quit();

    }
}
