
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

// Here we used HashMap()
// HashMap() have one method called 
// map.put(key,value)

// HashMap<KeyType, ValueType> map = new HashMap<>();
// map.put(key, value);
// map.put("Apple", 2);
// map.put("Banana", 5);



// | Style              | When to Use                      | Code Shortness |
// | ------------------ | -------------------------------- | -------------- |
// | `entrySet()` loop  | Most common, clean & readable    | 👍 Medium      |
// | `keySet()` loop    | When value not always needed     | 👍 Medium      |
// | `forEach()` method | For modern, short code (Java 8+) | ✅ Shortest     |


import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter{

    public static void main(String[] args) {

         // given array is :
         int[] arr = { 10, 20, 10, 30, 20, 10 };

         // create one HashMap to store number and it's frequency : 
         HashMap<Integer,Integer> map = new HashMap<>();


         // traverse throught given array : 
            for (int num : arr) {
                if(map.containsKey(num)){
                    map.put(num, map.get(num)+1);
                }else{
                    map.put(num,1);
                }
            }
         // printing HashMap so for that we iterate over given HashMap ok    

        //  1. EntrySet(): 
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            System.out.print(entry.getKey() +" --> "+entry.getValue());
            System.out.println();
        }
        System.out.println();
        // 2. by sing ketSet():
        for (int key : map.keySet()) {
            System.out.println(key+ "--->"+map.get(key));
        }
        System.out.println();
        // 3. by using map + forEach function : 
        map.forEach((key,value)->{
            System.out.println(key + "---> "+value);
        });
    }

}
