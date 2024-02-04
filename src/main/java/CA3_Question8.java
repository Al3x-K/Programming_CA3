import java.util.Stack;
import java.util.Scanner;
/**
 *  Name: Aleksandra Kail
 *  Class Group: GD2B
 */
public class CA3_Question8
{
    /*
        Reads in the equation from the user
     */
    public static void main (String[] args)
    {
        String equation;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter equation: ");
        equation = scanner.nextLine().trim();

        //evaluate the equation and print the result
        double result = evaluate(equation);
        System.out.println("Result: " + result);
    }

    public static double evaluate(String equation) {
        //stack for numbers and operators
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        //runs through the whole equation evaluating each character
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            //skipping white spaces
            if (ch == ' ') {
                continue;
            }
            //handling opening brackets
            else if (ch == '(') {
                operators.push(ch);
            }
            //handling numbers
            else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder(); //it reads the whole number, including the decimal part
                while (i < equation.length() && (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.')) {
                    sb.append(equation.charAt(i++));
                }
                i--; //adjusts the index so the next character is handled properly
                numbers.push(Double.parseDouble(sb.toString())); //pushes the number onto the stack
            }
            //handling closing brackets
            else if (ch == ')') {
                //check for the "("
                while (operators.peek() != '(') {
                    performOperation(numbers, operators);
                }
                operators.pop(); //removes '(' from the stack
            }
            //handling the (+,-,*,/) operators
            else {
                //process operators based on their order in math
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    performOperation(numbers, operators);
                }
                operators.push(ch); //push the current operator onto the stack
            }
        }
        //remaining operators
        while(!operators.isEmpty())
        {
            performOperation(numbers,operators);
        }
        return numbers.pop();
    }

    public static void performOperation(Stack<Double> numbers, Stack<Character> operators)
    {

    }

    public static int precedence(char operator)
    {
        return operator;
    }
}
