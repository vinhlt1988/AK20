package modules.inspect;
import org.openqa.selenium.support.How;

import static supports.CommonFunctions.*;

public class BMIcalculatorTest {
    /*
    * Coding convention
    * *_TXT -> Text box
    * *_TAB -> Tab
    * *_BTN -> Button
    * *_LBL -> Label
    */

    public static final String METRIC_TAB = "//a[.='Metric Units']";
    public static final String AGE_TXT = "//input[@id='cage']";
    public static final String MALE_RAD = "//input[@id='csex1']";
    public static final String FEMALE_RAD = "//input[@id='csex2']";
    public static final String HEIGHT_TXT = "//input[@id='cheightmeter']";
    public static final String WEIGHT_TXT = "//input[@id='ckg']";
    public static final String CALCULATE_BTN = "//input[@value='Calculate']";
    public static final String BMI_RESULT_BLB = "//div[@class='bigtext']";

    public static void selectMetricTab(){
        click(How.XPATH, METRIC_TAB);
    }

    public static void fillBMIForm(String age, String gender, String height, String weight){
        fill(How.XPATH, AGE_TXT, age);
        if(gender.equalsIgnoreCase("male")){
            click(How.XPATH,MALE_RAD);
        } else
        {
            click(How.XPATH,FEMALE_RAD);
        }

        fill(How.XPATH, HEIGHT_TXT, height);
        fill(How.XPATH, WEIGHT_TXT, weight);
        click(How.XPATH,CALCULATE_BTN);
    }

    public static void getBMIResult(){
        String result = getText(How.XPATH, BMI_RESULT_BLB);
        System.out.println("Your BMI result: " + result);
    }

    public static void main(String[] args) {
        setBrowser(browserType.COCOC);
        visit("https://www.calculator.net/bmi-calculator.html");

        selectMetricTab();
        fillBMIForm("30","male","170","76");
        getBMIResult();

        quit();
    }
}
