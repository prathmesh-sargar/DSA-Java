// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
 

public class Koko_Eating_Bananas {

    public static boolean canEatInTime(int[] piles , int h , int speed){

        int hours = 0;
        // loop over piles 
        for(int pile : piles){
            hours += (pile +speed -1)/speed;
        }
        return hours <=h;
    }
    public static int minEatingSpeed(int [] piles , int h){

        int minspeed = 1;
        int maxspeed = -1;
        for(int pile : piles){
            maxspeed = Math.max(pile, maxspeed);
        }
         // here now we get range of answer arr :
        while(minspeed <=maxspeed){

            int midspeed = minspeed +(maxspeed - minspeed)/2;

            if(canEatInTime(piles, h, midspeed)){
                maxspeed =midspeed-1;
            }else{
                minspeed = midspeed +1;
            }
        } 
        return minspeed;
    }
    public static void main(String[] args) {
      
        int [] piles = {30,11,23,4,20};
        int hours = 5;
        int result = minEatingSpeed(piles, hours);
        System.out.println(" min No of banana's / h is :  "+result);
    }
}
