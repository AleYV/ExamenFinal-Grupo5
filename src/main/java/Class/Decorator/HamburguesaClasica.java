package Class.Decorator;

import Class.Product.AbstractProduct;

import javax.swing.*;

public class HamburguesaClasica extends ProductDecorator{

    public HamburguesaClasica(AbstractProduct hamburger){
        super(hamburger);
    }
    @Override
    public float calculateCost() {
        return product.getPrice();
    }
}
