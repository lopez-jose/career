import java.util.ArrayList;
import java.util.Scanner;

public class VendingMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program simulates a vending machine");

        ArrayList<Product> items = new ArrayList<Product>();
        Product coke = new Product("Coke", 25, 10);
        Product pepsi = new Product("Pepsi", 35, 10);
        Product soda = new Product("Soda", 45, 10);

        items.add(coke);
        items.add(pepsi);
        items.add(soda);

        Vending a = new Vending(3, items);
        Vending.printProducts(items);

        System.out.println("What would you like to order?");

        input.close();

    }

}