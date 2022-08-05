package Class.Decorator;

import javax.swing.*;

public class HamburguesaClasica extends ProductDecorator{
    public HamburguesaClasica(String name, float price, ImageIcon img) {
        super(name, price, img);
    }


    public float calculateCost(HamburguesaClasica hambuger){
        return hambuger.getPrice();
    }
}
