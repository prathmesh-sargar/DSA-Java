// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:
// Input: heights = [2,4]
// Output: 4

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public static int[] nextSmaller(int[] arr){
        int n = arr.length;
        int [] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = n;
            }else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        return res;
    }

    public static int[] previousSmaller(int[] arr){

        int n = arr.length;
        int []res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }

            stack.push(i);
        }
        return res;
    }

    public static int largestRectangleArea(int [] heights){

        int [] ns = nextSmaller(heights);
        int [] ps = previousSmaller(heights);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int h = heights[i];
            int w = ns[i] - ps[i] -1;
            max = Math.max(max, (h*w));
        }
        return max;
    }
    public static void main(String[] args) {
        int []heights = {2,1,5,6,2,3};
        int area = largestRectangleArea(heights);
        System.out.println("largest area : "+area);
    }
}
