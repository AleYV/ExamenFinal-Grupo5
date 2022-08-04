package Class.Menu;

import Class.Product.Pizza;

public class PizzaMenu extends AbstractMenu{

    public PizzaMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu() {
        for(int i = 0; i < menuSize; i++){
            menu.add(new Pizza("Combo " + i, (3.49f)*i, null));
        }
    }
}
