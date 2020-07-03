package icamp.cRecursionMemoization.ic15PrintAllSubsets;

// Given an array of integers A, print all its subsets.
// For example:
// Input:​ [1, 2, 3]
// Output:
// []
// [1]
// [2]
// [3]
// [1, 2]
// [1, 3]
// [2, 3]
// [1, 2, 3]

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5};
    printAllSubsets(input);
  }

  private static void printAllSubsets(int[] input) {
    for (int i = 0; i <= input.length; i++) {
      System.out.println("ALl subsets of size " + i + ":");
      printAllCombinations(input, new int[i], 0, 0);
      System.out.println("\n");
    }
  }

  private static void printAllCombinations(
      int[] nums, int[] buffer, int numPos, int bufPos) {
    if (bufPos == buffer.length) {
      System.out.print(Arrays.toString(buffer) + " ");
      return;
    }

    if (numPos == nums.length) {
      return;
    }

    for (int i = numPos; i < nums.length; i++) {
      buffer[bufPos] = nums[i];
      printAllCombinations(nums, buffer, i + 1, bufPos + 1);
    }
  }
}
