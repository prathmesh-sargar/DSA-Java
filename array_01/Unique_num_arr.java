// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

public class Unique_num_arr {
    public static void main(String[] args) {
        int[] arr= {1,1,2,2};
        int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[j] !=arr[i]){    // 1 2
                j++;
              arr[j] = arr[i];  
            }
        }
       System.out.println("unique ele count : "+(j+1)); 
    }
}
