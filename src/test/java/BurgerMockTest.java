import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {

        private Burger burger;

        @Mock
        Bun bun;

        @Mock
        Ingredient firstIngredient;

        @Mock
        Ingredient secondIngredient;

        @Before
        public void setUp() {
            burger = new Burger();
        }

        @Test
        public void setBunsTest() {
            burger.setBuns(bun);
            assertEquals(bun, burger.bun);
        }

        @Test
        public void addIngredientTest() {
            burger.addIngredient(firstIngredient);
            assertTrue(burger.ingredients.contains(firstIngredient));
        }

        @Test
        public void removeIngredientTest() {
            burger.addIngredient(firstIngredient);
            burger.removeIngredient(0);

            assertEquals(0, burger.ingredients.size());
        }

        @Test
        public void moveIngredientTest() {

            burger.addIngredient(firstIngredient);
            burger.addIngredient(secondIngredient);

            burger.moveIngredient(0, 1);

            assertEquals(firstIngredient, burger.ingredients.get(1));
        }


}


