// Find the Missing Number
// 🧠 Input: [1, 2, 4, 5, 6] → Output: 3

public class Find_missing_number {
    public static void main(String[] args) {
        int[]arr= {1,2,4,5,6};

        int sumOf_all = sumall(arr);
        int sumOf_first_nth = sumAll_nth(arr);

        int missing_number = sumOf_first_nth -sumOf_all;
        System.out.println("missing Number is : "+missing_number);
    }
    
    public static int sumall(int[]arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
        }
        return sum;
    }

    public static int sumAll_nth(int[]arr){
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        return sum;
    }
}
