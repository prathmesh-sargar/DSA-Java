// 1. subsequences template
// 2. combination template
// 3. permutation template

import java.util.*;

public class CombinationSum2{

    public static void findCombinations(int idx,int target,int[] arr,ArrayList<Integer> current,List<List<Integer>> ans){

        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=idx;i<arr.length;i++){

            // skiping : 
            if(i >idx && arr[i] == arr[i-1]){
                continue;
            }

            if(arr[i] > target){
                break;
            }
            current.add(arr[i]);
            findCombinations(i+1,target-arr[i],arr,current,ans);

            // backtrack : 
            current.remove(current.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] arr, int target){

        Arrays.sort(arr);
        // result list of list : 
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,target,arr,new ArrayList<>(),ans);

        return ans;

    }
    public static void main(String [] args){
        int[] arr = {1,1,1,2};
        int target = 3;

        for(List subarr : combinationSum2(arr,target)){
            System.out.println(subarr);
        }

        
    }
}