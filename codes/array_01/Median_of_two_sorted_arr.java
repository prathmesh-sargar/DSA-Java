// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

public class Median_of_two_sorted_arr {

    public static int[] merge(int[]num1,int[]num2){
        int[] ans = new int[num1.length+num2.length];

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        
        while (p1<num1.length || p2 < num2.length) {

            int val1 = p1 < num1.length ? num1[p1]: Integer.MAX_VALUE;
            int val2 = p2 < num2.length ? num2[p2] : Integer.MAX_VALUE;

            if(val1<val2){
                ans[p3] = val1;
                p1++;
            }else{
                ans[p3] = val2;
                p2++;
            }
            p3++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[]num1 = {1,2};
        int[]num2 = {3,5,6};

       int []res =  merge(num1, num2);
       
       if(res.length %2 ==0){
        double median = (double) (res[res.length/2] + res[res.length/2 -1])/2;
        System.err.println("median : "+median);
       }else{
        double median = (double) res[res.length/2];
        System.err.println("median : "+median);
       }
         
         

        

    }
}
