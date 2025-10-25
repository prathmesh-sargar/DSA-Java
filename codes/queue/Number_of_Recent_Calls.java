// You have a RecentCounter class which counts the number of recent requests within a certain time frame.

// Implement the RecentCounter class:
// RecentCounter() Initializes the counter with zero recent requests.
// int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].

// It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

// Example 1:
// Input
// ["RecentCounter", "ping", "ping", "ping", "ping"]
// [[], [1], [100], [3001], [3002]]
// Output
// [null, 1, 2, 3, 3]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */


 class RecentCounter{
    List<Integer> list;
    int i;
    int j;

    public RecentCounter(){
        list = new ArrayList<>();
        i=0;
        j=-1;   
    }
    public int ping(int t){
        list.add(t);
        j++;
        while (i <j && list.get(j)-3000 > list.get(i)) {
            i++;
        }
        return j-i+1;
    }
 }

 
 class RecentCounter2{

    // by using Queue : 
    Queue<Integer> queue;
   

    public RecentCounter2(){
       queue = new LinkedList<>(); 
    }

    public int ping(int t){
        queue.add(t);
        while (!queue.isEmpty() && t-3000 > queue.peek()) {
            queue.poll();   // remove first element : 
        }
       return queue.size();
    }
 }

public class Number_of_Recent_Calls{
    public static void main(String[] args) {
        
        RecentCounter obj = new RecentCounter();
        int param_1 = obj.ping(1);
        int param_2 = obj.ping(100);
        int param_3 = obj.ping(3001);
        int param_4 = obj.ping(3002);


        System.out.println(param_1+ " "+param_2+ " "+param_3+ " "+param_4);

    }
}