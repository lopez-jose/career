import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class VendingMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program simulates a vending machine");

        ArrayList<Product> items = new ArrayList<Product>();
        HashMap<String, Integer> coinMap = new HashMap<String, Integer>();
        HashMap<String, Product> productMap = new HashMap<String, Product>();

        coinMap.put("penny", 1);
        coinMap.put("nickel", 5);
        coinMap.put("dime", 10);
        coinMap.put("quarter", 25);

        Product coke = new Product("Coke", 25, 10);
        Product pepsi = new Product("Pepsi", 35, 10);
        Product soda = new Product("Soda", 45, 10);

        productMap.put("coke", coke);
        productMap.put("pepsi", pepsi);
        productMap.put("soda", soda);

        items.add(coke);
        items.add(pepsi);
        items.add(soda);

        Vending a = new Vending(3, items);
        Vending.printProducts(items);

        System.out.println("Enter some money.");
        boolean reachedPrice = false;
        int totalEntered = 0;
        String userInput = "";

        while (!reachedPrice) {
            System.out.printf("Entered: $%d%n", totalEntered);
            userInput = input.nextLine();
            if (coinMap.containsKey(userInput))
                totalEntered += coinMap.get(userInput);
            if (productMap.containsKey(userInput)) {
                if (totalEntered > productMap.get(userInput).getPrice()) {
                    reachedPrice = true;
                }
            }
        }
        System.out.println("You have enough money to order a " + userInput);
        input.close();

    }

}