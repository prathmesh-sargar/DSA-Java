

public class PalindromeCheck {


    public static boolean isPalindrome(int[]arr,int start ,int end){

         while (start <end) {
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,2,1};   // given string : 
        int start = 0;
        int end = arr.length-1;

        boolean result = isPalindrome(arr, start, end);
        System.out.println("result : "+result);
    }
}

