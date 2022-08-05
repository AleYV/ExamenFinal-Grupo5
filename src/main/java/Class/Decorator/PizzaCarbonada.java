package Class.Decorator;

import Class.Product.AbstractProduct;

public class PizzaCarbonada extends ProductDecorator{

    public PizzaCarbonada(AbstractProduct pizza){
        super(pizza);
    }

    @Override
    public float calculateCost() {
        return product.getPrice()*1.3f;
    }
}
