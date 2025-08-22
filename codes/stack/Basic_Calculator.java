// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

// Example 1:
// Input: s = "1 + 1"
// Output: 2

// Example 2:
// Input: s = " 2-1 + 2 "
// Output: 3

// Example 3:
// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23

import java.util.Stack;

public class Basic_Calculator{

    public static int calculate(String s ){

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num *10 + (ch -'0');
            }
            else if ( ch == '+'){
                result += (sign * num);
                num = 0;
                sign = 1;
            }
            else if ( ch == '-'){
                result += (sign * num);
                num = 0;
                sign = -1;
            }
            else if ( ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            }
            else if ( ch == ')'){

                result += (sign * num);
                num = 0;
               int prevsign = stack.pop();
               int  prevresult = stack.pop();
            
               result = prevresult + (result * prevsign);
               
            }
        }

        if(num != 0){
            result += (sign * num);
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        // String s = "2-1 + 2";
        int result = calculate(s);
        System.out.println("calculation is : "+result);
    }
}