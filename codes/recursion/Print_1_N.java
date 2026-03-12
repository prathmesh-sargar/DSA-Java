public class Print_1_N{

    public static int print(int i , int n){

        // base condition : 
        if(i >n) return 0;
        System.out.println(i);
        print(i+1,n);

        return 0;
    }
    public static void main(String [] args){

        int n =4;
        print(1,n);

    }
}