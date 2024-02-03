import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> stack = new Stack<>(); //stack for coordinates
        int count = 1; //number to fill the cells

        stack.push(new Pair(r,c)); // adds starting coordinates to the stack

        while(!stack.isEmpty()) //runs until stack is empty
        {
            Pair cur = stack.pop(); //pops current coordinates from the stack
            int row = cur.row;
            int col = cur.col;

            //checking if the cell is filled or not and if it's within the bounds of the array
            if(row >= 0 && row < 10 && col >= 0 && col <10 && arr[row][col] == 0)
            {
                arr[row][col] = count++; //fill the cell with the number

                //checking the neighbouring cells
                //NORTH
                if(row - 1 >= 0 && arr[row - 1][col] == 0)
                {
                    stack.push(new Pair(row - 1, col));
                }
                //EAST
                if(col + 1 < 10 && arr[row][col + 1] == 0)
                {
                    stack.push(new Pair(row,col + 1));
                }
                //SOUTH
                if(row + 1 < 10 && arr[row + 1][col] == 0)
                {
                    stack.push(new Pair(row + 1, col));
                }
                //WEST
                if(col - 1 >= 0 && arr[row][col - 1] == 0)
                {
                    stack.push(new Pair(row, col - 1));
                }
            } //NOTE ->  "10" in the if statements could be replaced with a variable
            // but in this example the array has a fixed size so the number can be used
        }
    }

    public static void start()
    {
        Scanner kb = new Scanner(System.in);
        int[][] arr = floodFillStart(); //creating the array
        System.out.println("Starting array: \n");
        display(arr); //displays the starting array filled with 0s
        System.out.println();
        //user decides where they want to start
        System.out.print("Enter starting row: ");
        int startRow = kb.nextInt();
        System.out.print("Enter starting colum: ");
        int startCol = kb.nextInt();
        fill(startRow,startCol,arr); //filling the array
        System.out.println();
        System.out.println("The array after filling: \n");
        display(arr); //displays filled array with different numbers
    }
    public static void main(String[] args)
    {
        start();
    }

    //class for the coordinates of row and column
    static class Pair
    {
        int row, col;

        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
}
