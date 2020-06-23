package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.PrefixSums;

import icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.SubArray;

import java.util.Arrays;
import java.util.HashMap;

public class FindSubArrThatSumsToK implements ITestable {
  @Override
  public int[] getResult(int[] input, int targetSum, LoggingMode log) {
    if (input == null || input.length == 0) {
      if (!log.equals(LoggingMode.OFF))
        System.out.println("Invalid input");
      return null;
    }

    if (!log.equals(LoggingMode.OFF)) {
      printArray(input, targetSum);
    }

    SubArray result = null;
    int runningSum = 0;
    HashMap<Integer, Integer> sumsToIndices = new HashMap<>();

    sumsToIndices.put(0, 0);
    for (int i = 0; i < input.length; i++) {
      runningSum += input[i];
      if (log.equals(LoggingMode.FULL))
        System.out.println(runningSum + " " + i);

      Integer targetDiff = sumsToIndices.get(runningSum - targetSum);
      if (targetDiff != null) {
        result = new SubArray(targetDiff, i + 1);
        break;
      } else {
        sumsToIndices.put(runningSum, i + 1);
      }

    }

    if (!log.equals(LoggingMode.OFF))
      System.out.print("Result = ");
    if (result == null) {
      if (!log.equals(LoggingMode.OFF))
        System.out.println("null");
      return null;
    }

    int[] arr = result.buildNewSubArr(input);

    if (!log.equals(LoggingMode.OFF))
      System.out.println(Arrays.toString(arr));

    return result.buildNewSubArr(input);
  }
}
