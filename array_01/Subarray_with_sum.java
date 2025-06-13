// 4. Subarray with Given Sum (Positive numbers only)
// Level: Medium
// 📌 Find a subarray that adds up to a given target sum k.

// Example:
// Input: arr = [1, 4, 20, 3, 10, 5], k = 33
// Output: Subarray [20, 3, 10]

// this  kind of problem solve using Sliding Window Approach 

// Sliding window is a technique used to solve problems related to 
// subarrays, substrings, or sequences, where you want to:

public class Subarray_with_sum {
    public static void main(String[] args) {
        int[] arr = {1, 4,23,34,20, 3, 10, 5};
        int k = 33;
        int curr_sum = 0;
        int start = 0;

        for(int end=0;end<arr.length;end++){
            curr_sum +=arr[end];   //  38

            while(curr_sum >k && start <=end){ 
                curr_sum -=arr[start];  // 37 33 
                start++;  // 1 2 
            }

            if(curr_sum == k){
                System.out.println("start : "+start);
                System.out.println("end : "+end);

                for(int st=start;st<=end;st++){
                    System.out.print(arr[st]+ " ");
                }
            }         
        }
       
    }
}
