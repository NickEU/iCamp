package icamp.cRecursionMemoization.ic18easyMaze;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestRunner {
    List<TestCase> testCases = setupTestCases();

    private List<TestCase> setupTestCases() {
        ArrayList<TestCase> result = new ArrayList<>();
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0}
        }, true));
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        }, true));
        result.add(new TestCase(new int[][]{{0, 0}}, true));
        result.add(new TestCase(new int[][]{{0}}, true));
        result.add(new TestCase(new int[][]{{1}}, false));
        result.add(new TestCase(new int[][]{{0, 1}}, false));
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        }, true));
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 1},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        }, true));
        result.add(new TestCase(new int[][]{
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        }, false));
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        }, true));
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        }, true));
        result.add(new TestCase(new int[][]{
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        }, true));
        result.add(new TestCase(new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        }, false));
        return result;
    }

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.start(IterativeSolutionUsingQueue::pathExistsIn);
    }

    void start(Function<int[][], Boolean> f) {
        for (var test : testCases) {
            System.out.println(f.apply(
                    test.getInput()) == test.getExpectedResult());
        }
    }
}
