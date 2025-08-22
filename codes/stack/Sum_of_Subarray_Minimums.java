// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

// Example 1:
// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.

// Example 2:
// Input: arr = [11,81,94,43,3]
// Output: 444

import java.util.Stack;

public class Sum_of_Subarray_Minimums {

    public static int[] findLeftNextSmaller(int[] arr , int len){

        int[]res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<len;i++){

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        
        return res;
    }

    public static int[] findRightNextSmaller(int[] arr , int len){

        int[]res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = len-1;i>=0;i--){

            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = len;
            }else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static int ans(int [] arr ){

        int len = arr.length;
        int MOD = 1000000007;
        long totalsum = 0;

        int [] leftNextSmaller = findLeftNextSmaller(arr,len);
        int [] rightNextSmaller = findRightNextSmaller(arr,len);

        for(int i=0;i<len;i++){

            long leftDist = i - leftNextSmaller[i];
            long rightDist = rightNextSmaller[i]- i;
            long totalways = leftDist * rightDist; 
            long currsum  = totalways * arr[i];
            totalsum = (totalsum + currsum) % MOD;
         }

        return (int) totalsum;
    }

    public static void main(String[] args) {
        
        int[] arr = {3,1,2,4};
        int ans = ans(arr);
        System.out.println("Sum of Subarray Minimums : "+ans);
    }
}
