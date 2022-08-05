import Class.Branch.FastFoodBranch;
import Class.Decorator.PizzaNapolitana;
import Class.Factory.FastFoodBranchFactory;
import Class.Factory.HamburgerBranchFactory;
import Class.Factory.PizzaBranchFactory;
import Class.Menu.AbstractMenu;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;
import Class.Product.AbstractProduct;
import Class.Product.Pizza;

/*
* ESTA CLASE ES SOLO CON FINES DE DEBUG, NO ES LA APP CLIENTE.
*  ESTA CLASE DEBE SER ELIMINADA EN LA FASE DE PRODUCCIÓN. AL IGUAL QUE LOS MÉTODOS
*  TO STRING DE LAS CLASES
* */

public class runnable {
    public static void main(String[] args) {
        FastFoodBranch newPizzaBranch = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(10, true, "here",
                        false, false, new PizzaMenu(7)));
        System.out.println(newPizzaBranch.toString());
        newPizzaBranch.getMenu().generateMenu();
        newPizzaBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherPizzaBranch = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(25, true, "not here",
                       true, true, new PizzaMenu(5)));
        System.out.println(yetAnotherPizzaBranch);
        yetAnotherPizzaBranch.getMenu().generateMenu();
        yetAnotherPizzaBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch newHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(7, false, "nowhere", false,
                       true, new HamburgerMenu(10)));
        System.out.println(newHamburgerBranch);
        newHamburgerBranch.getMenu().generateMenu();
        newHamburgerBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(30, true, "everywhere",
                        true, true, new HamburgerMenu(21)));
        System.out.println(yetAnotherHamburgerBranch);
        yetAnotherHamburgerBranch.getMenu().generateMenu();
        yetAnotherHamburgerBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        AbstractMenu pizzaMenu = new PizzaMenu(3);
        pizzaMenu.generateMenu();
        FastFoodBranch newPizzaBranch1 = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(10, true, "here",
                        false, false, pizzaMenu));
        newPizzaBranch1.getMenu().printMenu();
        newPizzaBranch1.getMenu().addObserver(pizzaMenu);
        pizzaMenu.timePasses();
        newPizzaBranch1.getMenu().printMenu();
        System.out.println("======================");
        AbstractProduct pizza = new Pizza("napolitana",10.2f,null);
        PizzaNapolitana pizzanapolitana = new PizzaNapolitana(pizza);
        System.out.println("El costo de una pizza napolitana es: "+pizzanapolitana.calculateCost());
        System.out.println("El costo de una pizza es: "+pizza.getPrice());
    }
}
