// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

public class Reverse_Nodes_in_k_Group{


    public static void Tranverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }

    public static Node reverseKGroups(Node head,int k){

        // base condition : valid k nodes : 
        int count =0;
        Node node = head;
        while(node !=null && count < k){
            node = node.next;
            count++;
        }
        if(count < k){
            return head;
        }

        // reverse k groups nodes : 
        Node prev = null;
        Node curr = head;
        Node next = null;
        for(int i=0;i<k;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr  = next;
        }

        // recursively calls : 
        head.next = reverseKGroups(curr, k);

        // prev is starting node of any recursive calls : 
        return prev;
    }
    
    public static void main(String[] args) {
         Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);
        Tranverse(list1);
        System.out.println();
        int k = 2;

         Node ans =  reverseKGroups(list1,k);
         Tranverse(ans);
    }
}