public class CountSubsequenceSumK {

    public static int countSubsequence(int index, int[] arr, int sum, int k) {

        if(index == arr.length) {
            if(sum == k) {
                return 1;
            }
            return 0;
        }

        // TAKE
        int left = countSubsequence(index + 1, arr, sum + arr[index], k);

        // NOT TAKE
        int right = countSubsequence(index + 1, arr, sum, k);

        return left + right;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,1};
        int k = 2;

        int result = countSubsequence(0, arr, 0, k);

        System.out.println(result);
    }
}