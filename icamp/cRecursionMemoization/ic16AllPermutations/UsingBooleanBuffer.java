package icamp.cRecursionMemoization.ic16AllPermutations;

import java.util.Arrays;

public class UsingBooleanBuffer {
        public static void main(String[] args) {
            int[] input = {1, 2, 3, 4, 5, 6, 7};
            int size = 4;
            printAllPermutations(input, new int[size], 0, new boolean[input.length]);
        }

        private static void printAllPermutations(int[] input, int[] buf, int bufPos, boolean[] isInBuffer) {
            if (bufPos == buf.length) {
                System.out.println(Arrays.toString(buf));
                return;
            }

            for (int i = 0; i < input.length; i++) {
                if (!isInBuffer[i]) {
                    buf[bufPos] = input[i];
                    isInBuffer[i] = true;
                    printAllPermutations(input, buf, bufPos + 1, isInBuffer);
                    isInBuffer[i] = false;
                }
            }
        }
}
