package Class.Menu;

import Class.Product.Hamburger;

public class HamburgerMenu extends AbstractMenu{

    public HamburgerMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu() {
        for(int i = 0; i < menuSize; i++){
            menu.add(new Hamburger("Combo " + i, (1.79f)*i, null));
        }
    }
}
