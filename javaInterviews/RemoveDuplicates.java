import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println("This program removes duplicates in a array");
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(1);
        list.add(2);

        System.out.println("The Original Array = " + list);

        Set<Integer> listWithoutDuplicates = new LinkedHashSet<Integer>(list);
        list.clear();

        list.addAll(listWithoutDuplicates);

        System.out.println("The Original Array without duplicates" + listWithoutDuplicates);
    }

}
