package eu.ztsh.training.hackerrank.datastructures.array_1d;

import java.util.List;
import eu.ztsh.training.hackerrank.HackerRankTest;
import eu.ztsh.training.hackerrank.SolutionClassDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("HackerRank challenges: Java 1D Array")
class SolutionTest {

    @Nested
    @DisplayName("Original Solution class")
    class OriginalSolutionTest extends Array1DTest {
        @Override
        protected SolutionClassDescription getSolutionClassDescription() {
            return new SolutionClassDescription(Solution.class);
        }
    }

    @Nested
    @DisplayName("Custom Solution class")
    class CustomSolutionTest extends Array1DTest {
        @Override
        protected SolutionClassDescription getSolutionClassDescription() {
            return new SolutionClassDescription(CustomSolution.class);
        }
    }

    abstract static class Array1DTest extends HackerRankTest {

        @Test
        public void testCase0() {
            simpleAssert(
                    List.of("5", "10", "20", "30", "40", "50"),
                    List.of("10", "20", "30", "40", "50")
            );
        }

        @Test
        public void testCase1() {
            simpleAssert(
                    List.of("3", "100", "200", "100"),
                    List.of("100", "200", "100")
            );
        }

    }

}