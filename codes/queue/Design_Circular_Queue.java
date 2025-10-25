// Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

// One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

// Implement the MyCircularQueue class:

// MyCircularQueue(k) Initializes the object with the size of the queue to be k.
// int Front() Gets the front item from the queue. If the queue is empty, return -1.
// int Rear() Gets the last item from the queue. If the queue is empty, return -1.
// boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
// boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
// boolean isEmpty() Checks whether the circular queue is empty or not.
// boolean isFull() Checks whether the circular queue is full or not.
// You must solve the problem without using the built-in queue data structure in your programming language. 




class MyCircularQueue{

    private int[] data;
    int front;
    int rear;
    int size;

   public MyCircularQueue(int k){
       data = new int[k];
       front = -1;
       rear = -1;
       size =0;
    }

    public boolean enQueue(int value){
        if(isFull()) return false;
        if(size ==0){
            front = 0;
        }
        rear +=1;
        rear = rear %data.length;
        data[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()) return false;
        front +=1;
        front = front % data.length;
        size--;
        if(size ==0){
            front =-1;
            rear =-1;
        }
        return true;
    }

    public int Front(){
        return data[front];
    }
    public int Rear(){
        return data[rear];
    }
    public  boolean isEmpty(){
        if(size ==0) return true;
        return false;
    }
    public boolean isFull(){
        if(size == data.length) return true;
        return false;
    }

}




public class Design_Circular_Queue{
    public static void main(String[] args) {
        

        MyCircularQueue obj = new MyCircularQueue(5);
        boolean param_1 = obj.enQueue(10);
        boolean param_2 = obj.enQueue(20);
        boolean param_3 = obj.enQueue(30);
        boolean param_4 = obj.deQueue();
        int param_5 = obj.Front();
        int param_6 = obj.Rear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();


        System.out.println(param_1 +" "+param_2+" "+param_3+" "+param_4+" "+param_5+" "+param_6+" "+param_7+" "+param_8);


    }
}