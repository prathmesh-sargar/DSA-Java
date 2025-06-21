// Example 1:
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

// Example 2:
// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
 
public class Reverse_String {
    public static void main(String[] args) {
        char st[] = {'h','e','l','l','o'};
        int s = 0;
        int l=st.length-1;
        System.out.println("before : ");
        for (char c : st) {
            System.out.print(c);
        }

        while (s<=l) {
            char temp = st[s];
            st[s]= st[l];
            st[l] = temp;

            s++;
            l--;
        }
        System.out.println(" \n after : ");
        for (char c : st) {
            System.out.print(c);
        }
    }
}
