// “Find first index where condition becomes true”
// “Find last index where condition was true before breaking”

public class Occurrence{

  public static int firstOccurrence(int[] nums, int target){

    int start = 0;
    int end = nums.length-1;
    int ans = -1;

    while(start <=end){
      int mid = start +(end-start)/2;

      if(nums[mid] >=target){
        ans = mid;
        end = mid-1;
      }else {
        start = mid+1;
      }
    }
    if (ans != -1 && nums[ans] == target) return ans;
    return -1;
  }

  public static int lastOccurrence(int[] nums, int target){

    int start =0;
    int end = nums.length-1;
    int ans = -1;

    while(start<=end){

      int mid = start + (end-start)/2;
      if(nums[mid] <= target){
        ans = mid;
        start = mid+1;
      }else{
        end = mid-1;
      }
    }

    // return  ans;
    if(ans !=-1 && nums[ans]== target) return ans;
    return -1;
  }
   public static void main(String[] args) {
       
       int []nums = {2,2,2,2,2};   // it should be sorted don't unsort it 
       int target = 2;
       int first = firstOccurrence(nums, target);
       int last = lastOccurrence(nums, target);
       System.out.println("firstoccurrence : "+first);
       System.out.println("Lastoccurrence : "+last);

    
   }
}


