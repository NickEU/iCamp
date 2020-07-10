package icamp.cRecursionMemoization.ic18easyMaze;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class TestRunner {
    List<TestCase> testCases = setupTestCases();

    private List<TestCase> setupTestCases() {
        ArrayList<TestCase> result = new ArrayList<>();
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0}
        }, true)); // 1
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        }, true)); // 2
        result.add(new TestCase(new int[][]{{0, 0}}, true)); // 3
        result.add(new TestCase(new int[][]{{0}}, true)); // 4
        result.add(new TestCase(new int[][]{{1}}, false)); // 5
        result.add(new TestCase(new int[][]{{0, 1}}, false)); // 6
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        }, true)); // 7
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 1},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        }, true)); // 8
        result.add(new TestCase(new int[][]{
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        }, false)); // 9
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        }, true)); // 10
        result.add(new TestCase(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        }, true)); // 11
        result.add(new TestCase(new int[][]{
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        }, true)); // 12
        result.add(new TestCase(new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        }, false)); // 13
        return result;
    }

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.start(IterativeSolutionUsingQueue::pathExistsIn);
    }

    void start(BiFunction<int[][], Logging, Boolean> f) {
        for (TestCase test : testCases) {
            test.analyze(f.apply(test.getInput(), Logging.OFF));
        }
    }
}
