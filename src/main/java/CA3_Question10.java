import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */

public class CA3_Question10
{
    public static void main(String[] args)
    {
        try
        {
            //read input from the file
            Scanner scanner = new Scanner(new File("routes.txt"));
            String startP = "Pendleton";//starting point for calculating the distance

            //map for direct connections between cities
            Map<String, Set<DistanceTo>> connections = new HashMap<>();

            //read routes from the file and put them into the map
            while(scanner.hasNext())
            {
                //the variables in the file are in a form of:
                //city1 city2 distance
                String line = scanner.nextLine();
                System.out.println(line);
                String[] data = line.split(" ");
                String city1 = data[0];
                String city2 = data[1];
                String distance = data[2];

                //convert the string to int
                int dis = Integer.parseInt(distance);

                //city1 -> city2 connection:
                //if city1 is already in the map, it returns the TreeSet with its connections
                //if city1 is not in the map, it creates a new TreeSet for it
                //then it adds a new DistanceTo object to the TreeSet that it got from the 1st part
                connections.computeIfAbsent(city1, k -> new HashSet<>()).add(new DistanceTo(city2,dis));

                //city2 -> city1 connection (assuming that we can move both directions)
                //works the same as adding the previous connection
                connections.computeIfAbsent(city2, k -> new HashSet<>()).add(new DistanceTo(city1,dis));
            }
            
            //To get the actual shortest distance possible I'll use Dijkstra's algorithm
            //1. Start from Node 0
            //2. Check for adjacent Nodes and choose Node with minimum distance. Add up the distance
            //3. Move to the next Node and check for adjacent Nodes again
            //4. Repeat until the all Nodes were 'visited'
            Map<String, Integer> shortestDistance = new HashMap<>(); //map for the shortest known distances
            PriorityQueue<DistanceTo> pQueue = new PriorityQueue<>(); //queue for processing cities with the shortest known distance
            pQueue.offer(new DistanceTo(startP,0)); //adds starting point to the queue (the distance is 0)

            while(!pQueue.isEmpty()) //runs until all cities were processed
            {
                DistanceTo cur = pQueue.poll(); //get city with the shortest known distance
                String curCity = cur.getTarget(); //get name of the current city
                int currDist = cur.getDistance(); //get the shortest known distance to current city

                //if the shortest distance is yet to be known, update it and explore connections
                if(!shortestDistance.containsKey(curCity))
                {
                    shortestDistance.put(curCity,currDist); //update the distance

                    //check direct connections from the current city and update the queue
                    Set<DistanceTo> directConn = connections.getOrDefault(curCity, new TreeSet<>());

                    //getOrDefault():
                    // -> returns the value to which the specified key is associated
                    // -> returns the specified defaultValue if the mapping for specified key is not found

                    for (DistanceTo conn : directConn)
                    {
                        int newDist = currDist + conn.getDistance(); //calculate new distance
                        pQueue.offer(new DistanceTo(conn.getTarget(),newDist)); //adds connection to the queue
                        System.out.println(curCity+" "+ conn.getTarget() + " " + newDist);
                    }
                }
            }
            //print shortest distances to all cities
            for(Map.Entry<String,Integer> entry : shortestDistance.entrySet())
            {
                System.out.println("Shortest distance from " + startP + " to " + entry.getKey() + ": " + entry.getValue());
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}
