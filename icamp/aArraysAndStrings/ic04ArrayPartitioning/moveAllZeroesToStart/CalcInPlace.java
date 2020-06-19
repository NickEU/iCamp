package icamp.aArraysAndStrings.ic04ArrayPartitioning.moveAllZeroesToStart;

public class CalcInPlace implements ITestable {
  // O(1) Space O(n) Time
  @Override
  public int[] getResult(int[] input) {
    System.out.println("---------");
    if (inputIsInvalid(input)) {
      return null;
    }
    printArray(input);

    int insertIdx = input.length - 1;

    for (int i = insertIdx; i >= 0; i--) {
      int currEl = input[i];
      if (currEl != 0) {
        if (i != insertIdx) {
          input[insertIdx] = currEl;
        }
        insertIdx--;
      }
    }

    if (insertIdx == input.length - 1) {
      return input;
    }


    for (int i = insertIdx; i >= 0; i--) {
      input[i] = 0;
    }


    return input;
  }
}
