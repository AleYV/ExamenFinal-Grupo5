package Class.Decorator;

import Class.Product.AbstractProduct;
import Class.Product.Pizza;

import javax.swing.*;

public class PizzaHawaiana extends ProductDecorator{

    public PizzaHawaiana(AbstractProduct pizza){
        super(pizza);
    }

    @Override
    public float calculateCost() {
        return product.getPrice()*1.3f;
    }
}
