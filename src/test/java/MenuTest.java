import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class MenuTest {

    @Test
    public void AssertMenuTrue() {
        int option = 1;
        boolean result = TestMenu(option);

        assertTrue(result);
    }

    @Test
    public void AssertMenuFalse() {
        int option = 0;
        boolean result = TestMenu(option);

        assertTrue(result);
    }

    private boolean TestMenu(int option) {

        Menu menu = new Menu();

        boolean returnMenu = menu.verifyValidOption(option);

        return returnMenu;
    }

}

