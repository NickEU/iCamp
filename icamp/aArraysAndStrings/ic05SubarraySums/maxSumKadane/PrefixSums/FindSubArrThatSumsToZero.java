package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.PrefixSums;

import icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.SubArray;

import java.util.Arrays;
import java.util.HashMap;

public class FindSubArrThatSumsToZero implements ITestable {
  @Override
  public int[] getResult(int[] nums, int target) {
    if (nums == null || target != 0) {
      System.out.println("Illegal input");
      return null;
    }

    SubArray result = null;

    System.out.println("-----");
    System.out.println("Input  = " + Arrays.toString(nums));
    System.out.println("Target sum = " + target);
    int runningSum = 0;
    HashMap<Integer, Integer> runningSums = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      runningSum += nums[i];
      if (runningSum == 0) {
        result = new SubArray(i, i + 1);
        break;
      }
      //System.out.println(runningSum);
      if (runningSums.get(runningSum) != null) {
        result = new SubArray(runningSums.get(runningSum) + 1, i + 1);
        break;
      } else {
        runningSums.put(runningSum, i);
      }
    }

    System.out.print("Result = ");
    if (result == null) {
      System.out.println("null");
      return null;
    }

    int[] arr = result.buildNewSubArr(nums);

    System.out.println(Arrays.toString(arr));

    return arr;
  }

}
