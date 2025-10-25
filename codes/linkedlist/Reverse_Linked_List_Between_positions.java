public class Reverse_Linked_List_Between_positions {

     public static void traverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }

    public static Node reverseBetweenPostions(Node head,int left ,int right){

        Node dummy = new Node(-1);
        dummy.next = head;
        Node ans = dummy;

        Node leftpre = dummy;
        Node currnode = head;

        //  gp upto start of sublist : 
        for(int i=0;i<left-1;i++){
            leftpre = leftpre.next;
            currnode = currnode.next;
        }

        Node sublistHead = currnode;
        Node prenode = null;
        for(int i=0;i<right-left+1;i++){
            Node next = currnode.next;
            currnode.next = prenode;
            prenode = currnode;
            currnode = next;
        }

        leftpre.next = prenode;
        sublistHead.next = currnode;

        return ans.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        
        traverse(head);
        System.out.println();
        int left = 2;
        int right = 5;
        Node ans =  reverseBetweenPostions(head, left, right);
        traverse(ans);
    }
}
