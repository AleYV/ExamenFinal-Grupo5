package Class.Decorator;

import Class.Product.AbstractProduct;

public class RanchHamburger extends ProductDecorator{

    public RanchHamburger(AbstractProduct hamburger){
        super(hamburger);
    }
    @Override
    public float calculateCost() {
        return product.getPrice()*1.2f;
    }
}
