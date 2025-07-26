// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example 1:
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.

// Example 2:
// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
 
public class Implement_strStr{


    public static int hardCodeLogic(String str1, String str2){

        StringBuilder sb = new StringBuilder("");

        int left =0;
    
        // loop over haystack string
        for(int right =0;right<str1.length();right++){

            sb.append(str1.charAt(right));

            // base check condition : 
            if(sb.length() > str2.length()){
                sb.deleteCharAt(0);
                left++;
            }

            if(str2.equals(sb.toString())){
                return left;
            }
        }

        return -1;
    }

    public static int strStr(String haystack,String needle){
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        String haystack = "sqsadbutsad";
        String needle = "sad";
        // int result = strStr(haystack,needle);
        int result = hardCodeLogic(haystack,needle);
        System.out.println("strStr : "+result);
    }
}