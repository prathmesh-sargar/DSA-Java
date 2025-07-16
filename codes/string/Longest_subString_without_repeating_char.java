// Given a string s, find the length of the longest substring without duplicate characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


// hint used hashSet to solve this with Character list : 

import java.util.HashSet;

public class Longest_subString_without_repeating_char {

    public static int long_subString_len(String s){

        int left = 0;
        int max_count = 0;

        //  We used HashSet() : 
        HashSet<Character> st = new HashSet<>();

        // loop throught given string : 
        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);
            while (st.contains(ch)){
                st.remove(s.charAt(left));
                left++;
            }
            st.add(ch);

            max_count = Math.max(max_count,right-left+1);
        }
        return max_count;
    }
    public static void main(String[] args) {
        
        String s = "abcabcdbb";

        int ans = long_subString_len(s);
        System.out.println("longest subString length : "+ans);
    }
}
