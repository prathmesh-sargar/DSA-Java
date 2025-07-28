import java.util.Stack;

public class Valid_Parentheses{

    public static boolean isvalid(String s ){

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch == '[' || ch == '(' || ch == '{'){
                st.push(ch);
            }
            else if( st.size() > 0 && ch == ')' && st.peek() == '('){
                st.pop();
            }
            else if ( st.size() > 0 && ch == ']' && st.peek() == '['){
                st.pop();
            }
            else if ( st.size() > 0 && ch == '}' && st.peek() == '{'){
                st.pop();
            }
            else{
                return false;
            }
        }

        if(st.size() ==0 ){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        
        String str = "[{()}]";

        System.out.println("is valid parentheses : "+isvalid(str));
    }
}
