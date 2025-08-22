// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Example 3:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

public class Backspace_String_Compare {

    public static String isActualStr(String s){

        StringBuilder sb = new StringBuilder();
        int hashCount = 0;
        int n = s.length();

        for(int i= n-1;i>=0;i--){

            if(s.charAt(i) == '#'){
                hashCount++;
                continue;
            }

            if(hashCount > 0){
                hashCount--;
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.reverse().toString();
    }

    public static boolean ans(String s , String t){
        return isActualStr(s).equals(isActualStr(t));
    }

    public static void main(String[] args) {
        // Input: s = "ab#c", t = "ad#c"
        // s = "ab##", t = "c#d#"

        String s = "ab##";
        String t = "c#d#";

        boolean res = ans(s, t);
        System.out.println("is equal String : "+res);
        
    }
}
