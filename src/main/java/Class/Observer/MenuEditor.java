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

    public String addCombHamburger(String name, float price, ImageIcon img){
        newComb = new Hamburger(name,price,img);
        return manager.notifyObserver("hamburger",newComb);
    }

    public String addCombPizza(String name, float price, ImageIcon img){
        newComb = new Pizza(name,price,img);
        return manager.notifyObserver("pizza",newComb);
    }
}
