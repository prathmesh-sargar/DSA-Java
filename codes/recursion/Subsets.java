import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main (String[] args){

      int [] nums = {1,2,3};
      System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums){

      // result list : 
      List<List<Integer>> result = new ArrayList<>();
      // call the helper function : 
      backtrack(result, new ArrayList<>(), nums,0);
      return result;
    }

    // define helper function : 
    private static void backtrack(List<List<Integer>> result , List<Integer>subsets, int[] nums , int index)
  {
     // add the current subset to the result : 
     result.add(new ArrayList<>(subsets));

     // iterates through the nums of array : 
     for(int i=index; i< nums.length;i++){

      // include the number to the current subsets: 
      subsets.add(nums[i]);

      // move on to the next element : 
      backtrack(result, subsets, nums, i+1);

      // backtrack : remove the last added element : 
      subsets.remove(subsets.size()-1);
     }
  }
}