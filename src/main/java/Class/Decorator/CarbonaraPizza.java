package Class.Decorator;

import Class.Product.AbstractProduct;

public class CarbonaraPizza extends ProductDecorator{

    public CarbonaraPizza(AbstractProduct pizza){
        super(pizza);
    }

    @Override
    public float calculateCost() {
        return product.getPrice()*1.3f;
    }
}
