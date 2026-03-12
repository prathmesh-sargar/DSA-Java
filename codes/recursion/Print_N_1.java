public class Print_N_1{

    public static int print(int n){
        // base case : 
        if(n <= 0) return 0;
        System.out.println(n);
        // recursive fun : 
        print(n-1);
        return 0;
    }
    public static void main(String [] args){
        int n =4;
        print(n);
    }
}