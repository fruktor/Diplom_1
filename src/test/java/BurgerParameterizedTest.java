import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private Burger burger;
    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public BurgerParameterizedTest(String bunName, float bunPrice, IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;

    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Булочка с кунжутом", 100f, IngredientType.SAUCE, "Соус Барбекю", 20f},
                {"Ржаная булочка", 150f, IngredientType.FILLING, "Котлета из говядины", 70f}
        });
    }

    @Test
    public void getPriceTest() {

        Bun bun = new Bun(bunName, bunPrice);
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = bunPrice * 2 + ingredientPrice;

        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void getReceiptTest() {

        Bun bun = new Bun(bunName, bunPrice);
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expected = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%n" +
                        "Price: %.6f%n",
                bunName,
                ingredientType.toString().toLowerCase(),
                ingredientName,
                bunName,
                bunPrice * 2 + ingredientPrice
        );

        assertEquals(expected, burger.getReceipt());

    }
}
