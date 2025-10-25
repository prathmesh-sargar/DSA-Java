// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

import java.util.Stack;

public class Palindrome_Linked_List {

    public static boolean byStack(Node head){

        Stack<Integer> stack= new Stack<>();
        Node curr = head;
        while(curr!=null){
            stack.push(curr.data);
            curr = curr.next;
        }
        curr = head;
        while (!stack.isEmpty() && curr != null) {
            int val1 = curr.data;
            int val2 = stack.pop();
            if(val1 != val2){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        boolean isPalindrome = byStack(head);
        System.out.println("ispalindrome : "+isPalindrome);
    }
}
