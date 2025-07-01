// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1


public class Search_In_Rotated_sorted_arr {

    public static int correct_idx(int[]nums,int t){

        int st = 0;
        int la = nums.length-1;

        while (st<=la){
            int mid = (st+la)/2;

            if(nums[mid] == t ){
                return mid;
            }else if (nums[st] <=nums[mid]){  // first half is sorted
                
                if(t>=nums[st] && t<nums[mid]){
                    la = mid-1;
                }else{
                    st = mid+1;
                }
            }else{   // right part is sorted : 

                if(t>nums[mid] && t<=nums[la]){
                    st = mid+1;
                }else{
                    la = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
        int[]nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = correct_idx(nums, target);
        System.err.println("res : "+result);
    }
}
