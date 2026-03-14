// | Feature                | Combination Sum | Combination Sum II |
// | ---------------------- | --------------- | ------------------ |
// | reuse same number      | ✅ allowed       | ❌ not allowed      |
// | duplicates in array    | usually no      | yes                |
// | recursion take step    | `index`         | `index + 1`        |
// | duplicate combinations | not a problem   | must avoid         |





import java.util.*;

public class Combination_Sum {

    public static void find(int idx, int[] arr, int target, ArrayList<Integer> current, List<List<Integer>> ans) {

        // base case : 
        if(target ==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        // 2 base case : 
        if(idx == arr.length){
            return;
        }

        if(arr[idx] <= target){

            current.add(arr[idx]);

            // take element : 
            find(idx,arr,target - arr[idx],current,ans);

            // backtrack
            current.remove(current.size()-1);
        }

        // non take element : skip given index and move to next idx 
        find(idx +1,arr,target,current,ans);

    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        // recursive calls 
        find(0, arr, target, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

            for (List subarr : combinationSum(arr, target)) {
                System.out.println(subarr);
            }
    }
}
