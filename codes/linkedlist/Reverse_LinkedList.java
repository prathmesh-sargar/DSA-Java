// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

public class Reverse_LinkedList{

        public static void Tranverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.val+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }


    public static void Reverse(Node head){
        Node prev = null;
        while (head !=null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        Tranverse(prev);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Tranverse(head);
        System.out.println();
        Reverse(head);
    }
}