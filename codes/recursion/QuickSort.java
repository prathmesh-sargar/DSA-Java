public class QuickSort{

    public static void swap(int []arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high){

        int pivot = arr[low];

        int i= low;
        int j = high;

        while(i <j){

            while(arr[i] <= pivot && i <= high+1){
                i++;
            }

            while(arr[j] > pivot && j >= low+1){
                j--;
            }

            if(i <j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;
    }

    public static void quickSort(int []arr, int low, int high){

        if(low < high){

            // pivote idx : 
            int pivotIdx = partition(arr,low, high);

            // recursive calls left and right halfs : 
            quickSort(arr,low,pivotIdx-1);
            quickSort(arr, pivotIdx+1,high);
        }
    }
    public static void main(String [] args){
        int [] arr = {1,4,3,2,7,5,9};
        // sorted form : 1,2,3,4,5,7,9
        quickSort(arr,0,arr.length-1);
        for( int val : arr){
            System.out.print(val+" ");
        }
    }
}