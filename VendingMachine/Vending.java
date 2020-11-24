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
            System.out.printf("Name=%s", productList.get(i).getName());
        }
    }
}
