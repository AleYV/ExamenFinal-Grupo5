package Class.Factory;

import Class.Branch.FastFoodBranch;
import Class.Menu.AbstractMenu;
import Class.Menu.HamburgerMenu;
import Class.Menu.PizzaMenu;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FastFoodBranchFactoryTest {
    int localCapacity;
    boolean autoPickUpOption, parkingLot, delivery;
    String address;
    AbstractMenu menu;

    FastFoodBranch newBranch;

    @DisplayName("Dado que se desea crear una nueva sucursal para la venta de pizzas")
    @Nested
    class CreatePizzaBranchTest{
        @BeforeEach
        void setUp(){
            localCapacity = 30;
            autoPickUpOption = parkingLot = delivery = true;
            address = "A wholesome address";
            menu = new PizzaMenu(9);
            menu.generateMenu();
        }

        @Test
        @DisplayName("Creado con atributos especificados")
        void pizzaBranchWithAllOptions(){
            newBranch = FastFoodBranchFactory.getBranch(new PizzaBranchFactory(localCapacity, autoPickUpOption,
                    address,parkingLot, delivery, menu));

            assertAll("Se verifica que se cumpla con todos los atributos especificados",
                    () -> assertEquals(30, newBranch.getLocalCapacity()),
                    () -> assertTrue(newBranch.hasAutoPickUpOption()),
                    () -> assertEquals("A wholesome address", newBranch.getAddress()),
                    () -> assertTrue(newBranch.hasParkingLot()),
                    () -> assertTrue(newBranch.hasDelivery()),
                    () -> assertNotNull(newBranch.getMenu()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList()),
                    () -> assertEquals(9, newBranch.getMenu().getMenuList().size())
            );
        }

        @DisplayName("Creado con atributos aleatorios, esta prueba se realiza 5 veces")
        @RepeatedTest(5)
        void pizzaBranchWithRandomOptions(){
            Random rng = new Random();
            localCapacity = rng.nextInt(1, localCapacity);
            autoPickUpOption = rng.nextBoolean();
            parkingLot = rng.nextBoolean();
            delivery = rng.nextBoolean();
            int menuLength = rng.nextInt(1, 10);
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
        }
    }

    @DisplayName("Dado que se desea crear una nueva sucursal para la venta de hamburguesas")
    @Nested
    class CreateHamburgerBranchTest{
        @BeforeEach
        void setUp(){
            localCapacity = 20;
            autoPickUpOption = parkingLot = false;
            delivery = true;
            address = "Another wholesome address";
            menu = new HamburgerMenu(7);
            menu.generateMenu();
        }

        @Test
        @DisplayName("Creado con atributos especificados")
        void hamburgerBranchWithAllOptions(){
            newBranch = FastFoodBranchFactory.getBranch(new HamburgerBranchFactory(localCapacity, autoPickUpOption,
                    address,parkingLot, delivery, menu));

            assertAll("Se verifica que se cumpla con todos los atributos especificados",
                    () -> assertEquals(20, newBranch.getLocalCapacity()),
                    () -> assertFalse(newBranch.hasAutoPickUpOption()),
                    () -> assertEquals("Another wholesome address", newBranch.getAddress()),
                    () -> assertFalse(newBranch.hasParkingLot()),
                    () -> assertTrue(newBranch.hasDelivery()),
                    () -> assertNotNull(newBranch.getMenu()),
                    () -> assertNotNull(newBranch.getMenu().getMenuList()),
                    () -> assertEquals(7, newBranch.getMenu().getMenuList().size())
            );
        }

        @DisplayName("Creado con atributos aleatorios, este prueba se realiza 5 veces")
        @RepeatedTest(5)
        void hamburgerBranchWithRandomOptions(){
            Random rng = new Random();
            localCapacity = rng.nextInt(1, 100);
            autoPickUpOption = rng.nextBoolean();
            parkingLot = rng.nextBoolean();
            delivery = rng.nextBoolean();
            int menuLength = rng.nextInt(1, 10);
            menu = new HamburgerMenu(menuLength);
            menu.generateMenu();

            newBranch = FastFoodBranchFactory.getBranch(new HamburgerBranchFactory(localCapacity, autoPickUpOption,
                    address, parkingLot, delivery, menu));

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
        }
    }
}