// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

public class Container_with_most_water {
    public static void main(String[] args) {
        int[]arr = {1,8,6,2,5,4,8,3,7};
        int s = 0;
        int l= arr.length-1;
        int max_area = 0;
        int curr_area = 0;

        while (s <l){
            int len;
            if(arr[s] <arr[l]){
                len = arr[s];
                curr_area = len *(l-s);
                max_area = Math.max(max_area,curr_area);
                s++;
            }else{
                len= arr[l];
                curr_area = len *(l-s);
                max_area = Math.max(max_area,curr_area);
                l--;
            }
        }
        System.out.println("max_area : "+max_area);
    }
}
