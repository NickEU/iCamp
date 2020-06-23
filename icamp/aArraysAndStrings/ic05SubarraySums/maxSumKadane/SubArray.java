package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane;

import java.util.Arrays;

public class SubArray {
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
