package Class.Decorator;

import Class.Product.AbstractProduct;

import javax.swing.*;

public class PizzaNapolitana extends ProductDecorator{

    public PizzaNapolitana(AbstractProduct pizza){
        super(pizza);
    }

    @Override
    public float calculateCost() {
        return product.getPrice()*1.4f;
    }
}
