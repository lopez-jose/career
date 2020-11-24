import java.util.ArrayList;

public class Vending {
    int amount;
    ArrayList<Product> productList;

    public Vending(int amount, ArrayList<Product> productList) {
        this.amount = amount;
        this.productList = productList;
    }

    public static void printProducts(ArrayList<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            Product temp = productList.get(i);
            System.out.printf("Name=%s\tPrice=%d\tQuantity=%d%n", temp.getName(), temp.getPrice(), temp.getQuantity());
        }
    }
}
