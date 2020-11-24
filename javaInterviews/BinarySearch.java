import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program uses binary search to look for an element in the array.");

        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        System.out.println("Input Value to look for");
        int toFind = input.nextInt();

        System.out.println("Value is found at" + returnElement(array, toFind));
    }

    public static int returnElement(int array[], int n) {

        boolean elementExists = true;
        int start = 0;
        int end = array.length;
        int middle = end / 2;
        // We first begin with starting at 0 and ending at array length

        while (elementExists) {

            if (n == array[middle]) {
                return middle;
            }
            if (n > array[middle]) {
                start = middle;
                middle = (start + end) / 2;

            } else {
                end = middle;
                middle = (start + end) / 2;
            }
            if (middle == start || middle == end) {
                elementExists = false;
            }
            System.out.printf("Start = %d, Middle = %d, End = %d%n", start, middle, end);

        }

        return -1;
    }

}
