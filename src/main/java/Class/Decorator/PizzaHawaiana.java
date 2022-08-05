package Class.Decorator;

import javax.swing.*;

public class PizzaHawaiana extends ProductDecorator{
    public PizzaHawaiana(String name, float price, ImageIcon img) {
        super(name, price, img);
    }

    public float calculateCost(PizzaHawaiana pizza){
        return pizza.getPrice()*1.3f;
    }
}
