package icamp.aArraysAndStrings.ic04ArrayPartitioning.moveAllZeroesToStart;

import java.util.Arrays;

public interface ITestable {

  default boolean inputIsInvalid(int[] input) {
    return input == null;
  }

  default void printArray(int[] input) {
    System.out.println(Arrays.toString(input));
  }

  int[] getResult(int[] input);
}
