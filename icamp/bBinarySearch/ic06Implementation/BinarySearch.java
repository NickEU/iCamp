package icamp.bBinarySearch.ic06Implementation;

public class BinarySearch {
  public static void main(String[] args) {
    int[] input = {2, 4, 5, 8, 11, 15, 27};
    System.out.println(getIndex(input, 5));
    testBottleFinder();
  }

  private static void testBottleFinder() {
    Bottle[] input = {
      new Bottle(5),
      new Bottle(9),
      new Bottle(11),
      new Bottle(15),
      new Bottle(22),
    };
    Bottle searchFor = new Bottle(11);
    Bottle result = searchGeneric(input, searchFor);
    System.out.println(result);
  }

  private static int getIndex(int[] sortedNums, int target) {
    int start = 0;
    int end = sortedNums.length - 1;
    while (start <= end) {
      // (start + end) / 2 can lead to integer overflow
      int mid = start + (end - start) / 2;
      int currEl = sortedNums[mid];
      if (currEl > target) {
        end = mid - 1;
      } else if (currEl < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }

    // if no match found
    return -1;
  }

  private static <T extends Comparable<T>> Bottle searchGeneric(T[] elements, T target) {
    int start = 0;
    int end = elements.length - 1;

    while (start <= end) {
      int mid = start + ((end - start) >> 1);
      int comparisonResult = elements[mid].compareTo(target);
      if (comparisonResult > 0) {
        end = mid - 1;
      } else if (comparisonResult < 0) {
        start = mid + 1;
      } else {
        return (Bottle) elements[mid];
      }
    }

    return null;
  }
}
