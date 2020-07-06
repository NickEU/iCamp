package icamp.cRecursionMemoization.ic16AllPermutations;

import java.util.Arrays;

// Input:
//A = [1,2,3]
//X = 2
//Output:
//[1, 2]
//[1, 3]
//[2, 1]
//[2, 3]
//[3, 1]
//[3, 2]
public class BadSolution {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int size = 2;
        printAllPermutations(input, new int[size], 0);
    }

    private static void printAllPermutations(int[] input, int[] buf, int bufPos) {
        if (bufPos == buf.length) {
            System.out.println(Arrays.toString(buf));
            return;
        }

        for (int curEl : input) {
            //System.out.println("ins = " + Arrays.toString(buf));
            if (Arrays.stream(buf).noneMatch(x -> x == curEl)) {
                buf[bufPos] = curEl;
                printAllPermutations(input, buf.clone(), bufPos + 1);
            }
        }
    }
}
