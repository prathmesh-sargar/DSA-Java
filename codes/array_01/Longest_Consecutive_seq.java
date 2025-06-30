// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Example 3:
// Input: nums = [1,0,1,2]
// Output: 


// condition solve this in o(n) TC  

// approch 1 : 
//    HashMap()

// 🔢 1. Array: [3, 10, 2, 1, 20]
// Consecutive Sequence:
// 1, 2, 3 is a consecutive sequence (sorted by value, regardless of position)

// Subsequence:
// 3, 10, 20 is a valid subsequence (same order, but not next to each other)


import java.util.HashSet;

public class Longest_Consecutive_seq{


    public static int optimized_appro(int[]nums){

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxlen = 0;
        for(int num : set){
            if(set.contains(num-1) == false){
                int curr = num;
                int len = 1;
                while (set.contains(curr+1)) {
                    curr++;
                    len++;
                }
               maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int []nums = {100,4,200,1,3,2};

        int res = optimized_appro(nums);
        System.out.println("maximum consecutive seq : "+res);
    }
}