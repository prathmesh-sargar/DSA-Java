
// ✅ HashMap → when you need to store key-value pairs (like number → frequency).
// ✅ HashSet → when you need to store unique items only (no duplicates).

// 3️⃣ Frequency of Each Element
// 📌 Easy-Medium

// Print the frequency (count) of each element in the array.

// Input: [10, 20, 10, 30, 20, 10]  

// Output:
// 10 -> 3  
// 20 -> 2  
// 30 -> 1

// Learn about HashSet and HashMap data Structure : 


import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public static void main(String[] args) {

        // given array is :
        int[] arr = { 10, 20, 10, 30, 20, 10 };

        // create one hashMap to store number - > frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // traverse on given array :
        for (int num : arr) {

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else{
                 map.put(num, 1);
            }
        }
        // print data from HashMap (Key->value)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey()+" -->"+entry.getValue());
            System.out.println();
        }

    }

}
