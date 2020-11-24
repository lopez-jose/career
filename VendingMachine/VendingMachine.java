import java.util.ArrayList;

public class VendingMachine {

    public static void main(String[] args) {
        System.out.println("This program simulates a vending machine");

        ArrayList<Product> items = new ArrayList<Product>();
        Product coke = new Product("Coke", 25, 10);

        items.add(coke);
        Vending a = new Vending(3, items);
        Vending.printProducts(items);

    }
}