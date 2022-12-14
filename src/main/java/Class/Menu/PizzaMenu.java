package Class.Menu;

import Class.Product.AbstractProduct;
import Class.Product.Pizza;
import Interface.MenuObserver;

public class PizzaMenu extends AbstractMenu implements MenuObserver {

    public PizzaMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu() {
        for(int i = 0; i < menuSize; i++){
            menu.add(new Pizza("Combo " + i, (3.49f)*i, null));
        }
    }

    @Override
    public String update(String menuType,AbstractProduct newProduct) {
        menu.add(newProduct);
        menuSize++;
        return "Se ah agregado un nuevo combo de pizza";
    }
}
