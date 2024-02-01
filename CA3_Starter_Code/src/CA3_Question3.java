import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner fin = new Scanner(new File(fileName));

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");

        Map<String, HashSet<Integer>> map = new TreeMap<>();

    }
}
