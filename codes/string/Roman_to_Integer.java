// Example 1:
// Input: s = "III"
// Output: 3
// Explanation: III = 3.

// Example 2:
// Input: s = "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.

// Example 3:
// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {

    public static int romanToInt(String s){

        Map<Character,Integer> mp = new HashMap<>();

        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);

        //loop over string : 

        int total =0;
        for(int i=0;i<s.length();i++){

            int value = mp.get(s.charAt(i));

            if(i+1 <s.length() && value < mp.get(s.charAt(i+1))){
                total -= value;
            }else{
                total +=value;
            }

        }
        return total;
    }
    public static void main(String[] args) {
        
        String s = "MCMXCIV";
        int int_val = romanToInt(s);
        System.out.println("integer value : "+int_val);
    }
}
