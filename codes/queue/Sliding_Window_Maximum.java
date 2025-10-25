import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sliding_Window_Maximum {


       public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // will store indexes

        for (int i = 0; i < n; i++) {
            // 1. kick out indexes outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. add current index
            dq.offerLast(i);

            // 4. record answer when first window completes
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k =3;

        for (int val : nums) {
            System.out.print(val+ " ");
        }

        System.out.println();

        for (int max_val : maxSlidingWindow(nums, k)) {
            System.out.print(max_val+" ");
        }

    }
}
