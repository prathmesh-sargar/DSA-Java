// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:
// Input: s = "egg", t = "add"
// Output: true
// Explanation:
// The strings s and t can be made identical by:
// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.

// Example 2:
// Input: s = "foo", t = "bar"
// Output: false
// Explanation:
// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

// Example 3:
// Input: s = "paper", t = "title"
// Output: true

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {

    public static boolean isIsomorphic(String s,String t){

        Map<Character,Integer> Sindex = new HashMap<>();
        Map<Character,Integer> Tindex = new HashMap<>();


        for(int i=0;i<s.length();i++){

            if(!Sindex.containsKey(s.charAt(i))){
                Sindex.put(s.charAt(i),i);
            }
            if(!Tindex.containsKey(t.charAt(i))){
                Tindex.put(t.charAt(i),i);
            }

            if(!Sindex.get(s.charAt(i)).equals(Tindex.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        Boolean ans = isIsomorphic(s, t);
        System.out.println("isIsomorphic : "+ans);

    }
}
