public class Reverse_Array_By_Recursion{

    public static void swap(int l ,int[]nums,int r){
        int temp= nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    
    public static void reverse(int l ,int nums[], int r){
        // base case : 
        // if(s >=n/2) return true;

        if(l >= r) return ;  // base case;
        swap(l,nums,r);
        reverse(l+1, nums, r-1);
    }
    public static void main(String [] args){

        int nums[] = {1,3,2,5,4};
        // for(int val :nums){
        //     System.out.print(val+"  ");
        // }
        // System.out.println();
        int l = 0;
        int r= nums.length-1;
        reverse(l,nums,r);
        for(int val :nums){
            System.out.print(val+"  ");
        }
    }
}