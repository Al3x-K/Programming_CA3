import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
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
            System.out.println("Enter a command (takeoff symbol, land, symbol, next, quit");
            String command = keyboard.nextLine();

            //splitting commands into parts
            String[] com = command.split(" ");

            //processing takeoff and landing commands
            if(com.length == 2 && (com[0].equals("takeoff")|| com[0].equals("land")))
            {
                String symbol = com[1];
                if(com[0].equals("takeoff"))
                {
                    takeOff.offer(symbol);
                    System.out.println("Flight " + symbol + " is queued for takeoff.");
                }
                //queue for landing
                //the same code but with landing variables
                //add else if for "next" command
                //check if the landing queue is empty
                //if not assign landing.poll() to a variable
                //print out which flight is landing
                //same for takeoff
                //print a message if no flight are to be queued
                //process quit command
                //write an error message in case of invalid entry
            }
        }
    }
}
