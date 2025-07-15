// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

//  left ele array  sum : 
//  right ele array sum : 
//  answer array will be : left[i] * right[i]; 
public class Product_Except_self {

    public static void product_ExceptSelf(int[]nums){
        int n = nums.length;

        int []left = new int[n];
        int []right= new int[n];
        int []ans = new int[n];



        left[0] =1;
        for(int i=1;i<left.length;i++){

            left[i] = left[i-1] *nums[i-1];
        }

        right[n-1] =1;
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] *nums[i+1];
        }

        for(int i =0;i<ans.length;i++){
            ans[i] = left[i] *right[i];
        }

        for (int i : ans) {
            System.out.print(i+ " ");
        }
    }
    public static void main(String[] args) {
        int []nums = {-1,1,0,-3,3};
        // with_Divide_opr(nums);
        product_ExceptSelf(nums);
    }
}
