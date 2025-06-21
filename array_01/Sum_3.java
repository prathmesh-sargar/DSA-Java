// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_3 {
    public static void main(String[] args) {
        
        int[] nums = {-1,0,1,2,-1,-4};
        // create Array list for you ogt my point 
        List<List<Integer>> res = new ArrayList<>();

        // sort given array : 
        Arrays.sort(nums);

        // Interate over loop : 
        for(int i=0;i<nums.length;i++){

            // for i th index val 
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            // now another two variable declar : 
            int j = i+1;
            int k= nums.length-1;

            while (j<k) {
                
                int total = nums[i]+nums[j]+nums[k];

                if(total >0){
                    k--;
                }else if(total < 0){
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    // check is double index j value again then move forword 
                    while (nums[j]==nums[j-1] && j<k) {
                        j++;
                    }
                }
            }
        }

        System.out.println(res);
        
    }
}
