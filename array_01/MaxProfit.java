// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

public class MaxProfit {
    public static void main(String[] args) {
        int[]arr= {7,1,5,3,6,8};
         int maxProfilt = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[j]>arr[i] && i<j){
                    int diff = arr[j]-arr[i];
                    maxProfilt = Math.max(maxProfilt, diff);
                }
            }
        }
        System.out.println("Max Profit is  : "+maxProfilt);
    }
}
