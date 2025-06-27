//  meeting room 1 is same as like Merge Interval problem 
// meting room 2 problem 


// given an array of Intervals merge all overlapping intervals 
// and return an array of non overlapping intervals 

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Merge_Intervals {


    public static int[][] non_overlaplist(int[][]intervals){

         //  create array list to store non overlappint intervals 
          List<int[]> merge = new ArrayList<>();
          int[]prev = intervals[0];

        //   iterate over intervals : 
        for(int i =1;i<intervals.length;i++){

            int[]interal = intervals[i];
            if(interal[0] <=prev[1]){
                prev[1] = Math.max(prev[1],interal[1]);
            }else{
                merge.add(prev);
                prev = interal;
            }
        }
        merge.add(prev);
        return merge.toArray(new int[merge.size()][]);
    }
    public static void main(String[] args) {
        
// [[1,3],[2,6],[8,10],[15,18]]
        int [][]intervals = {{1,3}, {2,6},{8,10},{15,18}};
        for (int[] is : intervals) {
            System.out.print(Arrays.toString(is));
        }
        System.out.println();

        // output  : {{1,6},{8,10},{15,18}}

        //  sorted array : 
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        // System.out.println(non_overlaplist(intervals));

        for (int[] arr : non_overlaplist(intervals)) {
            System.out.print(Arrays.toString(arr));
        }
    }
}
