public class Multiply_Strings {


    public static String multiplyString(String s1,String s2){

        int m = s1.length();
        int n = s2.length();

        int []arr = new int[m+n];

        // nested loops over given Integer Strings : 
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (s1.charAt(i)-'0')* (s2.charAt(j)-'0');

                int p1 = i+j;   // tenth place
                int p2 = i+j+1;  // unit place 
                int sum = mul +arr[p2];
                arr[p1] +=sum/10;
                arr[p2] = (sum)%10;
            }
        }
        // for (int val : arr) {
        //     System.out.print(val+"  ");
        // }

        StringBuilder sb = new StringBuilder();

        for (int p : arr) {
            
            if(!(sb.length() ==0 && p==0)){
                sb.append(p);
            }
        }

        return sb.length() ==0 ? "0":sb.toString();
    }

    public static void main(String[] args){
        String s1 = "123";
        String s2 = "10";
        String result = multiplyString(s1,s2);
        System.out.println("multiply two String : "+result);
    }
}
