// You are given an integer array nums consisting of n elements, and an integer k.
// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

// Example 1:
// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
// Example 2:

// Input: nums = [5], k = 1
// Output: 5.00000

public class Max_Avg_Subarray{
    public static void main(String[] args) {
        int k = 4;
        int nums[] = {1,12,-5,-6,50,3};
        int sum = 0;

        for(int i=0;i<k;i++){
            sum +=nums[i];
        }

        double max_sum = sum;  // first k elements sum 

        // sliding window  :
        for(int i=k;i<nums.length;i++){
            sum = sum-nums[i-k] +nums[i];    // remove leftmost , add right most 
            max_sum = Math.max(max_sum, sum);
        }
        System.out.println("maximum avg of subarray of k size is : "+(max_sum/k));


    }
}