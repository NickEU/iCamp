package icamp.bBinarySearch.ic10UnknownLenArray;

public class Tester {
  public static void main(String[] args) {
    FindTarget1RoughDraft o = new FindTarget1RoughDraft();
    runTestSuite(o);
  }

  private static void runTestSuite(ITestable o) {
    int[] input = {
            1, 2, 3, 4, 5, 6, 7, 8,
    };
    System.out.println(o.getIndex(input, -5));
    System.out.println(o.getIndex(input, 4));
    System.out.println(o.getIndex(input, 10));
    int size = 1_000_000_000;
    // warning! eats 3gigs+ of ram
    int[] bigArray = generateArray(size);
    System.out.println(o.getIndex(bigArray, 0));
    System.out.println(o.getIndex(bigArray, size - 1));
    System.out.println(o.getIndex(bigArray, size + 1));
    System.out.println(o.getIndex(bigArray, size / 2));
  }

  private static int[] generateArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = i + 1;
    }
    return result;
  }
}
