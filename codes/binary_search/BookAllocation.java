

public class BookAllocation {

  public static boolean canallocate(int[] pages , int maxpages , int m){

    int student =1;
    int maxallocate =0;
    for(int page : pages){
       if(maxallocate + page > maxpages){
          student++;
          maxallocate = 0;
       }
       maxallocate +=page;
    }
    return student <= m;
  }

  public static int allocateBooks(int []pages ,int m){
    int low = 0;
    int high =0;
    int n = pages.length;

    if(m > n) return -1;

    for(int page : pages){
       low = Math.max(low,page);
       high += page;
    }
    int ans = high;
    while(low <= high){
      int mid = low + (high - low)/2;
      if(canallocate(pages,mid,m)){
        ans = mid;
        high = mid-1;
      }else{
        low = mid+1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
     int [] pages = {12, 34, 67, 90};
     int m = 2;
     int ans = allocateBooks(pages , m);
     System.err.println(ans);
  }
}