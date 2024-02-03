import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        //queues for the planes
        Queue<String> takeOff = new LinkedList<>();
        Queue<String> landing = new LinkedList<>();

        Scanner keyboard = new Scanner(System.in);
        boolean q = false;

        //the loop that process all user commands
        while(!q)
        {
            System.out.println("Enter a command (takeoff symbol, land symbol, next, quit)");
            String command = keyboard.nextLine();

            //splitting commands into parts
            String[] com = command.split(" ");

            //processing takeoff and landing commands
            if(com.length == 2 && (com[0].equals("takeoff")|| com[0].equals("land"))) {
                String symbol = com[1];
                if (com[0].equals("takeoff"))
                {
                    takeOff.offer(symbol); //adds a flight to the take off queue
                    System.out.println(symbol + " is queued for takeoff.");
                }
                else
                {
                    landing.offer(symbol); //adds a flight to the landing queue
                    System.out.println(symbol + " is queued for landing.");
                }
            }
            //processing next command
            else if(command.equals("next"))
            {
                if(!landing.isEmpty())//runs only if the queue isn't empty
                {
                    String f = landing.poll(); //removes the flight out of the queue
                    System.out.println(f + " is landing.");
                }
                else if (!takeOff.isEmpty())//again runs only if there are flight queued for take off
                {
                    String f = takeOff.poll(); //removes the flight out of the queue
                    System.out.println(f + " is taking off.");
                }
                else
                {
                    System.out.println("No flight in the queue.");
                }
            }
            //processing quit command
            else if(command.equals("quit"))
            {
                q = true; //exit the loop
            }
            else
            {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}

