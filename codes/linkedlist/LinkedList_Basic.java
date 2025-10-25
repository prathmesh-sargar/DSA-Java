

class Node{
    int data;
    Node next;
    public String val;

    Node(int data){
        this.data = data;
        this.next = next;
    }
}


public class LinkedList_Basic{

    public static void Tranverse(Node head){

        if(head == null) return;
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+ " -->");
            curr = curr.next;
        }
        System.out.print("Null");
    }


    public static void InsertFirst(Node head , int val){

        // create new node 
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }else{
            newNode.next = head;
            head = newNode;
        }
        Tranverse(head);
    }

    public static void InsertLast(Node head, int val){

        // create new node:
        Node newNode = new Node(val);
        if(head == null) head = newNode;

        Node curr = head;
        while (curr.next !=null){
            curr = curr.next;
        }
        curr.next = newNode;

        Tranverse(head);

    }

    public static void InsertToPosition(Node head ,int val, int postion){
        // create new node : 
        Node newNode = new Node(val);
      
        if(postion ==1){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node curr = head;
        // loop to reach last to given postion : 
        for(int i=1;i<postion-1 && curr != null;i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;


        Tranverse(head);
    }


    public static void deleteFirst(Node head){

        if(head != null){
             head = head.next;
        }
        Tranverse(head);

    }

    public static void deleteLast(Node head){
        if(head == null) return;
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        Tranverse(head);
    }

    public static void deleteToPosition(Node head, int postion){
        if(head == null) return;
        if(postion ==1){
            head = head.next;
            return;
        }
        Node curr = head;
        for(int i=1;i<postion-1 && curr !=null;i++){
            curr = curr.next;
        }
        if(curr == null || curr.next == null) return;
        curr.next = curr.next.next;

        Tranverse(head);
    }

    
    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Tranverse(head);
        System.out.println();

        // InsertFirst(head,5);
        // InsertLast(head, 10);
        // InsertToPosition(head,10,2);

        // deleteFirst(head);
        // deleteLast(head);
        // deleteToPosition(head,3);
  
    }
}