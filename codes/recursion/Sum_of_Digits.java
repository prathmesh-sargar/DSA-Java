public class Sum_of_Digits{

 public static int sumOfDigits(int n){

  // base condition 
  if(n==0) return 0;
  // recursive call relation : 
  return (n%10) + sumOfDigits(n/10);
 }

 public static int sumOfNaturalNumbers(int n){
      // base condition 
      if(n==0) return 0;
      // recursive call relation : 
      return n + sumOfNaturalNumbers(n-1);

 }   
  public static void main(String[] args) {
    int number = 12345;
    int result = sumOfDigits(number);
    System.out.println("The sum of digits in " + number + " is: " + result);
    int naturalNumber = 5;
    int naturalSum = sumOfNaturalNumbers(naturalNumber);  
    System.out.println("The sum of first " + naturalNumber + " natural numbers is: " + naturalSum);
  }

}