public class Search2Dmatrix{

  public static boolean searchMatrix(int [][]matrix, int target){
     
     int row = matrix.length;   // 3 
     int col = matrix[0].length;  // 4

     int range = row *col -1;   // 0-11

     int low = 0;
     int high = range;

     while(low <=high){

      int mid = low + (high -low)/2;  // 5 

        int r = mid /col;     // 5/4  = 1   
        int c =mid%col;      // 5%4  = 1 

        int midval = matrix[r][c];

        if(midval == target){
          System.err.println("at index row : "+r+ " and col  "+c+ " ans is "+midval);
          return  true;
        }else if (midval < target){
          low = mid+1;
        }else{
          high = mid-1;
        }
         
     }
     return  false;
  }
  public static void main(String[] args) {

      int [][]matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
      };

      int target = 30;

      boolean ans = searchMatrix(matrix, target);
      System.out.println("isPresent is 2D matric : "+ans);
  }
}