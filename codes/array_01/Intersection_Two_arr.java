// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

import java.util.HashSet;

public class Intersection_Two_arr{
    public static int[] intersection_optimize(int[]num1,int[]num2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        // store first ele in set : 
        for (int num : num1) {
            set.add(num);
        }
        // loop on second array : 
        for (int num : num2) {
            if(set.contains(num)){
                resultSet.add(num);
            }
        }

        //  result return array created : 
        int []result = new int[resultSet.size()];

        // store set ele in result array : 
        int idx =0;
        for (int num : resultSet) {
            result[idx] = num;
            idx++;
        }
        return result;
    }
    
    
    public static void Intersection(int[]num1,int[]num2){

       HashSet<Integer> set = new HashSet<>();
       int n1 = num1.length;
       int n2 = num2.length;

       if(n1<=n2){
            for(int i=0;i<n1;i++){
                for(int j=0;j<n2;j++){
                    if(num1[i] == num2[j]){
                        set.add(num1[i]);
                        break;
                    }
                }
            }
       }else{

            for(int i=0;i<n2;i++){
                for(int j=0;j<n1;j++){
                    if(num2[i] == num1[j]){
                        set.add(num2[i]);
                        break;
                    }
                }
            }
       }
    

       int[] res = new int[set.size()];

       int idx =0;
       for (int num : set) {
           res[idx]= num;
           idx++;
       }

       for (int num : res) {
          System.out.print(num+" ");
       }
    
    }
    
    public static void main(String[] args) {
        
        int []num1 = {9,4,9,8,4};
        int []num2 = {9,4,4,3};

        for (int i : num1) {
            System.out.print(i+ " ");
        }
        System.out.println();
        for (int i : num2) {
            System.out.print(i+" ");
        }
        System.out.println();

       for (int res  : intersection_optimize(num1, num2)) {
            System.out.print(res+ " ");
       }
    }

}