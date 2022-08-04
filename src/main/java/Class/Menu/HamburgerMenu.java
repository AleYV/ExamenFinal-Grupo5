package Class.Menu;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;
import Interface.MenuObserver;

import javax.swing.*;
import java.util.Random;

public class HamburgerMenu extends AbstractMenu implements MenuObserver {

    public HamburgerMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu() {
        for(int i = 0; i < menuSize; i++){
            menu.add(new Hamburger("Combo " + i, (1.79f)*i, null));
        }
    }

    @Override
    public void timePasses() {
        int numero = (int)(Math.random()*5+1);
        newProduct = new Hamburger("Combo "+numero,20, new ImageIcon(PATHHAMBURGER+numero+".jpg"));
        notifyObservers();
    }


    @Override
    public void update(AbstractProduct newProduct) {
        menu.add(newProduct);
        menuSize++;
    }
}
