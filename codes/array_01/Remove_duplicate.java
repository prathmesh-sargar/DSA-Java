// ✅ 3. Remove Duplicates from Sorted Array
// Level: Easy
// Input: [1,1,2,2,3]
// Output: [1,2,3]

//  with using extra space HashSet you are using : HashSet() for unique values : 

// 🧠 Hint: Keep a pointer for the next unique position.

import java.util.HashSet;
public class Remove_duplicate{
    public static void main(String[] args) {
        
                 // given array is :
         int[] arr = { 1,1,2,2,3};
         System.out.println("original array : ");
         for (int num : arr) {
            System.out.print(num+" ");
         }
         // create one HashMap to store number and it's frequency : 
         HashSet<Integer> map = new HashSet<>();
         // traverse throught given array : 
            for (int num : arr) {
                map.add(num);
            }
         // printing HashMap so for that we iterate over given HashMap ok  
         System.out.println();
         System.out.println("unique elements : ");
         for (Integer number : map) {
            System.out.print(number +"  ");
         }        
    }
}