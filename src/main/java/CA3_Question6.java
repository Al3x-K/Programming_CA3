import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */

public class CA3_Question6
{
    public static void main(String[] args)
    {
        /*
        Will repeatedly ask the user to enter the commands in the format
        buy qty price
        or
        sell qty price
        or
        quit
        */

        Queue<Share> shares = new LinkedList<>(); //creates new queue for the shares
        Scanner scanner = new Scanner(System.in);
        String command = "";

        //loop for processing commands
        do
        {
            System.out.println("Enter command (buy (quantity) (price), sell (quantity) (price),quit)");
            System.out.print("> ");
            command = scanner.next();

            //buying shares
            if(command.equalsIgnoreCase("buy"))
            {
                int quantity = scanner.nextInt(); //read quantity of shares
                double price = scanner.nextDouble(); //read the price per share
                shares.offer(new Share(quantity,price)); //adds a share to the queue
            }
            //selling shares
            else if(command.equalsIgnoreCase("sell"))
            {
                int sellQTY = scanner.nextInt(); //read quantity of shares
                double sellPRICE = scanner.nextDouble(); //read the price per share
                double gain = sellShares(shares,sellQTY,sellPRICE); //calculates total gain from the sell
                System.out.println("Total gain: " + gain);
            }
        }while(!command.equalsIgnoreCase("quit")); //exits the loop when "quit" is entered
    }

    //method for calculating total profit from selling shares
    public static double sellShares(Queue<Share> shares, int sellQTY, double sellPRICE)
    {
        double totalGain = 0.0;

        //runs as long as the desired quantity is sold or as long as the queue is not empty
        while(sellQTY > 0 && !shares.isEmpty())
        {
            Share s1 = shares.peek(); //gets first share in the queue
            int avQty = s1.getQuantity(); //gets the available quantity of the share

            if(avQty <= sellQTY)
            {
                //sell all shares from the "block"
                double costPrice = s1.getPrice(); //purchase price per share
                totalGain += (sellPRICE - costPrice) * avQty; //calculate gain
                sellQTY -= avQty; //updates the quantity of the shares to sell in the queue
                shares.poll(); // removes sold shares
            }
            else
            {
                //selling partial shares as the available number is less than we want to sell
                double costPrice = s1.getPrice(); //price per share
                totalGain += (sellPRICE - costPrice) * sellQTY; //gain
                s1.setQuantity(s1.getQuantity() - sellQTY); //updates the number of shares that remained
                sellQTY = 0; //all shares got sold
            }
        }
        return totalGain;
    }
}
