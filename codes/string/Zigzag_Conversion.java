// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
// string convert(string s, int numRows);
 
// Example 1:
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I

// Example 3:
// Input: s = "A", numRows = 1
// Output: "A"

public class Zigzag_Conversion{

    public static String zig_zaString(String s,int numRows){

        // base case : 
        if(numRows == 1  || s.length() <= numRows){
            return s;
        }

        // array of Stringbuilders : 
        StringBuilder [] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }

        int currRow =0;
        boolean goingDown = false;

        // loop over : 
        for(char ch : s.toCharArray()){

            rows[currRow].append(ch);

            if(currRow == 0 || currRow == numRows-1){
                goingDown = !goingDown;
            }

            currRow +=goingDown ? 1:-1;
        }

        // for (StringBuilder sb : rows) {
        //     System.out.println(sb.toString());
        // }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row :rows){
            res.append(row);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(s.toString());
        int numRows = 3;
        String result = zig_zaString(s, numRows);
        System.out.println("zig-Zag String : "+result);
    }
}