
// ✅ Problem Statement
// Leaders in an Array:
// An element is a leader if it is greater 
// than all the elements to its right.


// arr = [16, 17, 4, 3, 5, 2]
// output :  17 5 2

// The last element is always a leader  in given array : 
public class LeadersInArray {
    public static void main(String[] args) {
    
        int[] arr= {16,17,3,5,2};

        int maxRight = arr[arr.length-1];

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] >= maxRight){
                maxRight = arr[i];
                System.out.print(arr[i]+" ");
            }
        }

    }
}
