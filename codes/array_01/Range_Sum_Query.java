// Given an integer array nums, handle multiple queries of the following type:

// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
// Implement the NumArray class:

// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 
// Example 1:
// Input
// ["NumArray", "sumRange", "sumRange", "sumRange"]
// [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
// Output
// [null, 1, -1, -3]

// Explanation
// NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
// numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
// numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
// numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

public class Range_Sum_Query {
   public static int[] prefix;

    public static int RangeSum(int left,int right){
        if(left ==0){
            return prefix[right];
        }
        return prefix[right] - prefix[left-1];
    }
    public static void main(String[] args) {
        
        int []nums = {-2, 0, 3, -5, 2, -1};
        int n = nums.length;
        prefix = new int[n];
        prefix[0] =nums[0];
        

        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        int st =0;
        int la = 4;
        int result = RangeSum(st,la);
        System.out.println("range sum is : "+result);
    }

}
