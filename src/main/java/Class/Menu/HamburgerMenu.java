package Class.Menu;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Interface.MenuObserver;

public class HamburgerMenu extends AbstractMenu implements MenuObserver {

    public HamburgerMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu() {
        for(int i = 0; i < menuSize; i++){
            menu.add(new Hamburger("Combo " + (i+1), (1.79f)*(i+1), null));
        }
    }

    @Override
    public String update(String menuType, AbstractProduct newProduct) {
        menu.add(newProduct);
        menuSize++;
        return "Se ah agregado un nuevo combo de hamburguesa";
    }
}
