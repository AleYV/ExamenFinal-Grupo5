package Class.Observer;

import Class.Product.AbstractProduct;
import Interface.MenuObserver;

public class Notifier implements MenuObserver {

    @Override
    public void update(AbstractProduct newProduct) {
        System.out.println("Hay un nuevo menu de: ");
    }
}
