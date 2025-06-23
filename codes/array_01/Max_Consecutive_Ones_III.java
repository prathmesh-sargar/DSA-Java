// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
// Example 1:
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:
// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.




// class Solution {
//     public int longestOnes(int[] nums, int k) {

//       int left = 0;
//       for(int right = 0;right<nums.length;right++){

//         if(nums[right] == 0){
//             k-=1;
//         }
//         if(k<0){
//             if(nums[left] == 0){
//                 k++;
//             }
//             left++;
//         }
//       }      
//      return nums.length-left; 
//     }
// }

public class Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k =2;
        int left = 0;
        for(int right =0;right<nums.length;right++){

            if(nums[right] == 0){
                k-=1;
            }
            if(k<0){
                if(nums[left]==0){
                    k++;
                }
                left++;
            }
        }
        System.out.println("Max Consecutive ones :"+(nums.length-left));
    }
}
