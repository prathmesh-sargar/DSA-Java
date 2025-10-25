// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

// Example 1:


// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
// Example 2:

// Input: head = [], val = 1
// Output: []
// Example 3:

// Input: head = [7,7,7,7], val = 7
// Output: []
 


public class Remove_Linked_List_Elements {

    public static void traverse(Node head){
        
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" --> ");
            curr = curr.next;
        }
        System.out.print("NUll ");
    }

    public static Node removeElements(Node head , int val){

        if(head == null) return null;
         while (head.data == val) {
             head = head.next;
         }
        //  if(head == null) return null; 
         Node curr = head;
         while (curr.next != null) {
            if(curr.next.data == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
         }

         return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next  = new Node(6);

        traverse(head);
        System.out.println();
        int val = 6;
        Node node = removeElements(head,val);
        System.out.println(node.data);
        traverse(head);
    }
}
