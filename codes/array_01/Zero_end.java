
//  Move all zeros to the end
// Input: [0, 1, 0, 3, 12]  
// Output: [1, 3, 12, 0, 0]
//  we used here two pointer approach 


public class Zero_end {
  public static void main(String[] args) {
      int arr[] = {0,1,0,3,12};
      int j =0;
      for(int i=0;i<=arr.length-1;i++){
        // int j =0;    dont declear here 
          if(arr[i] != 0){
            arr[j]=arr[i];
            j++;
          }
      }
    //   here j is 3  we full all 
      while (j <arr.length) {
        arr[j] = 0;
        j++;
      }

      for (int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
      }
  }
}
