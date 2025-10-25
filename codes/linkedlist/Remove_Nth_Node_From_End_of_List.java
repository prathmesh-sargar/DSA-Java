// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]




public class Remove_Nth_Node_From_End_of_List {

    public static void traverse(Node head){
        
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" --> ");
            curr = curr.next;
        }
        System.out.print(" Null");
    }

    public static int sizeLL(Node head){
        int count =0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        traverse(head);
        System.out.println();

        int n = 1;
        int size = sizeLL(head);
        Node curr = head;
        // loop over List : 
        for(int i=0;i<size-n-1;i++){
            curr = curr.next;
        }
        if(curr == null && curr.next == null){
            System.out.println("[]");
            return;
        }
        curr.next = curr.next.next;

        traverse(head);
    }
}
