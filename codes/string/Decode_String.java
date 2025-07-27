// Example 1:
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"

// Example 2:
// Input: s = "3[a2[c]]"
// Output: "accaccacc"

// Example 3:
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"

import java.util.Stack;

public class Decode_String{

    public static String decode(String s){

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currentString = "";
        int k =0;

        // loop through given string : 
        for (char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                k = k*10 +(ch - '0');
            }
            else if (ch == '['){

                countStack.push(k);
                stringStack.push(currentString);
                // reset 
                k=0;
                currentString = "";
            }
            else if (ch ==']'){

                int repeat = countStack.pop();
                String laststr = stringStack.pop();

                StringBuilder sb = new StringBuilder(laststr);
                for(int i=0;i<repeat;i++){
                    sb.append(currentString);
                }
                currentString = sb.toString();
            }else{
                currentString +=ch;
            }
        }

        return currentString;
    }
    public static void main(String[] args) {
        
        // String s = "2[abc]3[cd]ef";
        String s = "3[a]2[bc]";
        System.out.println("increpted String :"+s.toString());
        String result = decode(s);
        System.out.println("decode string : "+result) ;
    }
}
