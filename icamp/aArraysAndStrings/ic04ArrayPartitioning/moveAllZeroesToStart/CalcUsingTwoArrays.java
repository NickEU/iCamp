package icamp.aArraysAndStrings.ic04ArrayPartitioning.moveAllZeroesToStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CalcUsingTwoArrays implements ITestable {
  // O(n) Space O(n) Time
  // in one pass using two auxiliary arrays
  @Override
  public int[] getResult(int[] input) {
    System.out.println("---------");
    if (inputIsInvalid(input)) {
      return null;
    }
    printArray(input);

    // push all numbers to an array of numbers
    // and count the numbers of zeroes in one pass
    List<Integer> numberPart = new ArrayList<>();
    int countZeroes = 0;
    for (int num : input) {
      if (num == 0) {
        countZeroes++;
      } else {
        numberPart.add(num);
      }
    }

    int[] zeroPart = new int[countZeroes];
    Arrays.fill(zeroPart, 0);

    return IntStream.concat(Arrays.stream(zeroPart),
            Arrays.stream(numberPart.toArray()).mapToInt(x -> (int) x)).toArray();
  }

}
