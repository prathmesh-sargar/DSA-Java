public class Print_1_N_Backtrack{

    public static int print(int n){
       // base case : 
       if(n <=0) return 0;
        // backtrack fun : 
        print(n-1);
        System.out.println(n);

        return 0;
    }
    public static void main(String [] args){
        int n = 4;
        print(n);
    }
}