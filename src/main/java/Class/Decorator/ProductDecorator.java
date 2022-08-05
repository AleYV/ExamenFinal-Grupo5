package Class.Decorator;

import Class.Product.AbstractProduct;

public abstract class ProductDecorator {
    AbstractProduct product;
    public ProductDecorator(AbstractProduct product){
        this.product=product;
    }
    public abstract float calculateCost();
}
