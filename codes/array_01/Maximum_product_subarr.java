// Given an integer array nums, find a subarray that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
public class Maximum_product_subarr{
    public static void main(String[] args) {
        int[] nums = {-2,3,-4};
        int res = Integer.MIN_VALUE;

        for (int i : nums) {
            res = Math.max(i, res);  // max number in array 
        }
        //  two variables  
        // curr max val 
        // curr min val

        int currMax = 1;
        int currMin = 1;
        for (int num : nums) {
            int temp = currMax *num;
            currMax = Math.max(temp,Math.max(currMin *num,num));
            currMin = Math.min(temp, Math.min(currMin *num,num));

            res = Math.max(res, currMax);
        }
        System.out.println("Maximum product subarry is : "+res);

    }
}