
public class Prefix_sum {
   public static void main(String[] args) {
      int[]nums = {1,2,3,4,5};
      for (int num : nums) {
        System.out.print(num +" ");
      }
      System.out.println();
      for(int i=1;i<nums.length;i++){
        nums[i] = nums[i-1]+nums[i];
      }
      for (int num : nums) {
        System.out.print(num+ " ");
      }
   } 
}
