// An array is considered special if the parity of every pair of adjacent elements is different. In other words, one element in each pair must be even, and the other must be odd.
// You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
// Example 1:
// Input: nums = [1]
// Output: true
// Explanation:
// There is only one element. So the answer is true.

// Example 2:
// Input: nums = [2,1,4]
// Output: true
// Explanation:
// There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

public class Special_array_I {
    // {2,1,3};
    public static boolean isTrue_false(int[]arr){
         int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]%2 ==0 && arr[j]%2==0){
                System.out.println("&&");
                return false;
            }
            else if(arr[i] %2 !=0 && arr[j]%2 !=0){
                return false;
            }
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[]arr = {4,3,1,6};

        boolean result = isTrue_false(arr);
        System.out.println("result : "+result);
       
    }
}
