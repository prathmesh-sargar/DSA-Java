// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]

// Example 4:
// Input: head = [1,2,3]
// Output: [2,1,3]

public class Swap_Nodes_in_Pairs {

    public static void traverse(Node head){

       Node curr = head;
       while (curr != null) {
            System.out.print(curr.data+ "--->");
            curr = curr.next;
       }
       System.out.print("null");
    }

    public static Node swapNode(Node head){

        // base condition : 
        int count =0;
        Node node = head;
        while (node !=null && count <2) {
            count++;
            node = node.next;
        }
        if(count < 2){
            return head;
        }
        // reverse 2 groups of nodes : 
        Node prev = null;
        Node curr = head;
        Node next = null;
        for(int i=0;i<2;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = swapNode(curr);

        // return prev is the start of reverse groups 
        return prev;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);
        list1.next.next.next.next.next = new Node(6);
        traverse(list1);
        System.out.println();
         Node ans =  swapNode(list1);
         traverse(ans);
        
    }
}
