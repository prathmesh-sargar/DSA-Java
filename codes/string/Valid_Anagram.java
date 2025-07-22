// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

import java.util.Arrays;

public class Valid_Anagram{

    public static Boolean isAnagram(String s ,String t){

        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for(char c: s.toCharArray()){
            sFreq[c-'a']++;
        }

        for(char c:t.toCharArray()){
            tFreq[c-'a']++;
        }

        if(Arrays.equals(sFreq,tFreq)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
        String s = "anagram";
        String t = "nagaram";
        Boolean ans = isAnagram(s, t);
        System.out.println("isAnagram : "+ans);
    }
}
