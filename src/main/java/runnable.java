import Class.Branch.FastFoodBranch;
import Class.Factory.FastFoodBranchFactory;
import Class.Factory.HamburgerBranchFactory;
import Class.Factory.PizzaBranchFactory;
import Class.Menu.AbstractMenu;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;
import Interface.MenuObserver;

import javax.swing.*;

/*
* TODO: ESTA FUNCION ES SOLO CON FINES DE DEBUG, NO ES LA APP CLIENTE.
*  ESTA FUNCION DEBE SER ELIMINADA EN LA FASE DE PRODUCCION. AL IGUAL QUE LOS METODOS
*  TO STRING DE LAS CLASES
* */




public class runnable {
    public static void main(String[] args) {
        /*FastFoodBranch newPizzaBranch = FastFoodBranchFactory.getBranch(
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

        //System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");*/
        AbstractMenu pizzaMenu = new PizzaMenu(3);
        pizzaMenu.generateMenu();
        FastFoodBranch newPizzaBranch = FastFoodBranchFactory.getBranch(
                new PizzaBranchFactory(10, true, "here",
                        false, false, pizzaMenu));
        newPizzaBranch.getMenu().printMenu();
        newPizzaBranch.getMenu().addObserver(pizzaMenu);
        pizzaMenu.timePasses();
        newPizzaBranch.getMenu().printMenu();
    }
}
