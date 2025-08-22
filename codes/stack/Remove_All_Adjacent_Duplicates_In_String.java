// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
// We repeatedly make duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

// Example 1:
// Input: s = "abbaca"
// Output: "ca"
// Explanation: 
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
// Example 2:

// Input: s = "azxxzy"
// Output: "ay"

import java.util.Stack;
public class Remove_All_Adjacent_Duplicates_In_String{
    public static String removeDuplicate(String s){
        Stack<Character> stack = new Stack<>();
        // loop over 
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek().equals(s.charAt(i))){
               stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
         StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        
        String s = "abbaca";
        String ans = removeDuplicate(s);
        System.out.println("ans : "+ans);
    }
}