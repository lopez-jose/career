import java.util.ArrayList;
import java.util.Scanner;

import java.util.HashMap;

public class VendingMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program simulates a vending machine");

        ArrayList<Product> productList = new ArrayList<Product>();
        HashMap<String, Integer> coinMap = new HashMap<String, Integer>();
        HashMap<String, Product> productMap = new HashMap<String, Product>();

        coinMap.put("penny", 1);
        coinMap.put("nickel", 5);
        coinMap.put("dime", 10);
        coinMap.put("quarter", 25);

        Product coke = new Product("coke", 25, 10);
        Product pepsi = new Product("pepsi", 35, 10);
        Product soda = new Product("soda", 45, 10);

        productMap.put("coke", coke);
        productMap.put("pepsi", pepsi);
        productMap.put("soda", soda);

        productList.add(coke);
        productList.add(pepsi);
        productList.add(soda);

        Vending a = new Vending(3, productList);
        Vending.printProducts(productList);

        System.out.println("Enter some money. Type 'refund' to cancel");
        boolean reachedPrice = false;
        int totalEntered = 0;
        String userInput = "";

        while (!reachedPrice) {
            System.out.printf("Entered: %d cents%n", totalEntered);
            userInput = input.nextLine();
            if (userInput.equals("refund")) {
                reachedPrice = true;
                System.out.println("You have requested a refund. Have a good day!");

            }
            if (coinMap.containsKey(userInput))
                totalEntered += coinMap.get(userInput);
            if (productMap.containsKey(userInput)) {
                if (totalEntered >= productMap.get(userInput).getPrice()) {
                    reachedPrice = true;

                } else {
                    System.out.printf("Not enough money for a %s!!!%n", userInput);
                }
            }
        }
        System.out.println("You have purchased a " + userInput);
        for (int i = 0; i < a.productList.size(); i++) {
            if (a.productList.get(i).getName().equals(userInput)) {
                System.out.println("Matches");
                a.productList.get(i).setQuantity(a.productList.get(i).getQuantity() - 1);
                totalEntered = a.productList.get(i).getPrice();
                System.out.printf("Here is %d cents change", totalEntered);
            }
        }
        Vending.printProducts(productList);

        input.close();

    }

}