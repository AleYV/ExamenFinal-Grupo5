package Class.Product;

import javax.swing.ImageIcon;
import java.util.Locale;

public abstract class AbstractProduct {

    protected String name;
    protected float price;
    protected ImageIcon img;

    public AbstractProduct(String name, float price, ImageIcon img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ImageIcon getImg() {
        return img;
    }

    @Override
    public String toString() {
        String sString = "name: " + name + "\tPrice: $";
        sString += String.format(Locale.ROOT, "%.2f", price);
        if(img != null) {
            sString += " with img";
            return sString;
        }
        sString += " with no img";

        return sString;
    }
}
