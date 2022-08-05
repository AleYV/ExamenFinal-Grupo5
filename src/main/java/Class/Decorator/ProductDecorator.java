package Class.Decorator;

import Class.Product.AbstractProduct;

import javax.swing.*;

public class ProductDecorator extends AbstractProduct {
    public ProductDecorator(String name, float price, ImageIcon img) {
        super(name, price, img);
    }
}
