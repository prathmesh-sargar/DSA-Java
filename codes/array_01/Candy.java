// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.
// Example 1:
// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
// Example 2:
// Input: ratings = [1,2,2]
// Output: 4
// Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
// The third child gets 1 candy because it satisfies the above two conditions.

public class Candy{
    public static int required_Candies(int[]ratings){   

        int n = ratings.length;

        int[]candies = new int[n];

        // given 1 candy to all child first without cosidering ratings : 
        for(int i=0;i<candies.length;i++){
            candies[i] = 1;
        }

        // goes form left to rights : 
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        // goes from right to left 
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }

        int totalcount = 0;

        for (int c : candies) {
            totalcount +=c;
        }
 
        return totalcount;
    }

    public static void main(String[] args) {
        int ratings[] = {1,0,2};

        int count = required_Candies(ratings);
        System.err.println("required candies : "+count);
    }
}