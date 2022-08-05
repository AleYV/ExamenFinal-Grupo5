package Class.Decorator;

import Class.Product.AbstractProduct;

public class HamburguesaRanchera extends ProductDecorator{

    public HamburguesaRanchera(AbstractProduct hamburger){
        super(hamburger);
    }
    @Override
    public float calculateCost() {
        return product.getPrice()*1.2f;
    }
}
