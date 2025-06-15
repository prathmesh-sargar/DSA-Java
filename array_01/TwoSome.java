import java.util.HashMap;
// import java.util.Map;

public class TwoSome{


    public static  int[] findindexs(int[]arr,int target){
          //  HashMap  
        HashMap<Integer,Integer> map = new HashMap<>();

        // loop throught given array 
        for(int i=0;i<arr.length;i++){

            int complement = target-arr[i];
            if(map.containsKey(complement)){
                // System.out.println(map.get(complement)+"  "+i);
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);

        }
        return new int[]{-1,-1};

    }
    public static void main(String[] args) {
        int[] arr = {2,4,7,6,8};
        int target = 13;
        int []demo = findindexs(arr, target);
        for (int i : demo) {
            System.out.print(i+" ");
        }
    }
}
