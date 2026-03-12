public class Fact_of_first_N_nums{

    public static int fact(int n){

        // base condition: 
        if(n ==1) return 1;
        return n * fact(n-1);
    }

    public static void main(String [] args){
        int n = 5;
        int ans = fact(n);
        System.out.println("factorial of "+n+" is "+ans);
    }
}