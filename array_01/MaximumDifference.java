// Input: nums = [1,5,2,10]   
// Output: 9    10-1 = 9 

public class MaximumDifference {
    public static void main(String[] args) {
        int[] arr= {5,4,3};
        int maxDiff = -1;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                
                if(arr[j]>arr[i] && i<j){
                    int diff = arr[j]-arr[i];
                    maxDiff = Math.max(maxDiff, diff);
                }
            }
        }
        System.out.println("maximumDifference : "+maxDiff);
    }
}
