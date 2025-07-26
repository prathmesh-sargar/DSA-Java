public class Add_Strings {

    public static String addition(String s1 ,String s2){


        int i = s1.length()-1;
        int j= s2.length()-1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >=0 || j>=0 || carry !=0) {
            
            int digit1 = i>=0 ? s1.charAt(i)-'0':0;
            int digit2 = j>=0 ? s2.charAt(j)-'0':0;

            int total = digit1 + digit2 + carry;

            carry = total /10;

            sb.append(total % 10);

            i--;
            j--;

        }
        // System.out.println(sb.toString());
        return sb.reverse().toString();
    }

    public static void main(String[] args){

        String s1 = "120";
        String s2 = "30";

        String result = addition(s1, s2);
        System.out.println("addition is : "+result);
    }
}
