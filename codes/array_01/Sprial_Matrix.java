// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sprial_Matrix {

    public static void spiral_list(int[][]matrix){

        
        List<Integer>list= new  ArrayList<>();

        
        // four variables : 
        int rowBegine = 0;
        int rowEnd = matrix.length-1;
        int colBegine = 0;
        int colEnd = matrix[0].length-1;


        while (rowBegine <=rowEnd && colBegine <=colEnd) {
            
            // traverse left  :
            for(int i=colBegine;i<=colEnd;i++){
                list.add(matrix[rowBegine][i]);
            }
            rowBegine++;

            // travverse down : 
            for(int i=rowBegine;i<=rowEnd;i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            // traverse left  (Reverse)

            if(rowBegine <=rowEnd){

                for(int i = colEnd; i>=colBegine;i--){
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // traverse up (reverse)
            if(colBegine <=colEnd){

                for(int i=rowEnd;i>=rowBegine;i--){
                    list.add(matrix[colBegine][i]);
                }
                colBegine++;
            }
        }     


        for (Integer val : list) {
            System.out.print(val+" -> ");
        }
    }
    public static void main(String[] args) {
        
        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};

        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
        spiral_list(matrix);
    }


}

