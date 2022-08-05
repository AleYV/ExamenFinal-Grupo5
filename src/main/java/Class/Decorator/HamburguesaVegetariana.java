package Class.Decorator;

import Class.Product.AbstractProduct;

import javax.swing.*;

public class HamburguesaVegetariana extends ProductDecorator{

    public HamburguesaVegetariana(AbstractProduct hamburger){
        super(hamburger);
    }
    @Override
    public float calculateCost() {
        return product.getPrice()*1.5f;
    }
}
