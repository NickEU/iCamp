package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane;

import java.util.Arrays;

public class Kadane {
  public static void main(String[] args) {
    Kadane s = new Kadane();
    int[] maxSubArr = s.getSubArrWithMaxSum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
    System.out.println(Arrays.toString(maxSubArr));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {-2, -10})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {2, -10, -5, 76})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {50})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {-2, -10, -17})));
  }

  private int[] getSubArrWithMaxSum(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = maxSum;
    int currSize = 0;
    SubArray result = null;

    for (int i = 0; i < nums.length; i++) {
      int currEl = nums[i];

      if (currSum < 0) {
        currSum = currEl;
        currSize = 1;
      } else {
        currSum += currEl;
        currSize++;
      }

      if (currSum > maxSum) {
        maxSum = currSum;
        result = new SubArray(i - currSize + 1, i + 1);
      }
    }

    if (result == null) {
      System.out.println("Error!");
      return null;
    }
    return result.buildNewSubArr(nums);
  }

  static class SubArray {
    private final int begin;
    private final int end;

    public SubArray(int begin, int end) {
      this.begin = begin;
      this.end = end;
    }

    public int[] buildNewSubArr(int[] arr) {
      return Arrays.copyOfRange(arr, begin, end);
    }
  }
}
