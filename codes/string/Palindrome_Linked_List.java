// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true


// create ListNode : 

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val;}
    ListNode(int val , ListNode next){this.val = val ; this.next = next;}
}



public class Palindrome_Linked_List {


    public static boolean isplaindrome(ListNode head){

        // stack create : 

        Stack<Integer> st = new Stack<>();

        ListNode ptr1 = head;

        // added all nodes in stack :
        while (ptr1 !=null) {
            st.push(ptr1.val);
            ptr1 = ptr1.next;
        }

        // now check : 
        ListNode ptr2 = head;

        while (ptr2 !=null) {
            int val1 = ptr2.val;
            int val2 = st.pop();

            if(val1 != val2){
                return false;
            }
            ptr2 = ptr2.next;
        }
        
        return true;
    }



    public static void main(String[] args) {
        
        //  create LinkedList : 
        ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(1);

         boolean ans = isplaindrome(head);
         System.out.println("isPalindrome : "+ans);
    }
}
