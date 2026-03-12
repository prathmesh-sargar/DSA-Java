public class Factorial_using_Recursion{

  public static int nthfactorial(int n){

    if(n <2) return n;

    return n * nthfactorial(n-1);
  }

  public static void main(String[] args){
    int n = 5;
    int ans = nthfactorial(n);
    System.out.println("factorial of "+n+" is :"+ans);
    
  }
}