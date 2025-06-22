


// 🔄 Steps (with Explanation):
// Reverse the first k elements → [2, 1, 3, 4, 5]
// Reverse the remaining elements (n-k) → [2, 1, 5, 4, 3]
// Reverse the whole array → [3, 4, 5, 1, 2] ✅


public class LeftRotateWithoutSpace {
    
    public static void reverse(int[]arr,int start , int end){

        while (start <end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }


    public static void LeftRotate(int[]arr,int k){
        int n = arr.length;
        k = k%n;
        // first reverse k th elements :
        reverse(arr, 0, k-1);    // [2,1]
        // reverse remaining n-k items : 
        reverse(arr, k, n-1);      //  [5,4,3]
        // reverse entire array :    // [2,1,5,4,3]

        reverse(arr, 0, n-1);    // [3,4,5,1,2]
    }
    public static void main(String[] args) {
        
        int[] arr={1,2,3,4,5};
        int k=2;

        for (int pre : arr) {
            System.out.print(pre+" ");
        }
        System.out.println();
        LeftRotate(arr,k);
          for (int New : arr) {
            System.out.print(New+" ");
        }


    }
}
