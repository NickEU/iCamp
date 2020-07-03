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

public class Solution {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5};
    printSubsetsHelper(input);
  }

  private static void printSubsetsHelper(int[] input) {
      printAllSubsets(input, new int[input.length], 0, 0);
  }

  private static void printAllSubsets(
      int[] nums, int[] buffer, int numPos, int bufPos) {
    printArray(buffer, bufPos);
    if (bufPos == buffer.length || numPos == nums.length) {
      return;
    }

    for (int i = numPos; i < nums.length; i++) {
      buffer[bufPos] = nums[i];
      printAllSubsets(nums, buffer, i + 1, bufPos + 1);
    }
  }

  private static void printArray(int[] arr, int upToIdx) {
    StringBuilder result = new StringBuilder("[");
    for (int i = 0; i < upToIdx; i++) {
      result.append(arr[i]);
      if (i < upToIdx - 1) {
        result.append(", ");
      }
    }
    System.out.println(result.append("]"));
  }
}
