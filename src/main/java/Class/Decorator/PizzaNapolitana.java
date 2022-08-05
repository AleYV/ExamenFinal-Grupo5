package Class.Decorator;

import javax.swing.*;

public class PizzaNapolitana extends ProductDecorator{
    public PizzaNapolitana(String name, float price, ImageIcon img) {
        super(name, price, img);
    }

    public float calculateCost(PizzaNapolitana pizza){
        return pizza.getPrice()*1.4f;
    }
}
