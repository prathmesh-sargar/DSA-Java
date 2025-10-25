// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]

// Example 2:
// Input: head = [2,1,3,5,6,4,7]
// Output: [2,3,6,7,1,5,4]

public class Odd_Even_Linked_List {    // combine odd and even index node together and connect them with each others : 


     public static void traverse(Node head){
        
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" --> ");
            curr = curr.next;
        }
        System.out.print("NUll ");
    }


    public static Node oddEvenlist(Node head){

        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        // two lists   
        Node oddList = head;
        Node evenList = head.next;
        Node evenStart = head.next;


        while (evenList != null && evenList.next != null) {
            
            oddList.next = oddList.next.next;
            evenList.next = evenList.next.next;

            oddList = oddList.next;
            evenList = evenList.next;
        }
        oddList.next = evenStart;

        return head;
    }



    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        traverse(head);
        System.out.println();
        oddEvenlist(head);
        traverse(head);
    }
}

