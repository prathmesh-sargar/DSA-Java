

public class Right_rotated_array {
    public static void main(String[] args) {
        
        //  given array is : 
        int arr[]= {1,2,3,4,5};
        for (int pre : arr) {
            System.out.print(pre+" ");
        }
        int k =2;
        int[] temp = new int[k];

        //  store in temp array : 
        for(int i=0;i<k;i++){
            temp[i] = arr[arr.length-1-i];
        }
    
        //  shifting array elements : 
        for(int i=arr.length-1;i>=k;i--){
            arr[i] = arr[i-k];
        }

        // storing temp array to arr :
        for(int i=0;i<k;i++){
            arr[i] = temp[i];
        }
        System.out.println();
        for (int ele : arr) {
            System.out.print(ele+" ");
        }
    }
}
