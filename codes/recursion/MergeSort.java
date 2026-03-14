import java.util.ArrayList;
public class MergeSort{

    public static void merge_diff(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void merge(int [] arr, int left ,int mid, int right){

        // make one result list : 
        ArrayList<Integer> temp = new ArrayList<>();
  

        int l = left;
        int r = mid+1;

        while(l <= mid && r <= right){

            if(arr[l] <= arr[r]){
                temp.add(arr[l]);
                l++;
            }else {
                temp.add(arr[r]);
                r++;
            }
        }
        while(l <= mid){
            temp.add(arr[l]);
            l++;
        }
        while(r <= right){
            temp.add(arr[r]);
            r++;
        }
        // map temp list to original array : 
        for(int i = left ;i<= right;i++){
            arr[i] = temp.get(i-left);
        }
    }

    public static void mergeSort(int [] arr , int left , int right){
        // base case : 
        if(left >= right){
            return ;
        }
        // mid find out : 
        int mid = left + (right -left)/2;
        // left half recursion call : 
        mergeSort(arr,left,mid);
        // right half recursion call : 
        mergeSort(arr,mid+1,right);

        // merge left and right half : 
        merge(arr, left, mid, right);
    }
    public static void main(String [] args){
        int [] arr = {1,4,3,2,7,5,9};
        // sorted form : 1,2,3,4,5,7,9
        mergeSort(arr,0,arr.length-1);
        for( int val : arr){
            System.out.print(val+" ");
        }
    }
}