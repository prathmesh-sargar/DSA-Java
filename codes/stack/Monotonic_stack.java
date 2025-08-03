
// Input array: [4, 5, 2, 10, 8]

// Next greater element: [5, 10, 10, -1, -1]
// Previous greater element: [-1, -1, 5, -1, 10]
// Next smaller element: [2, 2, -1, 8, -1]
// Previous smaller element: [-1, 4, -1, 2, 2]

import java.util.Stack;

public class Monotonic_stack {



    public static void nextGreaterElement(int []arr){
        int n = arr.length;
        int []res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1;i>=0;i--){

            while (!stack.isEmpty() && arr[i] >=stack.peek()) {
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int val : res) {
            System.out.print(val+ " ");
        }
        System.out.println();
    }

    public static void nextSmallerElement(int []arr){
        int n = arr.length;
        int []res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1;i>=0;i--){

            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        for (int val : res) {
            System.out.print(val+ " ");
        }
        System.out.println();
    }

    public static void previousGreaterElement(int []arr){
        int n = arr.length;
        int []res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){

            while (!stack.isEmpty() && arr[i]>=stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        for (int val : res) {
            System.out.print(val+ " ");
        }
        System.out.println();
    }

    public static void previousSmallerElement(int []arr){
        int n = arr.length;
        int []res = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n;i++){

            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
         
        for (int val : res) {
            System.out.print(val+ " ");
        }
    }
    public static void main(String[] args) {
        
        int [] array = {4, 5, 2, 10, 8};

        nextGreaterElement(array);
        nextSmallerElement(array);
        previousGreaterElement(array);
        previousSmallerElement(array);
       
    }
}
