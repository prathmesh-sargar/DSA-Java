// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.

// Example 2:
// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


public class Middle_of_the_Linked_List {

    public static void traverse(Node head){
        
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" --> ");
            curr = curr.next;
        }
        System.out.print("NUll ");
    }

    public static int sizeLL(Node head){
        int count = 0;

        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static Node MiddleNode(Node head, int middle){

        Node curr = head;
        for(int i=0;i<middle;i++){
            curr = curr.next;
        }
        return curr;
        // traverse(curr);
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        traverse(head);
        System.out.println();

        int middle = sizeLL(head) / 2 ;
        Node nodeval = MiddleNode(head, middle);
        System.out.println("Middle Node : "+nodeval.data);
        traverse(nodeval);
    }
}