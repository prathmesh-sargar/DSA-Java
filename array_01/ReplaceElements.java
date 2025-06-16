// Example 1:

// Input: arr = [17,18,5,4,6,1]
// Output: [18,6,6,6,1,-1]
// Explanation: 
// - index 0 --> the greatest element to the right of index 0 is index 1 (18).
// - index 1 --> the greatest element to the right of index 1 is index 4 (6).
// - index 2 --> the greatest element to the right of index 2 is index 4 (6).
// - index 3 --> the greatest element to the right of index 3 is index 4 (6).
// - index 4 --> the greatest element to the right of index 4 is index 5 (1).
// - index 5 --> there are no elements to the right of index 5, so we put -1.
// Example 2:

// Input: arr = [400]
// Output: [-1]
// Explanation: There are no elements to the right of index 0.

public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};

        int n = arr.length;

        if(arr.length ==1){
            System.out.println(-1);
            return;
        }
        
        int maxRight = -1;
        
        for(int i = n-1;i>=0;i--){
            int temp = arr[i];
            arr[i]=maxRight;
            maxRight = Math.max(maxRight, temp);
        }

        for (int num : arr) {
            System.out.print(num+"  ");
        }
    }
}
