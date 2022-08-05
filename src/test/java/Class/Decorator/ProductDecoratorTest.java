package Class.Decorator;

import Class.Product.AbstractProduct;
import Class.Product.Hamburger;
import Class.Product.Pizza;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProductDecoratorTest {
    @Nested
    class DecoratorTestPizza{
        float price = 10.2f;
        float result;

        @DisplayName("Pizza creada con atributos especificos")
        @Test
        public void testCalculateCost() {
            AbstractProduct pizza = new Pizza("base", price, null);
            NeapolitanPizza neapolitanPizza = new NeapolitanPizza(pizza);
            CarbonaraPizza carbonaraPizza = new CarbonaraPizza(pizza);
            result = neapolitanPizza.calculateCost();
            assertEquals(pizza.getPrice() * 1.4f, result);
            result = carbonaraPizza.calculateCost();
            assertEquals(pizza.getPrice() * 1.3f, result);
        }

        @DisplayName("Pizza creada con atributos random")
        @Test
        public void testCalculateVariable() {
            Random rng = new Random();
            price = rng.nextFloat(0, 10);
            AbstractProduct pizza = new Pizza("base", price, null);
            NeapolitanPizza neapolitanPizza = new NeapolitanPizza(pizza);
            result = neapolitanPizza.calculateCost();
            assertEquals(pizza.getPrice() * 1.4f, result);
            CarbonaraPizza carbonaraPizza = new CarbonaraPizza(pizza);
            result = carbonaraPizza.calculateCost();
            assertEquals(pizza.getPrice() * 1.3f, result);
        }

    }

    @Nested
    class DecoratorTestHamburger {
        float price = 5.5f;
        float result;

        @DisplayName("Hamburguesa creada con atributos especificos")
        @Test
        public void testCalculateCost() {
            AbstractProduct hamburger = new Hamburger("normal", price, null);
            VegetarianHamburger vegetarianHamburger = new VegetarianHamburger(hamburger);
            RanchHamburger ranchHamburger = new RanchHamburger(hamburger);
            result = vegetarianHamburger.calculateCost();
            assertEquals(hamburger.getPrice() * 1.5f, result);
            result = ranchHamburger.calculateCost();
            assertEquals(hamburger.getPrice() * 1.2f, result);
        }

        @DisplayName("Hamburguesa creada con atributos random")
        @Test
        void testCalculatorVariable() {
            Random rng = new Random();
            price = rng.nextFloat(0, 10);
            AbstractProduct hamburger = new Hamburger("normal", price, null);
            VegetarianHamburger vegetarianHamburger = new VegetarianHamburger(hamburger);
            RanchHamburger ranchHamburger = new RanchHamburger(hamburger);
            result = vegetarianHamburger.calculateCost();
            assertEquals(hamburger.getPrice() * 1.5f, result);
            result = ranchHamburger.calculateCost();
            assertEquals(hamburger.getPrice() * 1.2f, result);
        }
    }
}