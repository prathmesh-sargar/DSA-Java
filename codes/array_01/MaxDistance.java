// Input: colors = [1,1,1,6,1,1,1]
// Output: 3
// Explanation: In the above image, color 1 is blue, and color 6 is red.
// The furthest two houses with different colors are house 0 and house 3.
// House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
// Note that houses 3 and 6 can also produce the optimal answer.

public class MaxDistance {
    public static void main(String[] args) {
        int[]colors = {1,1,1,6,1,1,2};
        int n = colors.length;
        int maxDist = 0;

        // check first house colors[0] to all colors array 
        for(int i=n-1;i>=0;i--){
            if(colors[0] !=colors[i]){
                maxDist =Math.max(maxDist, i);
            }
        } 
        // check last house colors[n-1] to all colors array 
        for(int i=0;i<n-1;i++){
            if(colors[n-1] != colors[i]){
                maxDist =Math.max(maxDist, (n-1)-i);
            }
        }        

       System.out.println("maxDist : "+maxDist); 
    }
}
