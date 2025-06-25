// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
 
// above questions question was amaazing first I am try to solve this using //sliding window but sliding window only applicable for +ve integer values 
// it fail for -ve values 

// bruit force approch is nested for loops 
// best is prefix sum and hashmap() 


import java.util.HashMap;

public class Subarray_sum_equal_K {
    public static void main(String[] args) {
        
        int[] nums = {1,1,1};
        int k =2;
        // output : 2 
        int count = 0;
        int sum = 0;

        HashMap<Integer,Integer> prefixsum = new HashMap<>();
        prefixsum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            if(prefixsum.containsKey(sum-k)){
                count += prefixsum.get(sum-k);
            }
            prefixsum.put(sum,prefixsum.getOrDefault(sum,0)+1);
        }
        System.out.println("Count is : "+count);
    }
}
