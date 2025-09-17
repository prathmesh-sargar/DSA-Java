import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WindowTransform {

    public static List<Integer> process(int[] arr , int k){

        Set<Integer> seen = new LinkedHashSet<>();

        int n = arr.length;
        if(n<k){
            return new ArrayList<>();
        }
        int windowSum = 0;
        for(int i=0;i<k;i++){
            windowSum += arr[i];
        }

        // loop over list : 
        for(int start =0;start<n-k;start++){

            int []window = Arrays.copyOfRange(arr, start, start+k);

            if(windowSum %2 ==0) {  // even sum 
                // reverse : 
                for (int l = 0, r = k - 1; l < r; l++, r--) {
                    int tmp = window[l];
                    window[l] = window[r];
                    window[r] = tmp;
                }
            }else{
                // sort : 
                Arrays.sort(window);
            }

            for(int num :window) seen.add(num);

            // update window sum : 
            if(start+k < n){
                windowSum = windowSum - arr[start] +arr[start+k];
            }
        }

        return new ArrayList<>(seen);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 4, 6};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        int k = 3;
        System.out.println(process(arr, k));
        // Example output: [9, 2, 5, 1, 7, 4, 6]
    }
}
