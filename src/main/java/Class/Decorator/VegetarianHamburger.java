package Class.Decorator;

import Class.Product.AbstractProduct;

public class VegetarianHamburger extends ProductDecorator{

    public VegetarianHamburger(AbstractProduct hamburger){
        super(hamburger);
    }
    @Override
    public float calculateCost() {
        return product.getPrice()*1.5f;
    }
}
