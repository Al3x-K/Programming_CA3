import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */
public class CA3_Question1 
{
    public static void runSimulation()
    {
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> driveway = new Stack<>(); //Creating a stack for parked cars
        Stack<Integer> street = new Stack<>(); //Creating a stack for the street aka temporally parking
        int num; //car number for adding/retrieving
        //the loop will run as long as the user doesn't type 0
        do
        {
            //menu with options
            System.out.println("Positive number -> park the car in the driveway");
            System.out.println("Negative number -> retrieve the car");
            System.out.println("0 -> Exit the application");
            System.out.print("Choose the option: ");
            num = keyboard.nextInt();
            System.out.println(); //printing an empty line for aesthetic
            if(num > 0)
            {
                driveway.push(num); //adds the car to the stack
                System.out.println("Added car " + num + " to the driveway.");
                System.out.println("The driveway -> " + driveway);
            }
            else if(num < 0)
            {
                num = num * -1; //changes the number from negative to positive, as the driveway stack only contains positive numbers
                if(driveway.contains(num)) //checks if the number is in the stack
                {
                    System.out.println("Retrieving car " + num + ".");
                    while(!driveway.isEmpty() && driveway.peek() != num) //runs as long as the driveway stack is not empty and the top value is not the same as the number of the car that we want to retrieve
                    {
                        int n = driveway.pop(); //deletes the top value of the driveway stack
                        street.push(n); //adds the value deleted from the other stack
                        System.out.println("Moved car " + n + " to the street.");
                        System.out.println("The street -> " + street);
                    }
                    int rCar = driveway.pop();
                    System.out.println("Car " + rCar + " retrieved from the driveway.");
                    System.out.println("The driveway -> " + driveway);

                    while (!street.isEmpty()) //runs as long as the street is not empty
                    {
                        int n1 = street.pop(); //deletes the top value of the street stack
                        driveway.push(n1); //adds the value back to the driveway stack
                        System.out.println("Moved car " + n1 + " back to the driveway.");
                    }
                    System.out.println("Driveway after moving cars -> " + driveway);
                }
                else {
                    System.out.println("Car " + num + " not found in the driveway.");
                }
            }
        } while(num != 0);
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
