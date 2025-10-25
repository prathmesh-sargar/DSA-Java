// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
// For example, the following two linked lists begin to intersect at node c1:

// The test cases are generated such that there are no cycles anywhere in the entire linked structure.
// Note that the linked lists must retain their original structure after the function returns.
// Custom Judge:

// The inputs to the judge are given as follows (your program is not given these inputs):
// intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
// listA - The first linked list.
// listB - The second linked list.
// skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
// skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
// The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.


public class Intersection_of_Two_Linked_Lists {


    public static int sizeLL( Node head){
        int count = 0;
        Node curr = head;
        while (curr !=null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static Node IntersectedNode(Node headA , Node headB){

        //base condition : 
        if(headA == null && headB == null){
            return null;
        }

        int sizeA = sizeLL(headA);
        int sizeB = sizeLL(headB);

        Node ptr1 = headA;
        Node ptr2 = headB;

        int diff = sizeA -sizeB;

        //  making same length of LinkedLists 
        if(diff > 0){
            while (diff >0) {
                ptr1 = ptr1.next;
                diff--;
            }
        }else{
            while (diff <0) {
                ptr2 = ptr2.next;
                diff++;
            }
        }

        // compare now 
        while (ptr1 !=ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {
     
    // Intersection means same memory reference, not same value.
    // When testing, always connect the lists to the same node object at the intersection point.    

        // shared part (intersection)
        Node intersect = new Node(8);
        intersect.next = new Node(4);
        intersect.next.next = new Node(5);

        // first LinkedList : 
        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = intersect;
        // headA.next.next.next = new Node(4);
        // headA.next.next.next.next = new Node(5);

        // 2 LinkedList : 
        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = intersect;
        // headB.next.next.next.next = new Node(4);
        // headB.next.next.next.next.next = new Node(5);

        Node intersectedNode = IntersectedNode(headA, headB);
        System.out.println(intersectedNode.data);

    }
}
