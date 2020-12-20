import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Higher {
    public static void main(String[] args) {
        int a = 25;
        int b = -25;

        int c = higher(a, b);
        System.out.printf("The higher of %d and %d is %d", a, b, c);
    }

    /**
     * 
     * 
     * 
     * @param x
     * @param y @ return the higher of the two values
     */
    public static int higher(int x, int y) {
        if (x > y) {
            return x;

        } else {
            return y;
        }
    }

    @Test
    public void testHigher() {
        assertEquals(25, higher(25, 25));
        assertEquals(5, higher(3, 5));
    }
}
