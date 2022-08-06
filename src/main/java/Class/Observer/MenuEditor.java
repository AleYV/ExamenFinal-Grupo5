package Class.Observer;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;

import javax.swing.ImageIcon;

public class MenuEditor {
    public MenuManager manager;
    private AbstractProduct newComb;

    public MenuEditor(){
        this.manager = new MenuManager("hamburger","pizza");
    }

    public void addCombHamburger(String name, float price, ImageIcon img){
        newComb = new Hamburger(name,price,img);
        manager.notifyObserver("hamburger",newComb);
    }

    public void addCombPizza(String name, float price, ImageIcon img){
        newComb = new Pizza(name,price,img);
        manager.notifyObserver("pizza",newComb);
    }
}
