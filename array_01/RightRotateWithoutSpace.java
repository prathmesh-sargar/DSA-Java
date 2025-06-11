public class RightRotateWithoutSpace {


    public static void reverse(int[]arr,int start , int end){

        while (start <end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }


    public static void rightRotate(int[]arr,int k){
        //  [1,2,3,4,5]    k
        int n = arr.length;
        k = k%n;
        // first reverse k th elements :
        // reverse(arr, k+1, n-1);       ------>  comment out kth only : 
        // reverse remaining n-k items : 
        reverse(arr, 0, k);      
        // reverse entire array :    

        reverse(arr, 0, n-1);   
    }

    public static void main(String[] args) {
        
        int[] arr={1,2,3,4,5};
        int k=1;

        for (int pre : arr) {
            System.out.print(pre+" ");
        }
        System.out.println();
        rightRotate(arr,k);
          for (int New : arr) {
            System.out.print(New+" ");
        }


    }
}
