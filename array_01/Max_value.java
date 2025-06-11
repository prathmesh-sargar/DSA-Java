

public class Max_value {
    public static void main(String[]args){
        // Input: arr = [3, 5, 1, 8, 4]  
        // Output: 8

        int arr[] = {3,5,1,8,4};
        int max = -1;
        for( int i=0;i<=arr.length-1;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("max value is : "+max);

    }
}
