public class Search_RotatedSorted_DuplicateEle{

  public static boolean searchInDupicate(int[] nums,int target){

    int low = 0;
    int high = nums.length-1;

    while(low <= high){

      int mid = low + (high -low)/2;

      if(nums[mid] == target)  return  true;

      if(nums[low] == nums[mid] && nums[mid] == nums[high]){
         low++;
         high--;
      }
      //  left part is sorted 
      else if (nums[low] <= nums[mid]){
          if(nums[low] <=target && target < nums[mid]){
             high = mid-1;
          }else{
             low = mid+1;
          }
      }
      //  right part is sorted 
      else{
        if(nums[mid] <target && target <= nums[high]){
            low = mid+1;
        }else{
          high = mid-1;
        }
      }
    }
    return  false;
  }
  public static int searchmin(int[] nums){
    int low =0;
    int high = nums.length-1;
    int n = nums.length;

    while(low < high){
      int mid = low + (high -low)/2;

      if(nums[mid] > nums[high]){
        low = mid+1;
      }else if (nums[mid] < nums[high]){
        high = mid;
      }else {    //   nums[mid] == nums[high]
            high--;
      }
    }
    System.out.println("maximum is "+nums[(low-1+n)%n]);  //  maximum ele 
    return nums[low];
  }
   public static void main(String[] args) {
       int []nums = {3,4,5,6,7,8,0,0,1,1};
       int target = 1;
       boolean ispresent = searchInDupicate(nums,target);
       System.err.println("is element present : "+ispresent);
       int findmin = searchmin(nums);
       System.err.println("minimum is : "+findmin);
   }
}