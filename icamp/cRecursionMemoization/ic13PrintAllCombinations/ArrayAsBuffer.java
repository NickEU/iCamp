package icamp.cRecursionMemoization.ic13PrintAllCombinations;

import java.util.Arrays;

// Given an array of integers, print all combinations of size X.
public class ArrayAsBuffer {
  private final int size;
  private final int[] input;

  public ArrayAsBuffer(int[] input, int size) {
    this.size = size;
    this.input = input == null ? new int[0] : input;
  }

  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5};
    int comboSize = 3;
    ArrayAsBuffer o = new ArrayAsBuffer(input, comboSize);
    o.printCombinations(0, 0,  new int[comboSize]);
    o = new ArrayAsBuffer(null, comboSize);
    o.printCombinations(0, 0,  new int[comboSize]);
  }

  private void printCombinations(int startIdx, int pos, int[] combo) {
    if (pos == size) {
      System.out.println(Arrays.toString(combo));
      return;
    }

    for (int i = startIdx; i < input.length; i++) {
      combo[pos] = input[i];
      printCombinations(i + 1, pos + 1, combo);
    }

  }

}
