package icamp.cRecursionMemoization.ic16AllPermutations;

import java.util.ArrayList;
import java.util.List;


public class FromBadToWorse {
    private List<List<Integer>> permutations;
    private int size;

    public static void main(String[] args) {
        FromBadToWorse s = new FromBadToWorse();
        System.out.println(s.permute(new int[] {1, 2, 3}, 2));
        System.out.println(s.permute(new int[] {1, 2, 3}, 3));
        System.out.println(s.permute(new int[] {0, 1}, 2));
    }

    public List<List<Integer>> permute(int[] nums, int size) {
        permutations = new ArrayList<>();
        this.size = size;
        printAllPermutations(nums, new ArrayList<>(), 0);
        return permutations;
    }

    private void printAllPermutations(int[] input, ArrayList<Integer> buf, int bufPos) {
        if (bufPos == size) {
            permutations.add(buf);
            return;
        }

        for (int curEl : input) {
            if (buf.stream().noneMatch(x -> x == curEl)) {
                buf.add(curEl);
                printAllPermutations(input, new ArrayList<>(buf), bufPos + 1);
                buf.remove(Integer.valueOf(curEl));
            }
        }
    }
}
