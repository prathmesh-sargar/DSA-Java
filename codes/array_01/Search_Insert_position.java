// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1

public class Search_Insert_position {
    public static int correct_Position(int[]nums,int t){
        int st = 0;
        int la = nums.length-1;
        while (st<=la){
            int mid = (st+la)/2;
            if(nums[mid] == t){
                return mid;
            }else if(nums[mid] >t){
                la = mid-1;
            }else{
                st = mid+1;
            }
        }
        return st;
    }
    public static void main(String[] args) {
        int[]nums = {1,3,5,6};
        int target = 2;
        int result = correct_Position(nums, target);
        System.err.println("correct position is : "+result);

    }
}
