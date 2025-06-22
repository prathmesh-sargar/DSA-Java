
// Second Largest Element

// 🧠 Input: [2, 5, 1, 7, 3] → Output: 5
// 🔑 You need to track both max and secondMax.

public class Sec_largest_ele {
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,3,6};
        int max = arr[0];
        int secondMax = arr[0];
        for(int i=1;i<arr.length;i++){ //i ==  1 2 3 4

            if(arr[i] > max){
                secondMax = max; // 2 5  
                max = arr[i];   // 5 7
            }
            else if(secondMax <arr[i]){
                secondMax = arr[i];
            }
        }
        System.out.println("sencond max : "+secondMax);
    }
}
