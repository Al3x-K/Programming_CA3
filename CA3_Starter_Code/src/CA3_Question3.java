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

    }

    public static void main(String[] args) throws FileNotFoundException
    {
        readFile("src/CA3_Question1.java");
    }
}
