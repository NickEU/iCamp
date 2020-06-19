package icamp.aArraysAndStrings.ic04ArrayPartitioning.dutchNationalFlag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

//  You are given an array of integers and a pivot.
//  Rearrange the array in the following order:
//  [all elements less than pivot, elements equal to pivot, elements greater than pivot]

// Notes:
// No need to preserve the original order
// No need to sort the items

public class Solution {
  public static void main(String[] args) {
    int[] input = {5, 2, 4, 4, 6, 4, 4, 3, 4};
    int[] actual = solveInPlace(Arrays.copyOf(input, input.length), 4);
    int[] expected = {2, 3, 4, 4, 4, 4, 4, 6, 5};
    System.out.println(Arrays.toString(actual));
    System.out.println(Arrays.equals(actual, expected));

  }

  private static int[] solveInPlace(int[] input, int pivot) {
    int lessThanPtr = 0;
    int tailPtr = input.length - 1;

    for (int i = lessThanPtr; i <= tailPtr; ) {
      int currEl = input[i];
      if (currEl > pivot) {
        swap(input, i, tailPtr--);
        continue;
      }
      if (i > 0 && input[i - 1] == pivot && input[i] < pivot) {
        swap(input, i - 1, i);
        i--;
        continue;
      }
      i++;
    }

    return input;
  }

  private static void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }

  private static int[] solveUsingAuxArrays(int[] input, int pivot) {
    ArrayList<Integer> smaller = new ArrayList<>();
    ArrayList<Integer> bigger = new ArrayList<>();
    ArrayList<Integer> equal = new ArrayList<>();

    for (int currEl : input) {
      if (currEl > pivot) {
        bigger.add(currEl);
      } else if (currEl < pivot) {
        smaller.add(currEl);
      } else {
        equal.add(currEl);
      }
    }

    IntStream firstPart =
        IntStream.concat(smaller.stream().mapToInt(x -> x), equal.stream().mapToInt(x -> x));
    return IntStream.concat(firstPart, bigger.stream().mapToInt(x -> x)).toArray();
  }
}
