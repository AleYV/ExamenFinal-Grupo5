package Interface;

import Class.Product.AbstractProduct;

public interface MenuObserver{
    String update(String menuType,AbstractProduct newComb);
}
