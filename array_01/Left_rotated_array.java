
// // Left Rotate Array by 1    this is question 
// // Left Rotate Array by 2
// // Left Rotate Array by 3   
// // Left Rotate Array by 4   
// // 🧠 Input: [1, 2, 3, 4, 5] → Output: [2, 3, 4, 5, 1]

// public class Left_rotated_array {
//   public static void main(String[] args) {
//     int arr[] = {1,2,3,4,5};
//     for (int i : arr) {
//         System.out.print(i+" ");
//     }
//     System.out.println();
//     int temp = arr[0];  // 1
//     int temp1 = arr[1];
//     for(int i=0;i<arr.length-2;i++){
//         arr[i] =arr[i+2];
//     }
//     arr[arr.length-2] = temp;
//     arr[arr.length-1]=temp1;
//      System.out.print( "Left Rotate Array by 2 :");
//     for (int ele : arr) {
//         System.out.print(ele+" ");
//     }
//   }   
// }



public class Left_rotated_array {

  public static void main(String[] args) {

    int arr[] = {1,2,3,4,5};

    for (int i : arr) {
        System.out.print(i+" ");
    }

    System.out.println();
    int k=3;
    int[]temp = new int[k];

    // store 1 ,2 in kth array : 
    for(int i=0;i<k;i++){
        temp[i] = arr[i];
    }

    //  shifting values towards left 
    for(int i=k;i<arr.length;i++){
        arr[i-k] =arr[i];
    }

    // given array is now :  [3,4,5,1]

    //  adding themp array vale to given array :
    for(int i =0;i<k;i++){
        // arr[]
        arr[arr.length-k+i] = temp[i];
    }

     System.out.print( "Left Rotate Array by "+k+" : ");
    for (int ele : arr) {
        System.out.print(ele+" ");
    }
  }   
}