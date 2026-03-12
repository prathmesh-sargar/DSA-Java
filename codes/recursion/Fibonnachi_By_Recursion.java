public class Fibonnachi_By_Recursion{
    public static int fibo(int n){

        // base case : 
        if(n <=1){
            return n;
        }
        return fibo(n-1)+ fibo(n-2);
    }
    public static void main(String [] args){

        int nth = 6;
        // 0 1 2 3 5 8 
        int ans = fibo(nth);
        System.out.println("fibonnachi of "+nth+" is : "+ans);
    }
}