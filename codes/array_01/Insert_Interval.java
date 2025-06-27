// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Interval {


    public static int[][] mergeLogic(List<int[]> allIntervals){

        int[] prev = allIntervals.get(0);
        List<int[]> merge = new ArrayList<>();

        for(int i=1;i<allIntervals.size();i++){
            int []current = allIntervals.get(i);

            if(current[0] <=prev[1]){
                prev[1] = Math.max(prev[1],current[1]);
            }else{
                merge.add(prev);
                prev = current;
            }

        }
        merge.add(prev);
        return merge.toArray(new int[merge.size()][]);
    }
    public static void main(String[] args) {
        int[][]intervals = {{1,3},{6,9}};

        for (int[] val : intervals) {
            System.out.print(Arrays.toString(val));
        }
        System.out.println();
        int[] newInterval = {2,5};

        List<int[]> allIntervals = new ArrayList<>();

        for (int[]interval : intervals) {
            allIntervals.add(interval);
        }
        // insertion take place : 
        allIntervals.add(newInterval);

        //  sorting take place 
        allIntervals.sort((a,b)->Integer.compare(a[0], b[0]));

        // merge logic :

        for (int[] val : mergeLogic(allIntervals)) {
            System.out.print(Arrays.toString(val));
        }
    }
}
