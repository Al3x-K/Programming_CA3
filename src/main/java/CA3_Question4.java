import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name:Aleksandra Kail
 *  Class Group: GD2B
 */
public class CA3_Question4
{

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        boolean valid = false;
        Scanner scanner = new Scanner(new File(filename)); //Read tags from the file
        String [] tags = scanner.nextLine().split(" "); //puts tags into the array and split them by space

        Stack<String> stack = new Stack<>(); //a stack for opening tags
        for(String tag : tags) //goes through each tag in the array
        {
            stack.push(tag);
            if(tag.startsWith("</")) //checks if it's a closing tag
            {
                String opTag = stack.pop();
                //checks if the closing tag matches the tag at the top of the stack
                if(!tag.substring(2, tag.length() - 1).equals(opTag.substring(1, tag.length())))
                {
                    stack.pop();
                    if(stack.isEmpty())
                        valid = true;
                }
            }
        }
        return valid;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException
    {
        String[] files = {"tags_valid.txt","tags_invalid.txt"};

        for(String fName: files)
        {
            System.out.print(fName +": ");
            if (validate(fName))
            {
                System.out.println("This file is valid");
            }
            else
            {
                System.out.println("This file is invalid");
            }
        }
    }
}

