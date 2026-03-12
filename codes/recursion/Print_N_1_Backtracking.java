public class Print_N_1_Backtracking{

    public static int print(int s,int n){

        // base case : 
        if(s >n) return 0;

        print(s+1,n);
        System.out.println(s);

        return 0;
    }
    public static void main(String [] args){
        int n=4;
        int s =1;
        print(s,n);
    }
}