// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]

// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]

public class Remove_Duplicates_from_Sorted_List {

    public static void traverse(Node head){
        if(head == null) return;
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }

    public static Node removeDuplicates(Node head){

        Node curr = head;
        while (curr != null && curr.next != null) {
            
            if(curr.data == curr.next.data){
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
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        traverse(head);
        System.out.println();
        Node ans = removeDuplicates(head);
        traverse(ans);
    }
}
