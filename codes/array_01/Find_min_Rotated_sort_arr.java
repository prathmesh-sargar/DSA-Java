// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// You must write an algorithm that runs in O(log n) time.
// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

// Example 2:
// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

// Example 3:
// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times.


public class Find_min_Rotated_sort_arr {

    public static int minNum(int[]nums){
        int st = 0;
        int la = nums.length-1;

        if(nums.length ==1){
            return nums[0];
        }else if (nums[0] <=nums[la]){
            return nums[0];
        }

        while (st<=la){
            
            int mid = (st+la)/2;
            if(mid !=0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }else if(mid!=nums.length-1 && nums[mid] > nums[mid+1]){
                return nums[mid +1];
            }else if(nums[st] <=nums[mid]){
                st = mid+1;
            }else{
                la= mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,0,1,2};
        int min_num = minNum(nums);
        System.err.println("min num : "+min_num);
    }
}

