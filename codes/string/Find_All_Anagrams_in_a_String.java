// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// Example 1:
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Example 2:
// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_All_Anagrams_in_a_String{
    public static void findAnagrams(String s , String p){
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> ans = new ArrayList<>();
        // calculate freq of p : 
        for(char c : p.toCharArray()){
            pCount[c-'a']++;   // here we build pCount frequency
        }
        // calculate s String ferquency : 
        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i) - 'a']++;
            if(i>=p.length()){
                sCount[s.charAt(i-p.length())- 'a']--;
            }
            // compare freq : 
            if(Arrays.equals(pCount,sCount)){
                ans.add(i-p.length()+1);
            }
        }
        for(int index : ans){
            System.out.print(index+ " ");
        }
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String  p = "abc";
        findAnagrams(s, p);
    }
}