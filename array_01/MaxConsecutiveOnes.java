// 4️⃣ Longest Consecutive 1’s in Binary Array

// Given a binary array, find the maximum number of consecutive 1s.

// Input: [1, 1, 0, 1, 1, 1]  
// Output: 3

// approch : 0 is break point so according to that what we update the curr_max vale 
// and then compare which one is max value  Math.max(curr_max ,max_sum)

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[]arr = {1, 1,1, 0, 1, 1, 1,1,0,1,1,1};
        int max_sum = 0;
        int curr_max =0; 
        int count =0;
        // int start = 0;
        // int end = 0;
        // int tempstart =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                //  [ 1 , 1 , 0 , 1 , 1 ,0 , 1 ,1]
                curr_max +=arr[i];

                if(curr_max > max_sum){
                    max_sum = curr_max; 
                    count = 1;
                }
                else if (curr_max == max_sum){
                    count++;
                }
            }else{
                curr_max = 0;
            }

        //    max_sum = Math.max(curr_max, max_sum); 
        }
        System.out.println("max_count is : "+max_sum);
        System.out.println("occurence of max are :"+count);
    }
}
