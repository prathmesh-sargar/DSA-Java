// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// calculated minimum buy_prices 
// let  buy_price = prices[0];
// 
//  if(buy_price > prices[i]){
//  buy_price = prices[i]
// profit = Math.max(profit , curr_prices - buy_price)      

public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6};
        int maxProfilt = 0;
        int buy_price = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (buy_price > arr[i]) {
                buy_price = arr[i];
            }
            maxProfilt = Math.max(maxProfilt, arr[i]-buy_price);
            
        }
        System.out.println("Max Profit is  : " +maxProfilt);
    }
}    
