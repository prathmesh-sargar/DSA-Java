// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Explanation:
// The element 1 occurs at the indices 0 and 3.

// solve 3
// 1. hashmap()
// 2. hashSet()
// 3. sort()

import java.util.HashSet;

public class Contains_Duplicate {

    public static boolean isContains(int[]nums){

        // create hashSet : 
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

      return seen.size() < nums.length;
    }
    public static void main(String[] args) {
        int[]nums = {1,2,3,4};
        boolean res = isContains(nums);
        System.out.println("duplicate contains : "+res);
        
    }
}
