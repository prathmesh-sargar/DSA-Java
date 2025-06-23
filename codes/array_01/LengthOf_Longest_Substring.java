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
// Output: 
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// 3 ways to solve this question - sliding window, set, hashing and the last position

import java.util.HashSet;

public class LengthOf_Longest_Substring{

    public static void main(String[] args) {

        String s = "abcdabcbb";
        int left = 0;
        int max_count = 0;

        HashSet<Character> set = new HashSet<>();
        
        for(int right = 0;right <s.length();right++){

            char ch = s.charAt(right);

            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);

            max_count = Math.max(max_count, right -left +1);
        }
        System.out.println("length Of Longest Substring : "+max_count);
        
    }
}