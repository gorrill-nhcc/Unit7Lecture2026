package basics;

import java.util.ArrayList;

public class TooDeeTraversals {
    public static void main(String[] args) {
        
    }

    public static void printReverse(int[][] arr){
        for(/*fill this in*/){
            for(/*fill this in*/){
                System.out.println(arr[?][?] + ", ");
            }
        }
    }

    public static void telescopeTraversal(int[][] arr){
        //forward on even rows, backward on odd rows
        for(int i = 0; i < arr.length; i++){
            // you need two traversals in here
            // i is even, traverse forward
            // i is odd, traverse backward
        }
    }
    // select all based on defined criteria
    public static ArrayList<Integer> selectOnlyOdd(int[][] arr){
        ArrayList<Integer> out = new ArrayList<>();
        for(int[] inner : arr){
            for(int n : inner){
                if(n % 2 == 0){
                    out.add(n);
                }
            }
        }
        return out;
    }

    // cell validation
    public static boolean validCell(int[][] arr, int row, int col){
        boolean valid = true;
        boolean validRow = row >= 0 && row < arr.length;
        boolean validCol = validRow && col >= 0 && col < arr[row].length;
        valid = validRow && validCol;
        return valid;
    }
}
