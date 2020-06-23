package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.PrefixSums;

import java.util.Arrays;

public interface ITestable {
  default void printArray(int[] input, int targetSum) {
    System.out.println("-----");
    System.out.println("Input  = " + Arrays.toString(input));
    System.out.println("Target sum = " + targetSum);
  }

  int[] getResult(int[] input, int targetSum, LoggingMode log);
}
