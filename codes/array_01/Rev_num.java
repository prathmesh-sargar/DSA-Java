public class Rev_num {
    public static void main(String[] args) {
        
        int num = 1234;

        int rev = 0;

        while (num > 0) {
            
            int digit = num %10;
            rev = 10 *rev +digit;
            num = num/10;
        }
        System.out.println("rev : "+rev);
    }
}
