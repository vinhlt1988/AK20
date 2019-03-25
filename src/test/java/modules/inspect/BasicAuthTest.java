package modules.inspect;
import static supports.CommonFunctions.*;

public class BasicAuthTest {
    public static void main(String[] args) {

        setBrowser(browserType.COCOC);
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}
