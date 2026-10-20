package basics;

import java.util.Arrays;
import java.util.random.RandomGenerator;

public class TooDeeBasics {
    public static void main(String[] args) {
        // to be used later
        RandomGenerator gen = RandomGenerator.getDefault();

        final int OUTER_LEN = 10;
        final int INNER_LEN = 10;

        // instantiate an array
        int[][] mat1 = new int[OUTER_LEN][INNER_LEN];
        
        // modify elements of an array
        // update the element at [4, 4]
        mat1[4][4] = 10;

        // Access elements of an array
        // get the value at [4, 4]
        int val = mat1[4][4];

        // initialize all values on creation
        // array initializer
        int [][] mat2 = {{0, 1, 0},{1, 0, 1},{0, 0, 1}};

        // full linear forward traversal
        for(int i = 0; i < mat1.length; i++){
            // current inner array length
            int innerLength = mat1[i].length; // you don't need to do it this way!
            for(int j = 0; j < innerLength; j++){
                // generate randoms
                int rand = gen.nextInt(5, 15);
                mat1[i][j] = rand;
            }
        }

    }

    public static void printArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + ", ");
            }
        }
        System.out.println();
    }

    public static void printArrayEnhanced(int[][] arr){
        for(int[] inner: arr){
            for(int num: inner){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

    public static void printEasyMode(int[][] arr){
        for(int[] inner: arr){
            String arrStr = Arrays.toString(arr);
            System.out.println(arrStr);
        }
    }
}
