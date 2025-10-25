// Given the head of a linked list, return the list after sorting it in ascending order.

// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []

public class Sort_List{
    public static void traverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }

    public static Node sortList(Node head){

        // base condition 
        if(head == null || head.next == null){
            return head;
        }
        // 3 pointers : 
        Node prev = null;
        Node slow = head;
        Node fast = head;
        // find middle and seprate : 
        while (fast != null && fast.next != null) {
            prev = slow;
            slow  =slow.next;
            fast = fast.next.next;
        }
        prev.next = null;    // first half list 
        // call two seprate lists : 
        Node l1 = sortList(head);
        Node l2 = sortList(slow);


        return merge(l1, l2);        
    }


    public static Node merge(Node l1 , Node l2){

        if(l1 == null && l2 == null){
            return null;
        }

        Node dummy = new Node(-1);
        Node ans = dummy;

        Node ptr1 = l1;
        Node ptr2 = l2;
        // compare values : 

        while (ptr1 != null && ptr2 != null) {
            if(ptr1.data < ptr2.data){
            dummy.next = ptr1;
            ptr1 = ptr1.next;
            }else{
                dummy.next = ptr2;
                ptr2 = ptr2.next;
            }
            dummy = dummy.next;
        }
        if(ptr1 == null){
            dummy.next = ptr2;
        }else{
            dummy.next = ptr1;
        }
        
        return ans.next;
    }

    public static void main(String[] args) {
         Node list1 = new Node(4);
        list1.next = new Node(2);
        list1.next.next = new Node(1);
        list1.next.next.next = new Node(3);
        list1.next.next.next.next = new Node(5);
        traverse(list1);
        System.out.println();
       Node ans =  sortList(list1);
        traverse(ans);
    }
}