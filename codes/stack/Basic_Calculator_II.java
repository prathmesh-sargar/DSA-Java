// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

// Example 1:
// Input: s = "3+2*2"
// Output: 7

// Example 2:
// Input: s = " 3/2 "
// Output: 1

// Example 3:
// Input: s = " 3+5 / 2 "
// Output: 5

import java.util.Stack;

public class Basic_Calculator_II {

 
     public static int calculate(String s){

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char opr = '+';

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num *10 +(ch-'0');
            }


            if (!Character.isDigit(ch) && ch != ' ' || s.indexOf(ch) == s.length()-1) {
                if(opr == '+'){
                    stack.push(num);
                }else if ( opr == '-'){
                    stack.push(-1 * num);
                }else if (opr == '*'){
                    stack.push(stack.pop() * num);
                }else if ( opr == '/'){
                    stack.push(stack.pop() / num);
                }
                 num = 0;
                 opr = ch;  
            }
        }
        int sum = 0;
        if(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        int result = calculate(s);
        System.out.println("Calculation is : "+result);
    }
}
