package Class.Menu;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;
import Interface.MenuObserver;

import javax.swing.*;
import java.util.Random;

public class PizzaMenu extends AbstractMenu implements MenuObserver {

    public PizzaMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu() {
        for(int i = 0; i < menuSize; i++){
            menu.add(new Pizza("Combo " + i, (3.49f)*i, null));
        }
    }

    @Override
    public void timePasses() {
        int numero = (int)(Math.random()*5+1);
        newProduct = new Pizza("Combo "+numero,20,new ImageIcon(PATHPIZZA+numero+".jpg"));
        notifyObservers();
    }

    @Override
    public void update(AbstractProduct newProduct) {
        menu.add(newProduct);
        menuSize++;
    }
}
