package Class.Menu;

import Class.Product.AbstractProduct;
import Interface.MenuObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements MenuObserver{
    protected int menuSize;
    protected AbstractProduct newProduct;
    protected List<MenuObserver> observers;
    protected ArrayList<AbstractProduct> menu = new ArrayList<>();
    protected static final String PATHHAMBURGER = System.getProperty("user.dir" + "\\src\\main\\resources\\img\\hamburger\\hamburger_");
    protected final String PATHPIZZA = System.getProperty("user.dir" + "\\src\\main\\resources\\img\\pizza\\pizza_");
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

    public AbstractMenu(){
        observers = new ArrayList<>();
    }

    public abstract void timePasses();

    public void addObserver(MenuObserver mObserver){
        observers.add(mObserver);
    }

    protected void notifyObservers(){
        for(var obs: observers){
            obs.update(newProduct);
        }
    }
}
