// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {

    public static ArrayList<List<String>> group_anagram(String[] strs){

        // used data structure to store values : 
        Map<String,List<String>> ans = new HashMap<>();

        for(String s:strs){
            // convert it into array : 
            char[]chars = s.toCharArray();
            // sort char array : 
            Arrays.sort(chars);
            // convert char array to String 
            String key = new String(chars);

            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());

    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
           
        for ( List s : group_anagram(strs)) {
             System.out.print(s+" ");
        }
    }
}
