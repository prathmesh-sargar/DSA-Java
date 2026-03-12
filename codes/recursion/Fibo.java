public class Fibo {

  public static int nthfibo(int n){

    // base condition : 
    if(n <2) return n;

    return nthfibo(n-1) +nthfibo(n-2);
  }
  public static void main(String[] args) {
      int num = 6;
      System.err.println("fibonacci  of "+num+" is : "+nthfibo(num));
  }
}