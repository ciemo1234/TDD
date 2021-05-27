import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;


public class MainTest {

    private static Rectangle rectangle1,
            rectangle2,
            rectangle3;
    private static Resolver res;

    @BeforeClass
    /**
     * Przygotowanie kwadratów
     */
    public static void init() {
        rectangle1 = new Rectangle(0, 0, 5, 5);
        rectangle2 = new Rectangle(1, 1, 3, 3);
        rectangle3 = new Rectangle(-1, -1, -1, 1);
        res = new ResolverImpl();
    }


    @Test
    /**
     * Posiadają wspólną płaszczyznę
     * Obliczanie części wpólnej
     */
    public void test1() {

        //Operacja
        double commonPart = res.calculateCommonPart(rectangle1, rectangle2);

        //Sprawdzenia
        Assert.assertEquals(commonPart, 9.0, 0.01);
    }

    @Test
    /**
     * Czy posiadają wspólną płaszczyzne
     * Wynik -> Posiadają
     */
    public void test2() {

        //Operacja
        boolean result = res.hasCommonPart(rectangle1, rectangle2);

        //Sprawdzenia
        Assert.assertTrue(result);
    }

    @Test
    /**
     * Czy posiadają wspólną płaszczyzne
     * Wynik -> Nie posiadają
     */
    public void test3() {

        //Operacja
        boolean result = res.hasCommonPart(rectangle2, rectangle3);

        //Sprawdzenia
        Assert.assertFalse(result);
    }
}
