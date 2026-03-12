import java.util.*;
public class Subsequence_with_sum_equalTo_K{

    public static void findSubsequence(int idx,int[]nums,List<Integer>current,int sum, int k){

        // basecase :
        if(idx == nums.length){
            if(sum == k){
                System.out.println(current);
            }
            return;
        }
        // take element : 
        current.add(nums[idx]);
        findSubsequence(idx+1,nums,current, sum+nums[idx],k);

        // backtrack :
        current.remove(current.size()-1);

        // not take ele :
        findSubsequence(idx+1,nums,current,sum ,k);
    }
    public static void main(String [] args){

        int nums[] ={1,2,1};
        int k=2;
        findSubsequence(0,nums,new ArrayList<>(),0,k);
    }
}