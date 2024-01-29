import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */
public class CA3_Question2 {
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][] floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image
     */
    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void fill(int r, int c, int[][] arr) {
        Stack<Pair> cell = new Stack<Pair>();
        int count = 1;
        while (!cell.isEmpty())
        {
            Pair current = cell.pop();
            int x = current.getX();
            int y = current.getY();
            arr[x][y] = count;
            count++;
        }
    }

    public static void start() {
        int[][] arr = floodFillStart();
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }
}

