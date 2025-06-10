

// Input: [3, 4, 5, 1, 2]  
// Output: true

//  Check if array is sorted and rotated
package array_01;

public class Arr_Is_sorted_rotated {

    public static void main(String[] args) {

        // given array is 
        int arr[] = {3, 4, 5, 1,2};

        // base condition 
        if(arr[0]>arr[1]){
            System.err.println("true");
        }
        if(arr[arr.length-1] > arr[arr.length-2]){
            System.out.println("true");
        }
        // Given an array, check if it is sorted in increasing order and then rotated.
        for(int i=1;i<arr.length-1;i++){
            if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                 System.err.println("true");
                 break;
            }
        }

        
    }
}
