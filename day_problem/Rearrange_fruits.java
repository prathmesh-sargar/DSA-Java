// You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:
// Chose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
// The cost of the swap is min(basket1[i],basket2[j]).
// Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.
// Return the minimum cost to make both the baskets equal or -1 if impossible.

// Example 1:
// Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
// Output: 1
// Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.

// Example 2:
// Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
// Output: -1
// Explanation: It can be shown that it is impossible to make both the baskets equal.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rearrange_fruits {

    public static long minCost(int [] arr1 , int [] arr2){

        Map<Integer,Integer> map = new HashMap<>();
        int n = arr1.length;
        int min = Integer.MAX_VALUE;

        // calculate freq diff : 
        for(int i =0;i<n;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
            map.put(arr2[i],map.getOrDefault(arr2[i],0)-1);
            min = Math.min(min,Math.min(arr1[i],arr2[i]));
        }

        List<Integer> list = new ArrayList<>();

        // iterate over freq map : 
        for(int key : map.keySet()){
            int count = map.get(key);
            if(count % 2 !=0) return -1;

            for(int i=0;i<Math.abs(count/2);i++){
                list.add(key);
            }
        }

        long ans = 0;

        for(int i=0;i<list.size()/2;i++){
            ans+= Math.min(min*2, list.get(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int[] basket1 = {4,2,2,2};
        int[] basket2 = {1,4,1,2};
        
        long minCost = minCost(basket1 , basket2);
        System.out.println("minCost is : "+minCost);
    }
}
