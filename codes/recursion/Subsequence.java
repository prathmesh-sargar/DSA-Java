import java.util.*;
public class Subsequence{

    public static void subSequence(int idx, int[]nums,List<Integer> current){

        // base case : 
        if(idx == nums.length){
            System.out.println(current);
            return;
        }

         // NOt take element : 
        subSequence(idx+1,nums,current);

        // take element : 
        current.add(nums[idx]);
        subSequence(idx+1, nums,current);

        // backtrack : 
        current.remove(current.size()-1);

       
    }
    public static void main(String [] args){
        int nums[] = {3,1,2};
        subSequence(0,nums, new ArrayList<>());
    }
}