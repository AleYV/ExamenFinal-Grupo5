package Class.Observer;

import Class.Branch.FastFoodBranch;
import Class.Factory.FastFoodBranchFactory;
import Class.Factory.HamburgerBranchFactory;
import Class.Factory.PizzaBranchFactory;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuEditorTest {

    @Nested
    class ObserverTestHamburger{
        MenuEditor menuEditor = new MenuEditor();
        String returnMessage = "";
        FastFoodBranch newHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(10,true,"in some areas", false,true, new HamburgerMenu(5)));

        FastFoodBranch newPizzaBranch = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(8,true,"somewhere",true,false,new PizzaMenu(5)));
        @DisplayName("Notificacion de una nueva hamburguesa en el menu")
        @Test
        public void  testNotificationNewHamburger(){
            newHamburgerBranch.getMenu().generateMenu();
            menuEditor.manager.subscribe("hamburger", newHamburgerBranch.getMenu());
            returnMessage = menuEditor.addCombHamburger("Hamburguesa con tocino",10.0f,null);
            assertEquals(returnMessage, "Se ah agregado un nuevo combo de hamburguesa");
        }

        @DisplayName("Notificacion de una pizza en el menu")
        @Test
        public void testNotificationNewPizza(){
            newPizzaBranch.getMenu().generateMenu();
            menuEditor.manager.subscribe("pizza", newPizzaBranch.getMenu());
            returnMessage = menuEditor.addCombPizza("Pizza con piña",10.0f,null);
            assertEquals(returnMessage, "Se ah agregado un nuevo combo de pizza");
        }

        @DisplayName("No deberia haber una notificacion cuando este desuscrito")
        @Test
        public void testNotNotification(){
            newPizzaBranch.getMenu().generateMenu();
            menuEditor.manager.subscribe("pizza", newPizzaBranch.getMenu());
            menuEditor.manager.unsubscribe("pizza", newPizzaBranch.getMenu());
            returnMessage = menuEditor.addCombPizza("Pizza con piña",10.0f,null);
            assertNotEquals(returnMessage, "Se ah agregado un nuevo combo de pizza");
        }
    }

}