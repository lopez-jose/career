
/*
* 
* * 
* * * 
* * * * 
* * * * * 

Write a program that can print the above pattern
*/
import java.util.Scanner;

public class PrintPatterns {
    public static void main(String[] args) {

        int pyramidHeight;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the height of the pyramid");

        pyramidHeight = input.nextInt();

        printPyramid(pyramidHeight);
        input.close();

    }

    public static void printPyramid(int height) {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int p = 0; p <= i; p++) {
                System.out.print("* ");
            }
        }
        System.out.println();
    }
}
