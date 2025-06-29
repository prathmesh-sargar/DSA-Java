// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true

// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true

// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

import java.util.HashMap;

public class Contains_Nearby_Duplicate {

    public static boolean isDuplicate_K(int[]nums,int k){
         HashMap<Integer,Integer> seen = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(seen.containsKey(val) && i- seen.get(val) <=k ){
                return true;
            }
           seen.put(val,i); 
        }
        return false;
    }
    public static void main(String[] args) {
        
        int[]nums = {1,2,3,1,2,3};
        int k =2;
        boolean res = isDuplicate_K(nums, k);
        System.out.println("is Duplicate with ( i-j <= k ): "+res);
    }
}
