// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]


public class Add_Two_Numbers {

     public static void traverse(Node head){
        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }



    public static Node addTwoNumbers(Node l1,Node l2){
        
        // base case : 
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        // two lists pointers : 
        Node ptr1 = l1;
        Node ptr2 = l2;

        // dummy temp list node : 
        Node dummy = new Node(-1);
        Node ans = dummy;

        // if some >=10 : 
        int carry = 0;

        while (ptr1 != null || ptr2 != null) {
            
            int val1 = ptr1 != null? ptr1.data :0;
            int val2 = ptr2 !=null ? ptr2.data :0;

            int sum = val1+val2 +carry;

            int d = sum %10;
            carry = sum /10;

            // create Node : 
            Node temp = new Node(d);
            dummy.next = temp;
            dummy = dummy.next;

            // move pointers of list l1 & l2 : 
            ptr1 = ptr1 != null ? ptr1.next :null;
            ptr2 = ptr2 !=null ?  ptr2.next :null;
        }
        // if carry is remaining something : 
        if(carry >0){
            Node temp = new Node(carry);
            dummy.next = temp;
            dummy = dummy.next;
        }
        return ans.next;
    }
    public static void main(String[] args) {

        // list 1 : 
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(6);

        // list 2 : 
        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(4);
        list2.next.next.next = new Node(5);
        traverse(list1);
        System.out.println();
        traverse(list2);

        System.out.println();
        System.out.println("adding two number list is :");

        Node head = addTwoNumbers(list1, list2);
        traverse(head);
       
    }
}
