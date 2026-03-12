public class Power_of_x {


   public static double solve(double x , long n){

      if(n==0) return 1;
      if(n <0){
        return solve(1/x, -n);
      }
      if(n %2 ==0 ){
        return solve(x*x , n/2);
      }else{
        return x* solve(x*x , (n-1)/2);
      }
   }

  public static void main(String[] args){
      
     double x = 6;
     int n = 2;
      double ans = solve(x , (long)n);
     System.out.println("power of "+x+ " is "+n+ " = "+ans);
  }
}