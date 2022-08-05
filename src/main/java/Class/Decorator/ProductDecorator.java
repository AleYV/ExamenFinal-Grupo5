package Class.Decorator;

import Class.Product.AbstractProduct;

import javax.swing.*;

public abstract class ProductDecorator {
    AbstractProduct product;
    public ProductDecorator(AbstractProduct product){
        this.product=product;
    }
    public abstract float calculateCost();
}
