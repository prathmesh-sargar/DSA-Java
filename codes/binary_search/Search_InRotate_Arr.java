public class Search_InRotate_Arr{


  public static int search(int[] nums, int target){

    int low =0;
    int high = nums.length-1;

    while (low <= high) { 
        int mid  = low + (high - low)/2;
        if(nums[mid] == target){
          return  mid;
        }
        
            // left side is sorted    
        if(nums[low] <= nums[mid]){

          if(nums[low] <= target && target < nums[mid]){
             high = mid-1;
          }else{
             low = mid+1;
          }

        }else{
             // right part is sorted : 
             if(nums[mid] < target && target <=nums[high]){
                 low = mid+1;
             }else{
                 high = mid-1;
             }
        }
    }

    return -1;
  }
   public static void main(String[] args) {
       int []nums = {4,5,6,7,0,1,2};
       int target = 0;

       int ans = search(nums,target);
       if(ans ==-1){
        System.out.println("element is not present ");
       }else{
        System.out.println("elemENT is present at index : "+ans);
       }
   }
}