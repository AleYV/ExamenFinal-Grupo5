import Class.Branch.FastFoodBranch;
import Class.Decorator.NeapolitanPizza;
import Class.Factory.FastFoodBranchFactory;
import Class.Factory.HamburgerBranchFactory;
import Class.Factory.PizzaBranchFactory;
import Class.Menu.AbstractMenu;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;
import Class.Observer.MenuEditor;
import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;

/*
* ESTA CLASE ES SOLO CON FINES DE DEBUG, NO ES LA APP CLIENTE.
*  ESTA CLASE DEBE SER ELIMINADA EN LA FASE DE PRODUCCIÓN. AL IGUAL QUE LOS MÉTODOS
*  TO STRING DE LAS CLASES
* */

public class runnable {
    public static void main(String[] args) {
        MenuEditor menuEditor = new MenuEditor();
        FastFoodBranch newPizzaBranch = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(10, true, "here",
                        false, false, new PizzaMenu(7)));
        System.out.println(newPizzaBranch.toString());
        newPizzaBranch.getMenu().generateMenu();
        newPizzaBranch.getMenu().printMenu();
        menuEditor.manager.subscribe("pizza", newPizzaBranch.getMenu());
        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherPizzaBranch = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(25, true, "not here",
                       true, true, new PizzaMenu(5)));
        System.out.println(yetAnotherPizzaBranch);
        yetAnotherPizzaBranch.getMenu().generateMenu();
        menuEditor.manager.subscribe("pizza", yetAnotherPizzaBranch.getMenu());
        yetAnotherPizzaBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch newHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(7, false, "nowhere", false,
                       true, new HamburgerMenu(10)));
        System.out.println(newHamburgerBranch);
        newHamburgerBranch.getMenu().generateMenu();
        menuEditor.manager.subscribe("hamburger", newHamburgerBranch.getMenu());
        newHamburgerBranch.getMenu().printMenu();

       System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        FastFoodBranch yetAnotherHamburgerBranch = FastFoodBranchFactory.getBranch(
                new HamburgerBranchFactory(30, true, "everywhere",
                        true, true, new HamburgerMenu(21)));
        System.out.println(yetAnotherHamburgerBranch);
        yetAnotherHamburgerBranch.getMenu().generateMenu();
        menuEditor.manager.subscribe("hamburger", yetAnotherHamburgerBranch.getMenu());
        yetAnotherHamburgerBranch.getMenu().printMenu();
        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
        AbstractProduct hamburguesaNueva = new Hamburger("Hamburguesa con tocino",5.0f,null);
        menuEditor.manager.notifyObserver("hamburger",hamburguesaNueva);
        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
        yetAnotherHamburgerBranch.getMenu().printMenu();

        System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");


        AbstractMenu pizzaMenu = new PizzaMenu(3);
        pizzaMenu.generateMenu();
        FastFoodBranch newPizzaBranch1 = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(10, true, "here",
                        false, false, pizzaMenu));
        newPizzaBranch1.getMenu().printMenu();
        System.out.println("======================");
        AbstractProduct pizza = new Pizza("base",10.2f,null);
        NeapolitanPizza neapolitanPizza = new NeapolitanPizza(pizza);
        System.out.println("El costo de una pizza napolitana es: "+neapolitanPizza.calculateCost());
        System.out.println("El costo de una pizza es: "+pizza.getPrice());

    }
}
