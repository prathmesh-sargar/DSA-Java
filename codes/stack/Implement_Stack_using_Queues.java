//  To implent stack using Queue 
//  in this we create two stack 
// main stack : 
// helper stack :

import java.util.ArrayDeque;
import java.util.Queue;


public class Implement_Stack_using_Queues {

       
     private Queue<Integer> main;
     private Queue<Integer> helper;


     Implement_Stack_using_Queues(){
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
     }


    public  void push(int val){
       
      while (main.size() > 0) {
         helper.add(main.remove());
      }

      main.add(val);

      while (helper.size() > 0) {
         main.add(helper.remove());
      }

    }
    public  int pop(){
       return main.remove();
    }
    public int peek(){
       return main.peek();
    }
  public static void main(String[] args) {
     
    Implement_Stack_using_Queues obj = new Implement_Stack_using_Queues();
    obj.push(12);
    obj.push(10);
    obj.push(30);

    System.out.println(obj.pop());
    System.out.println(obj.peek());
  }   
}
