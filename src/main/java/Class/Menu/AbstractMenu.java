package Class.Menu;

import Class.Product.AbstractProduct;
import Interface.MenuObserver;

import java.util.ArrayList;

public abstract class AbstractMenu implements MenuObserver{
    protected int menuSize;
    protected ArrayList<AbstractProduct> menu = new ArrayList<>();
    public abstract void generateMenu();

    public ArrayList<AbstractProduct> getMenuList() {
        return menu;
    }

    //Fase de desarrollo
    public void printMenu(){
        System.out.println("Menu: ");
        for (AbstractProduct product:
             menu) {
            System.out.println(product.toString());
        }
    }
}
