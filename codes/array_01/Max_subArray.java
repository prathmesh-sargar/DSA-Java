// Input: [-2,1,-3,4,-1,2,1,-5,4]  
// Output: 6  // (subarray [4,-1,2,1])
// Kadane’s Algorithm

// for this problem we need   

// current_sum 
// max_sum 
public class Max_subArray {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2,1, -5, 4};

        int current_max = arr[0];
        int max_sum = arr[0];

        for(int i=1;i<arr.length;i++){

            System.out.println("index "+ i +" Math.math("+arr[i]+","+current_max+arr[i]+")");
            current_max = Math.max(arr[i],(current_max +arr[i]));
            System.out.println("current_max : "+current_max);
            max_sum = Math.max(max_sum,current_max); 
            System.out.println("max_sum : "+max_sum);
        }

        System.out.println(max_sum);
    }
}
