// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.

// Example 1:
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

// Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]
 

public class Merge_Two_Sorted_Lists{


    public static void Tranverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }

    //  merge two LinkedLists : 
    public static void mergeTwoLists(Node list1 , Node list2){

        // create a dummy node : 
        Node dummy = new Node(-1);
        Node ans = dummy;

        Node ptr1 = list1;
        Node ptr2 = list2;

        // loop over lists : 
        while (ptr1 !=null && ptr2 !=null) {
            
            if(ptr1.data < ptr2.data){
                dummy.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                dummy.next = ptr2;
                ptr2 = ptr2.next;
            }
            dummy = dummy.next;
        }

        // size of lists are different : 
        if(ptr1 == null){
            dummy.next = ptr2;
            // dummy = dummy.next;
        }else{
            dummy.next = ptr1;
            // dummy = dummy.next;
        }
        Tranverse(ans.next);

    }
    public static void main(String[] args) {
        
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(6);

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(4);
        list2.next.next.next = new Node(5);

        mergeTwoLists(list1, list2);
    }
}