package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane;

// Given an array of positive integers, find a subarray that sums to a given number X.
// For e.g, input = [1,2,3,5,2] and X=8, Result = [3,5] (indexes 2,3)

import java.util.Arrays;

public class SlidingWindow {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{1, 2, 2, 1, 12}, 8)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{1, 2, 3, 5, 2}, 0)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{8}, -1)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{1, 2, 3, 5, 2}, 8)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{1}, 8)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{8}, 8)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{8, 6, 2}, 8)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{5, 1, 2}, 3)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{1, 2, 3, 5, 2}, 13)));
    System.out.println(Arrays.toString(findSubArrThatSumsToTarget(new int[]{1, 2, 1, 1, 2}, 8)));
  }

  private static int[] findSubArrThatSumsToTarget(int[] nums, int targetSum) {
    if (nums == null || nums.length == 0 || targetSum <= 0) {
      return null;
    }

    int headPtr = 0;
    int tailPtr = 0;
    int currSum = 0;
    while (headPtr < nums.length) {
      if (currSum < targetSum && tailPtr < nums.length) {
        currSum += nums[tailPtr++];
      } else if (currSum > targetSum) {
        currSum -= nums[headPtr++];
      } else if (currSum == targetSum) {
        return Arrays.copyOfRange(nums, headPtr, tailPtr);
      } else if (tailPtr == nums.length) {
          break;
      }
    }

    return null;
  }
}
