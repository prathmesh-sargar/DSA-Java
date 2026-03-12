public class Palindrome_String_Recursion{

    public static boolean isPalindrome(int l ,String s ,int r){

        // basecase : 
        if(l >= r) return true;
        if(s.charAt(l) != s.charAt(r)){
            return false;
        }
        // recursive call function : 
        return isPalindrome(l+1,s,r-1);
    }
    public static void main(String [] args){
        String s = "MADAM";
        int l = 0;
        int r = s.length()-1;
        boolean ans = isPalindrome(l,s,r);
        System.out.println("isPalindrome : "+ans);
    }
}