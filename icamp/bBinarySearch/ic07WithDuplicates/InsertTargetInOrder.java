package icamp.bBinarySearch.ic07WithDuplicates;

public class InsertTargetInOrder {
  public static void main(String[] args) {
    int[] input = {1,2,4,4,5,6,8,8};
    System.out.println(findIdx(input, 3) == 2); // 2
    System.out.println(findIdx(input, 0) == 0); // 0
    int actual = findIdx(input, 4);
    System.out.println(actual >= 2 && actual <= 4); // 2|3|4
    System.out.println(findIdx(input, 9) == 8); // 7
    input = new int[] {2};
    System.out.println(findIdx(input, 2) == 0);
    System.out.println(findIdx(input, 3) == 1);
    System.out.println(findIdx(input, 1) == 0);
  }

  private static int findIdx(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }

    if (nums.length == 0) {
      return 0;
    }

    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > target) {
        int leftElIdx = mid - 1;
        if (leftElIdx >= 0 && nums[leftElIdx] < target || mid == 0) {
          return mid;
        } else {
          end = leftElIdx;
        }
      } else if (nums[mid] < target) {
        int rightElIdx = mid + 1;
        if (rightElIdx < nums.length && nums[rightElIdx] > target) {
          return rightElIdx;
        } else {
          start = rightElIdx;
        }
      } else {
        return mid;
      }
    }

    return nums.length;
  }
}
