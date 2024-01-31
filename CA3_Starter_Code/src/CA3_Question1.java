import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */
public class CA3_Question1 extends Pair
{
    public static void runSimulation()
    {
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> driveway = new Stack<Integer>(); //Creating a stack for parked cars
        Stack<Integer> street = new Stack<Integer>(); //Creating a stack for cars retrieved
        int num;
        int currentNum;
        do
        {
            System.out.println("Positive number -> park the car in the driveway");
            System.out.println("Negative number -> retrieve the car");
            System.out.println("0 -> Exit the application");
            System.out.print("Choose the option: ");
            num = keyboard.nextInt();
            currentNum = num;
            if(num > 0)
            {
                driveway.push(num);
                System.out.println("The driveway -> " + driveway);
            }
            else if(num < 0)
            {
                num = num * -1;
                if(driveway.contains(num))
                {

                        int n = driveway.pop();
                        if (num != n)
                        {
                            street.push(n);
                            System.out.println("The street -> " + street);
                        }

                        while (!street.isEmpty()) {
                            driveway.push(street.pop());
                            System.out.println("The driveway -> " + driveway);
                        }

                }
            }
        } while(num != 0);
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
