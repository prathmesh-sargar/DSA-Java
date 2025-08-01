// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

// Example 2:
// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]

// Example 3:
// Input: temperatures = [30,60,90]
// Output: [1,1,0]

import java.util.Stack;

public class Daily_Temperatures{

    public static int[] dailyTemperatures(int[] temp){

        int n = temp.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];

        // loop over array : 
        for(int idx = n-1;idx>=0;idx--){

            while (!stack.isEmpty() && temp[idx] >= temp[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                res[idx] = stack.peek() - idx;
            }

            stack.push(idx);
        }       
        return res;
    }
    public static void main(String[] args) {
   
        int []temperatures = {73,74,75,71,69,72,76,73};
        for (int val : dailyTemperatures(temperatures)) {
            System.out.print(val);
            System.out.print("  ");
        }

    }
}