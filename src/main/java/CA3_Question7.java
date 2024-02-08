import java.util.*;
/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */

public class CA3_Question7
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

        Map<String,Queue<Share>> stockMap = new HashMap<>(); //map to manage shares and stock symbols
        Scanner scanner = new Scanner(System.in);
        String command;

        //loop for processing commands
        do
        {
            System.out.println("Enter command (buy (symbol) (quantity) (price), sell (symbol) (quantity) (price), quit)");
            System.out.print("> ");
            command = scanner.next();

            //buying shares
            if(command.equalsIgnoreCase("buy"))
            {
                String symbol = scanner.next(); //read stock symbol
                int quantity = scanner.nextInt(); //read quantity of shares
                double price = scanner.nextDouble(); //read the price per share
                buyShares(stockMap,symbol,quantity,price); //buy shares
            }
            //selling shares
            else if(command.equalsIgnoreCase("sell"))
            {
                String symbol = scanner.next();
                int sellQTY = scanner.nextInt(); //read quantity of shares
                sellShares(stockMap,symbol,sellQTY); //sell shares
            }
        }while(!command.equalsIgnoreCase("quit")); //exits the loop when "quit" is entered
    }

    //buying shares
    public static void buyShares(Map<String, Queue<Share>> stockMap, String symbol, int quantity, double price)
    {
        stockMap.putIfAbsent(symbol, new LinkedList<>()); //adds a queue for the stock if there wasn't one before
        stockMap.get(symbol).offer(new Share(quantity,price)); //adds a share to the queue
    }

    //selling shares
    public static void sellShares(Map<String, Queue<Share>> stockMap, String symbol, int sellQTY)
    {
        //checks if a particular kind of stock already exists
        if(!stockMap.containsKey(symbol))
        {
            System.out.println("No shares of " + symbol +" available to sell."); //no shares of such symbol
        }

        Queue<Share> shares = stockMap.get(symbol); //get queue of shares for stock symbol
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
                totalGain += (sellQTY * costPrice); //calculates the gain
                sellQTY -= avQty; //updates the quantity of the shares to sell in the queue
                shares.poll(); // removes sold shares
            }
            else
            {
                //selling partial shares as the available number is more than we want to sell
                double costPrice = s1.getPrice(); //price per share
                totalGain += (sellQTY * costPrice); //gain
                s1.setQuantity(avQty - sellQTY); //updates the number of shares that remained
                sellQTY = 0; //all shares got sold
            }
        }
        System.out.println("Total gain from selling " + symbol + " shares: " + totalGain);
    }
}
