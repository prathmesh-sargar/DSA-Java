// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// Example 2:

// Input: nums1 = [2,4], nums2 = [1,2,3,4]
// Output: [3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
// - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

public class Next_Greater_Element_I{

    public static int[] nextGreaterElement(int[] nums1, int [] nums2){
        int [] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int indexInNums2 = -1;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    indexInNums2 = j;
                    break;
                }
            }
            int nextGreater = -1;
            for(int k = indexInNums2+1;k<nums2.length;k++){
                if(nums2[k] > nums1[i]){
                    nextGreater = nums2[k];
                    break;
                }
            }
            res[i] = nextGreater;
        }
        return res;
    }
    public static void main(String[] args){
        int [] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        for (int val : nextGreaterElement(nums1, nums2)) {
            System.out.print(val);
            System.out.print(" ");
        }
    }
}
