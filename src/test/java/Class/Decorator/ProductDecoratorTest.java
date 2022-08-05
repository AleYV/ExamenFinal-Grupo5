package Class.Decorator;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDecoratorTest {
    AbstractProduct pizza = new Pizza("base",10.2f,null);
    AbstractProduct hamburger = new Hamburger("normal", 5.5f, null);

    @Test
    public void testCalculateCostPizza(){
        NeapolitanPizza neapolitanPizza = new NeapolitanPizza(pizza);
        CarbonaraPizza carbonaraPizza = new CarbonaraPizza(pizza);
        float result = neapolitanPizza.calculateCost();
        assertEquals(pizza.getPrice()*1.4f,result);
        result = carbonaraPizza.calculateCost();
        assertEquals(pizza.getPrice()*1.3f,result);
    }

    @Test
    public void testCalculateCostHamburger(){
        VegetarianHamburger vegetarianHamburger = new VegetarianHamburger(hamburger);
        RanchHamburger ranchHamburger = new RanchHamburger(hamburger);
        float result = vegetarianHamburger.calculateCost();
        assertEquals(hamburger.getPrice()*1.5f,result);
        result = ranchHamburger.calculateCost();
        assertEquals(hamburger.getPrice()*1.2f,result);
    }
}