// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 
// Example 1:
// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

// Example 2:
// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
// Output: -1
// Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.


// bloomDay = [1,10,3,10,2]
// m = 3, k = 1

public class Minimum_Number_of_Days_to_Make_m_Bouquets {

  public static boolean canMakeBouquet(int[] bloomDay , int mbouquet,int kflower,int days){
    // base edge condition : 
    if(mbouquet * kflower > bloomDay.length){
      return  false;
    }
    int total =0;
    int count =0;

    for(int i= 0;i<bloomDay.length;i++){

      if(bloomDay[i] <= days){
        count++;
      }else{
        count =0;
      }
      if(count == kflower){
         total++;
         count =0;
      }
      if(total >= mbouquet){
        return  true;
      }
    }
    return  false;
  }


  public static int minDays(int [] bloomDay , int m ,int k){

      int ans = -1;
      int start = Integer.MAX_VALUE;
      int end = Integer.MIN_VALUE;

      for(int day : bloomDay){
         start = Math.min(start, day);
         end = Math.max(end, day);
      }

      while(start<= end){

        int mid = start +(end -start)/2;
        if(canMakeBouquet(bloomDay,m,k,mid)){
           ans = mid;
           end = mid-1;
        }else{
          start = mid+1;
        }
      }
      return  ans;

  }
  public static void main(String[] args) {
      int [] bloomDay = {1,10,3,10,2};
      int m =3;
      int k =1;

      int result = minDays(bloomDay ,m ,k);
      System.out.println("minimum day's Make m Bouquets is : "+result);
       
  }
}
