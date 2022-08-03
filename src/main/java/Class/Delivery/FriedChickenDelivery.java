package Class.Delivery;

import Interface.Delivery;

public class FriedChickenDelivery implements Delivery {
    int personal;

    public FriedChickenDelivery(int personal) {
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
