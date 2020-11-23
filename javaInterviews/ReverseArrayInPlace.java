import java.util.ArrayList;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("This program reverses an array in place");

        list.add(2);
        list.add(1);
        list.add(3);

        System.out.println("Arraylist = " + reversedList(list));

    }

    public static ArrayList reversedList(ArrayList<Integer> a) {
        // ArrayList<Integer> b = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(a.size() - i - 1);
            a.set(a.size() - i - 1, a.get(i));
            a.set(i, temp);
        }
        return a;
    }
}
