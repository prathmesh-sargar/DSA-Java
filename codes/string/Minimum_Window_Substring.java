// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring{

    public static String minWindow(String s , String t){

        int n = s.length();

        if(n<t.length()){
            return "";
        }

        // create Map of char freq : 
        Map<Character,Integer> mp = new HashMap<>();

        // added all t string to map : 
        for(char ch : t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        int minWindowsize = Integer.MAX_VALUE;
        int requieCount = t.length();
        int start_i = 0;

        int i =0; int j =0;

        while (j<n) {
            char ch = s.charAt(j);

            if(mp.containsKey(ch) && mp.get(ch) >0){
                requieCount--;
            }
            mp.put(ch,mp.getOrDefault(ch,0)-1);

            // require fulfil   (requireCount == 0 )
            while (requieCount ==0 ) {
                // shrinking window 

                int currWindowsize = j-i+1;

                if(currWindowsize < minWindowsize){
                    minWindowsize = currWindowsize;
                    start_i = i;
                }

                // shrink logic 
                char startChar = s.charAt(i);
                mp.put(startChar,mp.getOrDefault(startChar,0)+1);

                if(mp.containsKey(startChar) && mp.get(startChar)>0){
                    requieCount++;
                }
                i++;
            }
            j++;
        }

        return minWindowsize == Integer.MAX_VALUE ? "" :s.substring(start_i, start_i +minWindowsize);
    }
    public static void main(String[] args) {
        
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println("Minimum Window Substring : "+ans);
    }
}
