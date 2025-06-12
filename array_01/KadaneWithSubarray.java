// 5️⃣ Kadane’s Algorithm – Return the Subarray
// Modify your max-subarray (Kadane’s) code to return the subarray itself, not just the sum.

// Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]  
// Output: [4, -1, 2, 1]     sum of all is 6 

// currentMax and Maxaum

// ✅ In One Line:
// Kadane’s Algorithm finds the maximum sum of a subarray by going left to right, and starting fresh whenever the sum becomes worse than the current number.

// 🛠️ When to Use:
// Arrays with both +ve and -ve numbers

// Need to find max sum of subarray

// DSA interviews, CP, optimization problems

// ✅ Real-World Analogy:
// Imagine you're walking on a path (array):

// Every step gives you coins (positive) or makes you lose them (negative)

// You want to collect the maximum coins in a row (subarray)

// If you're losing too much, just restart from a new place

// At the end, check when you got the maximum coins

// That’s Kadane! 😄🎒

public class KadaneWithSubarray {
    public static void main(String[] args) {
        int arr[] ={-2,1,-3,4,-1,2,1,-5,4};
        int current_max = arr[0];
        int max_sum = arr[0];

        int start = 0;
        int end = 0;
        int tempstart =0;

        for(int i=1;i<arr.length-1;i++){

            if(arr[i] > current_max +arr[i]){

                current_max = arr[i];
                tempstart = i;  // potential new start 
            }else{
                current_max +=arr[i]; 
            }


            if(current_max > max_sum){
                max_sum = current_max;
                start = tempstart;
                end = i;
            }
        }

        System.out.println("start pointer: "+start);
        System.out.println("end pointer: "+end);

        System.out.println("sub array is ");
        for(int i=start;i<=end;i++){
            System.out.print(+arr[i]+" ");
        }

    }
}


