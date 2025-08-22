// You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
// Implement the BrowserHistory class:
// BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
// void visit(string url) Visits url from the current page. It clears up all the forward history.
// string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
// string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

import java.util.Stack;

class BrowserHistory{

    // home page 
    // vist 
    // back
    // forword 

    public Stack<String> backStack = new Stack<>();
    public Stack<String> forwordStack = new Stack<>();

    public String curr ;

    public  void HomePage(String url){
        curr = url;
    }

    public  void vist(String url){

        backStack.push(curr);
        curr = url;
        forwordStack.clear();
    }

    public  String back(int steps){

        while (!backStack.isEmpty() && steps >0) {

            forwordStack.push(curr);
            curr = backStack.pop();

            steps--;
        }
        return curr;
    }

    public  String forword(int steps){

        while (!forwordStack.isEmpty() && steps >0) {
            backStack.push(curr);
            curr = forwordStack.pop();
            steps--;
        }
        return curr;
    }
}
public class Design_Browser_History {
    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory();
        obj.HomePage("leetcode.com");
        obj.vist("google.com");
        obj.vist("fackbook.com");
        obj.vist("Instagram.com");
        System.out.println(obj.back(1));
        System.out.println(obj.back(1));
        System.out.println(obj.forword(2));  
    }
}
