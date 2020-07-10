package icamp.cRecursionMemoization.ic18easyMaze;

public class TestCase {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static int idGenerator = 1;

    private final int id = idGenerator++;
    private final int[][] input;
    private final boolean expectedResult;

    TestCase(int[][] input, boolean expectedResult) {
        this.input = input.clone();
        this.expectedResult = expectedResult;
    }

    void analyze(boolean actualResult) {
        boolean passed = actualResult == getExpectedResult();
        String result = passed ? " passed." : " failed.";
        String color = passed ? ANSI_GREEN : ANSI_RED;
        System.out.println(color + "Test nr " + id + result + ANSI_RESET);
        if (!passed) {
            printInput(actualResult);
        }
    }

    private void printInput(boolean actualResult) {
        System.out.println("Input:");
        printMatrixToConsole();
        System.out.println("Expected = " + getExpectedResult());
        System.out.println("Actual = " + actualResult);
    }

    private void printMatrixToConsole() {
        if (getInput() == null) {
            System.out.println("Size can't be <= 0, amigo!");
            return;
        }
        StringBuilder finalOutput = new StringBuilder();
        for (int[] row : getInput()) {
            StringBuilder rowOfNumbers = new StringBuilder();
            for (int el : row) {
                rowOfNumbers.append(String.format("%-3d", el));
                rowOfNumbers.append(" ");
            }
            finalOutput.append(rowOfNumbers.toString().trim()).append("\n");
        }
        System.out.println(finalOutput);
    }

    int[][] getInput() {
        return input;
    }

    private boolean getExpectedResult() {
        return expectedResult;
    }
}
