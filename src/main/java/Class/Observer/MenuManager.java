package Class.Observer;

import Class.Product.AbstractProduct;
import Interface.MenuObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuManager {

    Map<String, List<MenuObserver>> observers = new HashMap<>();

    public MenuManager(String... products){
        for (String product:products){
            this.observers.put(product, new ArrayList<>());
        }
    }

    public void subscribe(String menuType, MenuObserver observer){
        List<MenuObserver> clients = observers.get(menuType);
        clients.add(observer);
    }

    public void unsubscribe(String menuType, MenuObserver observer){
        List<MenuObserver> clients = observers.get(menuType);
        clients.remove(observer);
    }


    public String notifyObserver(String menuType,AbstractProduct abstractProduct){
        List<MenuObserver> clients = observers.get(menuType);
        String capture = "";
        for(MenuObserver observer : clients){
            capture = observer.update(menuType,abstractProduct);
        }
        return capture;
    }
}
