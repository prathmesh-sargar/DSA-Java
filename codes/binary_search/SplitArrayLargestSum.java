
//  split array largest sum : 
public class SplitArrayLargestSum {


  public static boolean cansplit(int []nums, int capacity, int kbreaks){

    int part = 1;
    int currentmax =0;

    for(int n :nums){

      if(currentmax +n > capacity){
        part++;
        currentmax = 0;
      }
      currentmax +=n;
    }
    return  part <= kbreaks;
  }

  public static int splitArray(int [] nums , int kbreaks){
    
    int low =-1;
    int high =0;
    for(int n: nums){
      low = Math.max(low, n);
      high +=n;
    }
    int ans = high;

    while(low <= high){

      int mid = low +(high -low) /2;

      if(cansplit(nums, mid ,kbreaks)){
         ans = mid;
         high = mid-1;
      }else{
        low = mid+1;
      }
    }
    return ans;
  }

    public static void main(String[] args) {
       int[] nums = {7,2,5,10,8};
       int kbreaks = 2;
       int largestsum = splitArray(nums, kbreaks);
       System.err.println("largest sum is : "+largestsum);
    }
}
