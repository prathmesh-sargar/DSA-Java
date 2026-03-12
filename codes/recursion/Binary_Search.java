public class Binary_Search{
  public static void main(String[] args) {

    int[] nums = {1,12,23,34,56,67,78,89,90};
    int start = 0;
    int end = nums.length-1;
    int target = 89;
    int searchIdx = searchElement(nums,start,end, target);
    System.out.println("Search element : "+target+ " index is : "+searchIdx);

  }

  public static int searchElement(int[] nums, int s ,int e , int target){

    // base condition : 
    if(s >e) return -1;

    int mid = s + (e-s)/2;

    // bs 3 conditions 
    if(nums[mid] == target){
      return mid;
    }
    else if (target < nums[mid]){
      return  searchElement(nums, s, mid-1, target);
    }else{
      return  searchElement(nums, mid+1, e, target);
    }
  }

}