package Class.Product;

import javax.swing.ImageIcon;

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
}
