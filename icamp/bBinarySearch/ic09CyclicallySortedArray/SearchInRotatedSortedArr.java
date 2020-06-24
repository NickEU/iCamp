package icamp.bBinarySearch.ic09CyclicallySortedArray;

public class SearchInRotatedSortedArr {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 6, 7};
    int actual = returnIdx(input, 4);
    System.out.println(actual == 3); // 3
    actual = returnIdx(input, 7);
    System.out.println(actual == 6); // 6
    input = new int[] {4, 5, 6, 7, 0, 1, 2};
    actual = returnIdx(input, 0);
    System.out.println(actual == 4); // 4
    actual = returnIdx(input, 3);
    System.out.println(actual == -1); // -1
    System.out.println(returnIdx(new int[] {1, 3}, 0) == -1);
  }

  //O(logn) time O(1) space
  private static int returnIdx(int[] nums, int target) {
    if (nums.length == 0 || nums == null) {
      return -1;
    }

    int start = 0;
    int end = nums.length - 1;
    int sortedSeqStartIdx = -1;

    // find the start of the sorted sequence
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int currEl = nums[mid];
      if (nums.length == 1
          || (mid == 0 && nums[mid] < nums[mid + 1]
              || mid == nums.length - 1 && nums[mid] > nums[mid - 1])) {
        sortedSeqStartIdx = 0;
        break;
      }

      if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
        sortedSeqStartIdx = mid;
        break;
      }

      if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
        sortedSeqStartIdx = mid + 1;
        break;
      }

      if (currEl >= nums[start]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    int largestElIdx = sortedSeqStartIdx == 0 ? nums.length - 1 : sortedSeqStartIdx - 1;
    if (nums[sortedSeqStartIdx] > target || nums[largestElIdx] < target) {
      return -1;
    }

    // set up boundaries for regular binary search
    if (sortedSeqStartIdx != 0) {
      if (target > nums[nums.length - 1]) {
        start = 0;
        end = sortedSeqStartIdx - 1;
      } else {
        start = sortedSeqStartIdx;
        end = nums.length - 1;
      }
    } else {
      start = 0;
      end = nums.length - 1;
    }

    while (start <= end) {
      int mid = start + (end - start) / 2;
      int currEl = nums[mid];
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
}
