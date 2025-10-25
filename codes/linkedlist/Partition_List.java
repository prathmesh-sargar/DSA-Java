// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

// Example 1:
// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]

// Example 2:
// Input: head = [2,1], x = 2
// Output: [1,2]

public class Partition_List {

      public static void traverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }



    public static Node partitionList(Node head,int x){
        Node beforeHead = new Node(-1);
        Node afterHead = new Node(-1);

        Node before = beforeHead;
        Node after = afterHead;

        while (head != null) {
            
            if(head.data < x ){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);
        traverse(head);
        System.out.println();
        Node ans = partitionList(head, 3);
        traverse(ans);

       
    }
}
