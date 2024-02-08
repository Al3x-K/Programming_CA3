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
        System.out.print("Enter equation: ");
        equation = scanner.nextLine().trim(); //removes whitespaces from both sides of the string

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
            if (ch == ' ')
            {
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
        double num2 = numbers.pop(); //pop the 2nd number
        double num1 = numbers.pop(); //pop the 1st number
        char operator = operators.pop(); //pop the operator
        double result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0.0;

            //Performs adequate operation based on the operator
            //add, subtract, multiply, divide
        };

        numbers.push(result); //push the result onto the stack
    }

    public static int precedence(char operator)
    {
        if(operator == '+' || operator == '-')
        {
            return 1;
        }
        else if (operator == '*' || operator == '/')
        {
            return 2;
        }
        else
        {
            return 0; //'(' has the lowest precedence out of all operators
        }
    }
}
