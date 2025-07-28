// Example 1:
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9

// Example 2:
// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6

// Example 3:
// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {


    public static int operation(int a , int b , String token){
        if(token.equals("+")){
            return a+b;
        }

        if(token.equals("-")){
            return a-b;
        }
         if(token.equals("*")){
            return a*b;
        }
         if(token.equals("/")){
            return a/b;
        }

        return -1;

    }

    public static int answer(String [] tokens){
        Stack<Integer> stack = new Stack<>();
        // loop over array 
        for(String token : tokens){
            if(token.equals("+") 
            || token.equals("-")
            || token.equals("*")
            || token.equals("/"))
            {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = operation(num2, num1, token);
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String [] tokens = {"2","1","+","3","*"};
        int calculation = answer(tokens);
        System.out.println("calculation is : "+calculation);
    }
}
