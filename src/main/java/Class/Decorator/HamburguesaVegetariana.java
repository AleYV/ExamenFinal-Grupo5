package Class.Decorator;

import javax.swing.*;

public class HamburguesaVegetariana extends ProductDecorator{
    public HamburguesaVegetariana(String name, float price, ImageIcon img) {
        super(name, price, img);
    }

    public float calculateCost(HamburguesaVegetariana hamburger){
        return hamburger.getPrice()*2;
    }
}
