// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

// Example 1:
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.

public class Min_size_subarray_sum {
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;

        int start = 0;
        int sum = 0;
        int min_count =Integer.MAX_VALUE;

        for(int end = 0;end<nums.length;end++){
            sum +=nums[end];
           while(sum >= target){
             min_count = Math.min(min_count ,end-start+1);
             sum = sum-nums[start];
             start++;
           }
        }
         int result =  min_count == Integer.MAX_VALUE ? 0:min_count;
         System.out.println("min subarray sum is : "+result);
    }
}
