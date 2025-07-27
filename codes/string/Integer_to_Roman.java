//  // create arrays of value and symbol of roman no's 
//         int [] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//         String [] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
// /

public class Integer_to_Roman{

    public static String intToRoman(int num){

     int [] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
     String [] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


     StringBuilder sb = new StringBuilder();

     for(int i=0;i<values.length;i++){

        while (num >=values[i]) {
            num = num-values[i];
            sb.append(symbols[i]);
        }
     }
        return sb.toString();
    }
    public static void main(String[] args) {

        int num = 1994;
        String roman = intToRoman(num);
        System.out.println("Roman no : "+roman);
    }
}