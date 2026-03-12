public class Find_Min_RotatedSorted_Arr{

   public static int findmin(int[]nums){

      int low = 0;
      int high = nums.length-1;


      while(low < high){
         int mid = low + (high -low) /2;
         if(nums[mid] > nums[high]){
            low = mid+1;
         }else{
            high = mid;
         }
      }
      return nums[low];
   }

   public static int findmax(int[]nums){

      int low  =0;
      int high = nums.length-1;
      int n = nums.length;

      while(low < high){
         int mid = low +(high -low)/2;

         if(nums[mid] > nums[high]){
            low = mid+1;
         }else {
            high = mid;
         }
               
      }
      return nums[(low-1+n)%n];
   }
   public static void main(String[] args) {
       int []nums = {3,4,5,6,1,2};
       int minval = findmin(nums);
       int maxval = findmax(nums);
       System.out.println("minimum value is : "+minval);
       System.out.println("maximum value is : "+maxval);
   }
}
