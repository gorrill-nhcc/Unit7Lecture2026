package basics;

import java.util.ArrayList;

public class TooDeeTraversals {
    public static void main(String[] args) {
        
    }

    public static void printReverse(int[][] arr){
        for(int i = arr.length - 1; i >= 0; i--){ // row loop
            for(int j = arr[i].length - 1; j >= 0; j--){
                System.out.println(arr[i][j] + ", ");
            }
        }
    }

    public static void telescopeTraversal(int[][] arr){
        //forward on even rows, backward on odd rows
        for(int i = 0; i < arr.length; i++){
            // you need two traversals in here
            // i is even, traverse forward
            // i is odd, traverse backward
            if(i % 2 == 0){
                for(int j = 0; j < arr[i].length; j++){
                    System.out.println(arr[i][j] + ", ");
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.println(arr[i][j] + ", ");
                }
            }
        }
    }
    // select all based on defined criteria
    public static ArrayList<Integer> selectOnlyOdd(int[][] arr){
        ArrayList<Integer> out = new ArrayList<>(); // List size() == 0

        for(int[] inner : arr){
            for(int n : inner){
                if(n % 2 != 0){
                    out.add(n); // append - adds the item to the end of the list
                }
            }
        }
        return out;
    }

    // cell validation
    // validCell(mat1, -5, 5) -> mat1.length == 10 mat1[0] == 8
    public static boolean validCell(int[][] arr, int row, int col){
        boolean valid = true;
        boolean validRow = row >= 0 && row < arr.length;
        boolean validCol = validRow && col >= 0 && col < arr[row].length;
        valid = validRow && validCol;
        return valid;
    }
}
