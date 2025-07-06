// There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
// Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

// Example 1:
// Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
// Output: 3

public class Gas_Station{

    public static int firstStartIndex(int[]gas, int[]cost){

        int totalGas =0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas +=gas[i];
            totalCost +=cost[i];
        }
        //  base case check : 
        if(totalGas < totalCost){
            return -1;
        }
        int currGas = 0;  
        int StartIndex = 0;

        for(int i=0;i<gas.length;i++){
            currGas +=gas[i] -cost[i];   // -2 -2 -2 3 

            if(currGas < 0){
                currGas = 0;
                StartIndex = i+1;  // 1 2 3 
            }
        }
        return StartIndex;
    }
    public static void main(String[] args) {
        int[]gas = {1,2,3,4,5};
        int[]cost = {3,4,5,1,2};
        int res = firstStartIndex(gas, cost);
        System.out.println("start index is : "+res);
    }
}