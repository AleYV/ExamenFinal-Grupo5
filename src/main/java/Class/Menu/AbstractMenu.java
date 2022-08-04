package Class.Menu;

import Class.Product.AbstractProduct;

import java.util.ArrayList;

public abstract class AbstractMenu {
    protected int menuSize;
    protected ArrayList<AbstractProduct> menu = new ArrayList<>();

    public abstract void generateMenu();

    public ArrayList<AbstractProduct> getMenuList() {
        return menu;
    }

    public void printMenu(){
        System.out.println("Menu: ");
        for (AbstractProduct product:
             menu) {
            System.out.println(product.toString());
        }
    }
}
