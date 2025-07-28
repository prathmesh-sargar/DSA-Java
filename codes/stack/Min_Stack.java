// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// Implement the MinStack class:
// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

// Example 1:
// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2

import java.util.Stack;

public class Min_Stack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // constructor : 
    Min_Stack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val){
        stack.push(val);
        if(minStack.size() ==0 || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    public void pop(){

        int val1 = stack.pop();
        int val2 = minStack.peek();

        if(val1 == val2){
            minStack.pop();
        }
    }

    public int peek(){

        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
    
    public static void main(String[] args) {
        
        Min_Stack obj = new Min_Stack();
        obj.push(12);
        obj.push(-2);
        obj.push(10);
        obj.push(-3);
        obj.push(0);
        System.out.println("getmin value : "+obj.getMin());

    }
}
