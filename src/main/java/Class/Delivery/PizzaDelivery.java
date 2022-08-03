package Class.Delivery;

import Interface.Delivery;

public class PizzaDelivery implements Delivery {
    int personal;

    public PizzaDelivery(int personal) {
        this.personal = personal;
    }

    @Override
    public int getAvailablePersonal() {
        return personal;
    }

    @Override
    public boolean sendOne() {
        if(personal > 0) {
            personal--;
            return true;
        }
        return false;
    }

    @Override
    public void returnOne() {
        personal++;
    }
}
