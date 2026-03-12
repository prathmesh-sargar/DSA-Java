// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

// Example 1:
// Input: n = 5, bad = 4
// Output: 4
// Explanation:
// call isBadVersion(3) -> false
// call isBadVersion(5) -> true
// call isBadVersion(4) -> true
// Then 4 is the first bad version.

// Example 2:
// Input: n = 1, bad = 1
// Output: 1
 

public class First_Bad_Version {

    public static boolean isBadVersion( int version){
        int badversion = 4;
        if(badversion <= version){
            return true;
        }
        return false;
    }

    public static int firstBadVersion(int version){
        int start = 1;
        int end = version;
        int ans = -1;
        while (start <= end) {
            int mid_v = start + (end -start)/2;
            if(isBadVersion(mid_v)){
                ans = mid_v;
                System.out.println("bad version  "+ans);
                end = mid_v -1;
            }else{
                start = mid_v +1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int current_bad_v = 10;
        int first_bad_v = firstBadVersion(current_bad_v);
        System.out.println("First bad version is : "+first_bad_v);
    }
}
