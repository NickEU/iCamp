package icamp.cRecursionMemoization.ic18easyMaze;

public class TestCase {
    private final int[][] input;
    private final boolean expectedResult;

    public TestCase(int[][] input, boolean expectedResult) {
        this.input = input.clone();
        this.expectedResult = expectedResult;
    }

    public int[][] getInput() {
        return input;
    }

    public boolean getExpectedResult() {
        return expectedResult;
    }
}
