// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []

import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {

     public static void traverse(Node head){

       Node curr = head;
       while (curr != null) {
            System.out.print(curr.data+ "--->");
            curr = curr.next;
       }
       System.out.print("null");
    }

    public static Node mergeKSortedNode(Node [] lists){

        if(lists.length ==0 ){
            return null;
        }
        else if (lists.length ==1) {
            return lists[0];
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.data - b.data);
        // loop over lists : 
        for(int i=0;i<lists.length;i++){
            Node temp = lists[i];
            while (temp != null) {
                pq.add(temp);
                temp = temp.next;
            }
        }

        // traverse over it : 
        Node dummy = new Node(-1);
        Node ans = dummy;

        while (pq.size() >0) {
            Node node = pq.remove();
            dummy.next = node;
            dummy = dummy.next;
        }
        dummy.next = null;

        return ans.next;
    }
    public static void main(String[] args) {
        
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(5);

        Node l3 = new Node(5);
        l3.next = new Node(6);

        Node [] lists = {l1,l2,l3};

        Node merge = mergeKSortedNode(lists);
        traverse(merge);
        
    }
}
