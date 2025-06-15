public class RemoveDuplicatesInPlace {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};

        int n = arr.length;

        // egdes case
        if(n==0){
            System.out.println(arr[n-1]);
        }

        int j=0;
        for(int i=1;i<n;i++){
            if(arr[j] != arr[i]){
                j++;
                arr[j]= arr[i];
                System.out.println("arr["+j+"]"+" = "+"arr["+i+"]");
            }
        }
        System.out.println();
        System.out.println("unique elements : ");
        for(int i=0;i<=j;i++){
            System.out.print(arr[i]+ " ");
        }

    }
}
