// Example 1:

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

// Example 2:
// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]

import java.util.Stack;

public class Next_Greater_Element_II {


    public static int[] nextGreaterElements(int[]nums){

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];

        // array is circular 
        for(int i = 2*n-1;i>=0;i--){

            while (!stack.isEmpty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }

            if(i < n){
                if(stack.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        return res;
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4,3};
        for (int val : nextGreaterElements(nums)) {
            System.out.print(val);
            System.out.print(" ");
        }
    }
}
