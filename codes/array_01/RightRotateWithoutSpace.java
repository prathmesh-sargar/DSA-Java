public class RightRotateWithoutSpace {

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rightRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        // Step 1: Reverse entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse remaining n-k elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 1;

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        rightRotate(arr, k);
        System.out.println("\nRight rotated by " + k + ":");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
