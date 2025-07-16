// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// Example 3:
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
 
public class Valid_palindrome{

    public static boolean isPalidrome(String s){

        // String str = "A man, a plan, a canal: Panama";

        // base case : 
        if(s.length() ==1){
            return true;
        }

        // convert given String into proper formate ok : 
        StringBuilder sb = new StringBuilder("");

        // loop throught String : 
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            // if(ch !=' ' && ch !=',' && ch != ':')

            if(ch >='a' && ch<='z'){
                sb.append(ch);
            }else if(ch >='A' && ch<='Z'){
                ch = Character.toLowerCase(s.charAt(i));
                sb.append(ch);
            }else if(ch>='0' && ch <='9'){
                sb.append(ch);
            }
        }

        System.out.println("updated String : "+sb.toString());

        // used two pointer approach to solve this : 
        sb.toString();
        int start = 0;
        int end = sb.length()-1;

        while (start < end){
            
            if(sb.charAt(start) != sb.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean res = isPalidrome(str);
        System.out.println("is Palindrome String : "+res);
    }
}