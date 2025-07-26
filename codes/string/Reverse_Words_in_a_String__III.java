// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"


public class Reverse_Words_in_a_String__III {



    public static void reverserString(String s){
        int start = 0;
        int end = s.length();
    }

    public static String reverseLetters(String s){

        String [] chars = s.split("\s+");

        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<chars.length;i++){

            String temp = chars[i];
            reverserString(temp);

            

        }


        return " ";
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
    }
}
