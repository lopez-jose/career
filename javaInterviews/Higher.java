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
        return x > y ? x : y;
    }
}
