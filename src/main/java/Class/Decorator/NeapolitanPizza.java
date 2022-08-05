package Class.Decorator;

import Class.Product.AbstractProduct;

public class NeapolitanPizza extends ProductDecorator{

    public NeapolitanPizza(AbstractProduct pizza){
        super(pizza);
    }

    @Override
    public float calculateCost() {
        return product.getPrice()*1.4f;
    }
}
