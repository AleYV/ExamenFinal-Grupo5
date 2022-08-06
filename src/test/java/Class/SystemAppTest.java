package Class;

import Class.Branch.FastFoodBranch;
import Class.Decorator.CarbonaraPizza;
import Class.Decorator.NeapolitanPizza;
import Class.Decorator.RanchHamburger;
import Class.Decorator.VegetarianHamburger;
import Class.Factory.FastFoodBranchFactory;
import Class.Factory.HamburgerBranchFactory;
import Class.Factory.PizzaBranchFactory;
import Class.Menu.AbstractMenu;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;
import Class.Observer.MenuEditor;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SystemAppTest {

    int localCapacity;
    boolean autoPickUpOption, parkingLot, delivery;
    String address;
    AbstractMenu menu;
    FastFoodBranch newBranch;

    MenuEditor menuEditor = new MenuEditor();

    @DisplayName("Dado que se desea crear una nueva sucursal para la venta de pizzas")
    @Nested
    class PizzaTest{

        @BeforeEach
        void setUp(){
            localCapacity = 50;
            autoPickUpOption = parkingLot = delivery = true;
            address = "Somewhere";
            menu = new PizzaMenu(13);
            menu.generateMenu();
        }

        @Test
        @DisplayName("Con atributos especificos")
        void pizzaBranchSpecificValues(){
            newBranch = FastFoodBranchFactory.getBranch(new PizzaBranchFactory(
                    localCapacity, autoPickUpOption, address, parkingLot, delivery, menu));

            assertAll("Se verifica que se cumpla con todos los atributos especificados",
                    () -> assertEquals(50, newBranch.getLocalCapacity()),
                    () -> assertTrue(newBranch.hasAutoPickUpOption()),
                    () -> assertEquals("Somewhere", newBranch.getAddress()),
                    () -> assertTrue(newBranch.hasParkingLot()),
                    () -> assertTrue(newBranch.hasDelivery()),
                    () -> assertNotNull(newBranch.getMenu()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList()),
                    () -> assertEquals(13, newBranch.getMenu().getMenuList().size())
                    );

            menuEditor.manager.subscribe("pizza", newBranch.getMenu());
            String subMessage = menuEditor.addCombPizza("Pizza con piña", 10.0f, null);

            assertAll("Se suscribe al menu y se crea una pizza, se verifica que se agrego correctamente y se haya notificado",
                    () -> assertEquals(subMessage, "Se ah agregado un nuevo combo de pizza"),
                    () -> assertEquals(14, newBranch.getMenu().getMenuList().size()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList().get(13)),
                    () -> assertEquals("Pizza con piña", newBranch.getMenu().getMenuList().get(13).getName()),
                    () -> assertEquals(10.0f, newBranch.getMenu().getMenuList().get(13).getPrice()),
                    () -> assertNull(newBranch.getMenu().getMenuList().get(13).getImg())
                    );

            menuEditor.manager.unsubscribe("pizza", newBranch.getMenu());
            String unsubMessage = menuEditor.addCombPizza("Pizza Americana", 15.0f, null);
            assertAll("Se des suscribe al menu y se crea una pizza, se verifica que no se agregue ni se notifique",
                    () -> assertEquals(unsubMessage, ""),
                    () -> assertEquals(14, newBranch.getMenu().getMenuList().size())
                    );

            assertEquals(13.0f,
                    new CarbonaraPizza(newBranch.getMenu().getMenuList().get(13)).calculateCost(),
                    "Luego se decora el ultimo plato con Carbonara y se verifica su atributo decorado");

            assertEquals(14.0f,
                    new NeapolitanPizza(newBranch.getMenu().getMenuList().get(13)).calculateCost(),
                    "Luego se decora el ultimo plato con Neapolitan y se verifica su atributo decorado");
        }

        @DisplayName("Con atributos generados aleatoriamente, esta prueba se realiza 3 veces")
        @RepeatedTest(3)
        void pizzaBranchRandomValues(){
            Random rng = new Random();
            localCapacity = rng.nextInt(1, 100);
            autoPickUpOption = rng.nextBoolean();
            parkingLot = rng.nextBoolean();
            delivery = rng.nextBoolean();
            int menuLength = rng.nextInt(1, 20);
            menu = new PizzaMenu(menuLength);
            menu.generateMenu();

            newBranch = FastFoodBranchFactory.getBranch(new PizzaBranchFactory(localCapacity, autoPickUpOption, address,
                    parkingLot, delivery, menu));

            assertAll("Se verifica que se haya creado correctamente",
                    () -> assertEquals(localCapacity, newBranch.getLocalCapacity()),
                    () -> assertEquals(autoPickUpOption, newBranch.hasAutoPickUpOption()),
                    () -> assertEquals(address, newBranch.getAddress()),
                    () -> assertEquals(parkingLot, newBranch.hasParkingLot()),
                    () -> assertEquals(delivery, newBranch.hasDelivery()),
                    () -> assertNotNull(newBranch.getMenu()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList()),
                    () -> assertEquals(menuLength, newBranch.getMenu().getMenuList().size())
            );

            menuEditor.manager.subscribe("pizza", newBranch.getMenu());
            float price = rng.nextFloat(10.0f, 20.0f);
            String subMessage = menuEditor.addCombPizza("Pizza con piña", price, null);

            assertAll("Se suscribe al menu y se crea una pizza, se verifica que se agrego correctamente y se haya notificado",
                    () -> assertEquals(subMessage, "Se ah agregado un nuevo combo de pizza"),
                    () -> assertEquals((menuLength + 1), newBranch.getMenu().getMenuList().size()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList().get(menuLength)),
                    () -> assertEquals("Pizza con piña", newBranch.getMenu().getMenuList().get(menuLength).getName()),
                    () -> assertEquals(price, newBranch.getMenu().getMenuList().get(menuLength).getPrice()),
                    () -> assertNull(newBranch.getMenu().getMenuList().get(menuLength).getImg())
            );

            menuEditor.manager.unsubscribe("pizza", newBranch.getMenu());
            assertAll("Se des suscribe al menu y se crea una pizza, se verifica que no se agregue ni se notifique",
                    () -> assertEquals(menuEditor.addCombPizza("Pizza Americana", 15.0f, null), ""),
                    () -> assertEquals((menuLength + 1), newBranch.getMenu().getMenuList().size())
            );

            assertEquals((newBranch.getMenu().getMenuList().get(menuLength).getPrice() * 1.3f),
                    new CarbonaraPizza(newBranch.getMenu().getMenuList().get(menuLength)).calculateCost(),
                    "Luego se decora el ultimo plato con Carbonara y se verifica su atributo decorado");

            assertEquals((newBranch.getMenu().getMenuList().get(menuLength).getPrice() * 1.4f),
                    new NeapolitanPizza(newBranch.getMenu().getMenuList().get(menuLength)).calculateCost(),
                    "Luego se decora el ultimo plato con Neapolitan y se verifica su atributo decorado");
        }
    }

    @DisplayName("Dado que se desea crear una nueva sucursal para la venta de hamburguesas")
    @Nested
    class HamburgerTest{

        @BeforeEach
        void setUp(){
            localCapacity = 30;
            autoPickUpOption = false;
            parkingLot = delivery = true;
            address = "Another place";
            menu = new HamburgerMenu(16);
            menu.generateMenu();
        }

        @Test
        @DisplayName("Con atributos especificos")
        void hamburgerBranchSpecificValues(){
            newBranch = FastFoodBranchFactory.getBranch(new HamburgerBranchFactory(
                    localCapacity, autoPickUpOption, address, parkingLot, delivery, menu));

            assertAll("Se verifica que se cumpla con todos los atributos especificados",
                    () -> assertEquals(30, newBranch.getLocalCapacity()),
                    () -> assertFalse(newBranch.hasAutoPickUpOption()),
                    () -> assertEquals("Another place", newBranch.getAddress()),
                    () -> assertTrue(newBranch.hasParkingLot()),
                    () -> assertTrue(newBranch.hasDelivery()),
                    () -> assertNotNull(newBranch.getMenu()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList()),
                    () -> assertEquals(16, newBranch.getMenu().getMenuList().size())
            );

            menuEditor.manager.subscribe("hamburger", newBranch.getMenu());
            String subMessage = menuEditor.addCombHamburger("Hamburguesa con tocino", 10.0f, null);

            assertAll("Se suscribe al menu y se crea una hamburguesa, se verifica que se agrego correctamente y se haya notificado",
                    () -> assertEquals(subMessage, "Se ah agregado un nuevo combo de hamburguesa"),
                    () -> assertEquals(17, newBranch.getMenu().getMenuList().size()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList().get(16)),
                    () -> assertEquals("Hamburguesa con tocino", newBranch.getMenu().getMenuList().get(16).getName()),
                    () -> assertEquals(10.0f, newBranch.getMenu().getMenuList().get(16).getPrice()),
                    () -> assertNull(newBranch.getMenu().getMenuList().get(16).getImg())
            );

            menuEditor.manager.unsubscribe("hamburger", newBranch.getMenu());
            assertAll("Se des suscribe al menu y se crea una pizza, se verifica que no se agregue ni se notifique",
                    () -> assertEquals(menuEditor.addCombHamburger("Hamburguesa Extrema", 15.0f, null), ""),
                    () -> assertEquals(17, newBranch.getMenu().getMenuList().size())
            );

            assertEquals(12.0f,
                    new RanchHamburger(newBranch.getMenu().getMenuList().get(16)).calculateCost(),
                    "Luego se decora el ultimo plato con Ranch y se verifica su atributo decorado");

            assertEquals(15.0f,
                    new VegetarianHamburger(newBranch.getMenu().getMenuList().get(16)).calculateCost(),
                    "Luego se decora el ultimo plato con Vegetarian y se verifica su atributo decorado");
        }

        @DisplayName("Con atributos generados aleatoriamente, esta prueba se realiza 3 veces")
        @RepeatedTest(3)
        void pizzaBranchRandomValues(){
            Random rng = new Random();
            localCapacity = rng.nextInt(1, 100);
            autoPickUpOption = rng.nextBoolean();
            parkingLot = rng.nextBoolean();
            delivery = rng.nextBoolean();
            int menuLength = rng.nextInt(1, 20);
            menu = new HamburgerMenu(menuLength);
            menu.generateMenu();

            newBranch = FastFoodBranchFactory.getBranch(new HamburgerBranchFactory(localCapacity, autoPickUpOption, address,
                    parkingLot, delivery, menu));

            assertAll("Se verifica que se haya creado correctamente",
                    () -> assertEquals(localCapacity, newBranch.getLocalCapacity()),
                    () -> assertEquals(autoPickUpOption, newBranch.hasAutoPickUpOption()),
                    () -> assertEquals(address, newBranch.getAddress()),
                    () -> assertEquals(parkingLot, newBranch.hasParkingLot()),
                    () -> assertEquals(delivery, newBranch.hasDelivery()),
                    () -> assertNotNull(newBranch.getMenu()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList()),
                    () -> assertEquals(menuLength, newBranch.getMenu().getMenuList().size())
            );

            menuEditor.manager.subscribe("hamburger", newBranch.getMenu());
            String subMessage = menuEditor.addCombHamburger("Hamburguesa con tocino", 10.0f, null);

            assertAll("Se suscribe al menu y se crea una hamburguesa, se verifica que se agrego correctamente y se haya notificado",
                    () -> assertEquals(subMessage, "Se ah agregado un nuevo combo de hamburguesa"),
                    () -> assertEquals((menuLength + 1), newBranch.getMenu().getMenuList().size()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList().get(menuLength)),
                    () -> assertEquals("Hamburguesa con tocino", newBranch.getMenu().getMenuList().get(menuLength).getName()),
                    () -> assertEquals(10.0f, newBranch.getMenu().getMenuList().get(menuLength).getPrice()),
                    () -> assertNull(newBranch.getMenu().getMenuList().get(menuLength).getImg())
            );

            menuEditor.manager.unsubscribe("hamburger", newBranch.getMenu());
            assertAll("Se des suscribe al menu y se crea una pizza, se verifica que no se agregue ni se notifique",
                    () -> assertEquals(menuEditor.addCombHamburger("Hamburguesa Extrema", 15.0f, null), ""),
                    () -> assertEquals((menuLength + 1), newBranch.getMenu().getMenuList().size())
            );

            assertEquals((newBranch.getMenu().getMenuList().get(menuLength).getPrice() * 1.2f),
                    new RanchHamburger(newBranch.getMenu().getMenuList().get(menuLength)).calculateCost(),
                    "Luego se decora el ultimo plato con Ranch y se verifica su atributo decorado");

            assertEquals((newBranch.getMenu().getMenuList().get(menuLength).getPrice() * 1.5f),
                    new VegetarianHamburger(newBranch.getMenu().getMenuList().get(menuLength)).calculateCost(),
                    "Luego se decora el ultimo plato con Vegetarian y se verifica su atributo decorado");
        }
    }
}
