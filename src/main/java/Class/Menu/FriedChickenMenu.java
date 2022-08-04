package Class.Menu;

import Class.Product.FriedChicken;

public class FriedChickenMenu extends AbstractMenu{

    public FriedChickenMenu(int menuSize) {
        this.menuSize = menuSize;
    }

    @Override
    public void generateMenu(){
        for(int i = 1; i <= menuSize; i++){
            menu.add(new FriedChicken("Combo " + i, (4.99f)*i, null));
        }
    }
}
