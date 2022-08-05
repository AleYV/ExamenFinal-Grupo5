package Class.Decorator;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDecoratorTest {
    AbstractProduct pizza = new Pizza("napolitana",10.2f,null);
    AbstractProduct hamburger = new Hamburger("vegetariana", 5.5f, null);

    @Test
    public void testCalculateCostPizza(){
        PizzaNapolitana pizzanapolitana = new PizzaNapolitana(pizza);
        PizzaCarbonada pizzacarbonada = new PizzaCarbonada(pizza);
        float result = pizzanapolitana.calculateCost();
        assertEquals(pizza.getPrice()*1.4f,result);
        result = pizzacarbonada.calculateCost();
        assertEquals(pizza.getPrice()*1.3f,result);
    }

    @Test
    public void testCalculateCostHamburger(){
        HamburguesaVegetariana hamburguesaVegetariana = new HamburguesaVegetariana(hamburger);
        HamburguesaRanchera hamburguesaRanchera = new HamburguesaRanchera(hamburger);
        float result = hamburguesaVegetariana.calculateCost();
        assertEquals(hamburger.getPrice()*1.5f,result);
        result = hamburguesaRanchera.calculateCost();
        assertEquals(hamburger.getPrice()*1.2f,result);
    }
}