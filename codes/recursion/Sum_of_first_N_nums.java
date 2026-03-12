public class Sum_of_first_N_nums{

    public static int sumall(int n){
        if(n==0){
            return 0;
        }
        return n+ sumall(n-1);
    }
    public static void main(String [] args){
       int n =5;
       int ans = sumall(n);
       System.out.println("ans :"+ans);
    }
}