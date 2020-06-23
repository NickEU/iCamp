package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane;

import java.util.Arrays;

public class Kadane {
  public static void main(String[] args) {
    Kadane s = new Kadane();
    int[] maxSubArr = s.getSubArrWithMaxSum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
    System.out.println(s.getMaxSum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(Arrays.toString(maxSubArr));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {-2, -10})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {2, -10, -5, 76, 2})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {50})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {-22, 0, -17})));
    System.out.println(Arrays.toString(s.getSubArrWithMaxSum(new int[] {1, 2, -1, 2, -3, 2, -5})));
  }

  private Integer getMaxSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      System.out.println("Error! Empty/null array given as parameter.");
      return null;
    }

    int maxSum = nums[0];
    int currSum = maxSum;

    for (int i = 1; i < nums.length; i++) {
      currSum = Math.max(currSum + nums[i], nums[i]);
      maxSum = Math.max(currSum, maxSum);
    }

    return maxSum;
  }

  private int[] getSubArrWithMaxSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      System.out.println("Error! Empty/null array given as parameter.");
      return null;
    }

    int maxSum = nums[0];
    int currSum = maxSum;
    int currSize = 1;
    SubArray result = new SubArray(0, 1);

    for (int i = 1; i < nums.length; i++) {
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

    return result.buildNewSubArr(nums);
  }
}
