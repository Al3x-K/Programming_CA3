import java.util.Scanner;
import java.util.Stack;

public class q1v2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> driveway = new Stack<Integer>(); //Creating a stack for parked cars
        Stack<Integer> street = new Stack<Integer>(); //Creating a stack for cars retrieved

        int num;
        do
        {
            System.out.println("Positive number -> park the car in the driveway");
            System.out.println("Negative number -> retrieve the car");
            System.out.println("0 -> Exit the application");
            System.out.print("Choose the option: ");
            num = keyboard.nextInt();

            if(num > 0)
            {
                driveway.push(num);
                System.out.println("Driveway -> " + driveway);
            }
            else if(num < 0)
            {
                num = num * -1;
                int top = driveway.peek();

                while(top != num)
                {
                    int n = driveway.pop();
                    if(!driveway.isEmpty())
                    {
                        driveway.pop();
                        System.out.println("Driveway -> " + driveway);
                        street.push(n);
                        System.out.println("Street -> " + street);
                    }
                    else
                        break;
                }
                while(!street.isEmpty())
                {
                    driveway.push(street.pop());
                    System.out.println("The driveway -> " + driveway);
                    System.out.println("Street -> " + street);
                }
            }
        }while(num != 0);
    }
}
