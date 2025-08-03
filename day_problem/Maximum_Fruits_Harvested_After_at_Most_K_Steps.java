// Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
// Output: 9
// Explanation: 
// The optimal way is to:
// - Move right to position 6 and harvest 3 fruits
// - Move right to position 8 and harvest 6 fruits
// You moved 3 steps and harvested 3 + 6 = 9 fruits in total.

// Example 2:
// Input: fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
// Output: 14
// Explanation: 
// You can move at most k = 4 steps, so you cannot reach position 0 nor 10.
// The optimal way is to:
// - Harvest the 7 fruits at the starting position 5
// - Move left to position 4 and harvest 1 fruit
// - Move right to position 6 and harvest 2 fruits
// - Move right to position 7 and harvest 4 fruits
// You moved 1 + 3 = 4 steps and harvested 7 + 1 + 2 + 4 = 14 fruits in total.

// Example 3:
// Input: fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
// Output: 0
// Explanation:
// You can move at most k = 2 steps and cannot reach any position with fruits.
 




public class Maximum_Fruits_Harvested_After_at_Most_K_Steps {


    public static boolean cheakReach(int left , int right , int start , int k){

        int leftdist = Math.max(0,start-left);
        int rightdist = Math.max(0, right - start);


        int min = Math.min(2*leftdist +rightdist, 2*rightdist+leftdist);

        if(min <=k){
            return true;
        }
        return false;
    }

    public static int maxTotalFruits(int [][]fruits  ,int startPos , int k ){

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int l =0;
        for(int r=0;r<fruits.length;r++){

            sum +=fruits[r][1];

            while (l<r && !cheakReach(fruits[l][0], fruits[r][0], startPos,k )) {
                sum -= fruits[l][1];
                l++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        // Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
        int [][] fruits = {{2,4},{6,3},{8,6}};
        int startPos = 5; 
        int k =4;

        int maxTotalFruit = maxTotalFruits(fruits, startPos, k);
        System.out.println("maxTotalFruits : "+maxTotalFruit);


        
    }
}
