import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException
    {
        //open the file
        Scanner fin = new Scanner(new File(fileName));
        //creates map storing identifiers and their occurrences
        Map<String, HashSet<Integer>> map = new TreeMap<>();
        int line = 1; //line number counter

        while(fin.hasNextLine()) //reading each line from the file
        {
            Scanner scanner = new Scanner(fin.nextLine());
            scanner.useDelimiter("[^A-Za-z0-9_]+");
            while(scanner.hasNext())
            {
                String token = scanner.next();
                //check if the identifier exists in the map, if yes, add the number of current line to the set
                if(!map.containsKey(token))
                {
                    map.put(token,new HashSet<>());
                }
                map.get(token).add(line);
            }
            line++; //increment line counter
        }
        //printing the index of identifier and their line numbers
        for (Map.Entry<String, HashSet<Integer>> entry : map.entrySet())
        {
            System.out.print(entry.getKey() + ": ");
            for(int num : entry.getValue())
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws FileNotFoundException
    {
        readFile("testCopy.java");
    }
}
