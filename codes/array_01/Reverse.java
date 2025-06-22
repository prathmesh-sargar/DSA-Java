
// Reverse the array in-place


public class Reverse {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4};
        //  two pointer approach 
        int start = 0;
        int end = arr.length-1;

        for(int i=0 ;i<=end;i++){
            System.out.print(arr[i]);
        }

        while (start <=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        System.out.println();
        for(int i=0 ;i<=arr.length-1;i++){
            System.out.print(arr[i]);
        }
    }
}
