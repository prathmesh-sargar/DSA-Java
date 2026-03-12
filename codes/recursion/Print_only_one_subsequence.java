// Find only ONE subsequence whose sum = K
import java.util.*;

public class Print_only_one_subsequence{

    public static boolean OneSubsequenceSumK(int idx,int[]nums,List<Integer> current,int sum,int k){

        // base base : 
        if(idx == nums.length){
            if(sum == k){
                System.out.println(current);
                return true;
            }
            else{
                return false;
            }
        }
        // take element : 
        current.add(nums[idx]);
        if(OneSubsequenceSumK(idx+1,nums,current,sum+nums[idx],k) == true){
            return true;
        }
        // backtrack :
        current.remove(current.size()-1);
        // not take element :

        return OneSubsequenceSumK(idx+1,nums,current,sum,k)== true;
    }
    public static void main(String [] args){

        int nums[] = {1,2,1};
        int k = 2;
        OneSubsequenceSumK(0,nums,new ArrayList<>(),0,k);

    }
}