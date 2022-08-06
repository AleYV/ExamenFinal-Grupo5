package Interface;

import Class.Product.AbstractProduct;

public interface MenuObserver{
    void update(String menuType,AbstractProduct newComb);
}
