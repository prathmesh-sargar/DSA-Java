
// Check if Array is Sorted
// sorted array have two types : 
// 1. incresing order
// 2. decreasing order 


// 🧠 Input: [1, 2, 3, 4] → ✅
// 🧠 Input: [5, 3, 1] → ✅
// 🧠 Input: [1, 2, 2] → ❌

public class Array_Is_sorted {
    public static void main(String[] args) {
        int arr1[] = {1,5,2,3,4};
        int arr2[] = {5,3,3,1};
        int arr3[]= {1,2,2};

        boolean result = Is_sorted(arr2);
        System.out.println("result : "+result);

    }
    public static boolean Is_sorted(int[]arr){
        
        if(arr.length<=0)
           return true;

        if(arr[0] >arr[1]){
           return des_order(arr);
        }
        else {
           return asend_order(arr);
        }

    }

    //  des
    public static boolean des_order(int []arr){
        //  5,3,1
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] <=arr[i+1]){
                return false;
            }
        }
        return true;
    }

    // asc 
    public static boolean asend_order(int []arr){
        // 1,2,2
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] >=arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
