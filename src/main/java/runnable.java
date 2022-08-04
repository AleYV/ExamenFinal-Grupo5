import Class.Branch.FastFoodBranch;
import Class.Delivery.FriedChickenDelivery;
import Class.Delivery.HamburgerDelivery;
import Class.Factory.FastFoodBranchFactory;
import Class.Factory.FriedChickenBranchFactory;
import Class.Factory.HamburgerBranchFactory;
import Class.Menu.FriedChickenMenu;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;
import Class.ParkingLot.FriedChickenParkingLot;
import Class.ParkingLot.HamburgerParkingLot;

/*
* TODO: ESTA FUNCION ES SOLO CON FINES DE DEBUG, NO ES LA APP CLIENTE.
*  ESTA FUNCION DEBE SER ELIMINADA EN LA FASE DE PRODUCCION. AL IGUAL QUE LOS METODOS
*  TO STRING DE LAS CLASES
* */
public class runnable {
    public static void main(String[] args) {
        FastFoodBranch newPizzaBranch = FastFoodBranchFactory.getBranch(
                new FriedChickenBranchFactory(10, true, "here",
                        null, null, new PizzaMenu(7)));
        System.out.println(newPizzaBranch.toString());
        newPizzaBranch.getMenu().generateMenu();
        newPizzaBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherPizzaBranch = FastFoodBranchFactory.getBranch(
                new FriedChickenBranchFactory(25, true, "not here",
                        new FriedChickenParkingLot(20), new FriedChickenDelivery(10),
                            new PizzaMenu(5)));
        System.out.println(yetAnotherPizzaBranch);
        yetAnotherPizzaBranch.getMenu().generateMenu();
        yetAnotherPizzaBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch newHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(7, false, "nowhere", null,
                        new HamburgerDelivery(5), new HamburgerMenu(10)));
        System.out.println(newHamburgerBranch);
        newHamburgerBranch.getMenu().generateMenu();
        newHamburgerBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(30, true, "everywhere",
                        new HamburgerParkingLot(15), new HamburgerDelivery(12),
                        new HamburgerMenu(21)));
        System.out.println(yetAnotherHamburgerBranch);
        yetAnotherHamburgerBranch.getMenu().generateMenu();
        yetAnotherHamburgerBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch newFriedChickenBranch = FastFoodBranchFactory.getBranch(
                new FriedChickenBranchFactory(20, true, "anywhere",
                        new FriedChickenParkingLot(10), null, new FriedChickenMenu(13)));
        System.out.println(newFriedChickenBranch);
        newFriedChickenBranch.getMenu().generateMenu();
        newFriedChickenBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherFriedChickenBranch = FastFoodBranchFactory.getBranch(
                new FriedChickenBranchFactory(10, false, "somewhere", null,
                        null, new FriedChickenMenu(10)));
        System.out.println(yetAnotherFriedChickenBranch);
        yetAnotherFriedChickenBranch.getMenu().generateMenu();
        yetAnotherFriedChickenBranch.getMenu().printMenu();

    }
}
