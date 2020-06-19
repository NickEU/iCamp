package icamp.aArraysAndStrings.ic04ArrayPartitioning.moveAllZeroesToStart;

public class CalcUsingOneArray implements ITestable {
  // O(n) Space O(n) Time
  // in two passes using one auxiliary array
  @Override
  public int[] getResult(int[] input) {
    System.out.println("---------");
    if (inputIsInvalid(input)) {
      return null;
    }
    printArray(input);

    int[] result = new int[input.length];
    int i = 0;

    // fill with zeroes
    for (int num : input) {
      if (num == 0) {
        result[i] = num;
        i++;
      }
    }

    // fill with nums
    for (int num : input) {
      if (num != 0) {
        result[i] = num;
        i++;
      }
    }

    return result;
  }

}
