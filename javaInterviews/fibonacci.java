
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println(fibonacci_n_recursive(5));
        System.out.println(fibonacci_n(5));

    }

    public static int fibonacci_n(int n) {
        int fib_0 = 1;
        int fib_1 = 1;
        int temp;

        for (int i = 0; i <= n - 2; i++) {
            temp = fib_0;

            fib_0 = fib_1;
            fib_1 = temp + fib_0;
        }
        return fib_1;
    }

    public static int fibonacci_n_recursive(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return (fibonacci_n_recursive(n - 1) + fibonacci_n_recursive(n - 2));
    }
}