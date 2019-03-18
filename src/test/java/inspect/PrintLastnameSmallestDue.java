package inspect;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static supports.CommonFunctions.*;

public class PrintLastnameSmallestDue {
    public static void main(String[] args) {

        setBrowser("coccoc");
        visit("https://the-internet.herokuapp.com/tables");

        int numberOfRows = getElements(How.XPATH, "//table[@id='table1']/tbody/tr").size();
        int numberOfColumns = getElements(How.XPATH, "//table[@id='table1']/thead/tr/th").size();
        int dueColumn = 4;
        int lastnameColumn = 1;
        double smallestDue = 999999999;

        List<String> lastnameBySmallestDue = new ArrayList<>();

        //getting the smallestDue
        for(int row = 1; row <= numberOfRows; row++) {
            StringBuffer data = new StringBuffer(getCell(row,dueColumn).getText());
            double value = Double.parseDouble(data.delete(0,1).toString());
            if (smallestDue > value) {
                smallestDue = value;
            }
        }

        //getting Lastname by smallestDue, and add them to List
        for(int row = 1; row <= numberOfRows; row++) {
            StringBuffer data = new StringBuffer(getCell(row,dueColumn).getText());
            double value = Double.parseDouble((data.delete(0,1).toString()));
            if (value==smallestDue)
                lastnameBySmallestDue.add(getCell(row,lastnameColumn).getText());

        }

        quit();
        System.out.println("Smallest due is: " + smallestDue + ", belong to: " + lastnameBySmallestDue);


    }
}
