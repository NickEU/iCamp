package icamp.bBinarySearch.ic10UnknownLenArray;

public class Tester {
  public static void main(String[] args) {
    FindTarget1RoughDraft a = new FindTarget1RoughDraft();
    runTestSuite(a);
    FindTarget2EndFirst b = new FindTarget2EndFirst();
    runTestSuite(b);
  }

  private static void runTestSuite(ITestable o) {
    int[] input = {
            1, 2, 3, 4, 5, 6, 7, 8,
    };
    System.out.println(o.getIndex(input, -5) == -1);
    System.out.println(o.getIndex(input, 4) == 3);
    System.out.println(o.getIndex(input, 10) == -1);
    int size = 1_000_000;
    int[] bigArray = generateArray(size);
    System.out.println(o.getIndex(bigArray, 0) == -1);
    System.out.println(o.getIndex(bigArray, size - 1) == 999_998);
    System.out.println(o.getIndex(bigArray, size + 1) == -1);
    System.out.println(o.getIndex(bigArray, size / 2) == 499_999);
  }

  private static int[] generateArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = i + 1;
    }
    return result;
  }
}
