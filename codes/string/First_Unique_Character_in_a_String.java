// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
// Example 1:
// Input: s = "leetcode"
// Output: 0
// Explanation:
// The character 'l' at index 0 is the first character that does not occur at any other index.

// Example 2:
// Input: s = "loveleetcode"
// Output: 2

// Example 3:
// Input: s = "aabb"
// Output: -1

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String{

    public static int unique_char_index(String s){

        // hashmap : freq : 
        Map<Character,Integer> freq = new HashMap<>();
        
        // loop over s String : 
        for(char ch : s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1); 
        }
        for(int i=0;i<s.length();i++){
            if(freq.get(s.charAt(i)) ==1){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        String s = "loveleetcode";
        int result = unique_char_index(s);
        System.out.println("unique character index is : "+result);
    }
}