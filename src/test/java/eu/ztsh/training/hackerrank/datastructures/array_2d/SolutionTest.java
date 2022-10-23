package eu.ztsh.training.hackerrank.datastructures.array_2d;

import java.util.List;
import eu.ztsh.training.hackerrank.HackerRankTest;
import eu.ztsh.training.hackerrank.SolutionClassDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HackerRank challenges: Java 2D Array")
class SolutionTest extends HackerRankTest {

    @Test
    public void dummyInitTest() {
        assertThat(true).isTrue();
    }

    @Test
    public void testCase0() {
        simpleAssert(
                List.of(
                        "1 1 1 0 0 0",
                        "0 1 0 0 0 0",
                        "1 1 1 0 0 0",
                        "0 0 2 4 4 0",
                        "0 0 0 2 0 0",
                        "0 0 1 2 4 0"
                ),
                List.of("19")
        );
    }

    @Test
    public void testCase1() {
        simpleAssert(
                List.of(
                        "1 1 1 0 0 0",
                        "0 1 0 0 0 0",
                        "1 1 1 0 0 0",
                        "0 9 2 -4 -4 0",
                        "0 0 0 -2 0 0",
                        "0 0 -1 -2 -4 0"
                ),
                List.of("13")
        );
    }

    @Test
    public void testCase3() {
        simpleAssert(
                List.of(
                        "-1 -1 0 -9 -2 -2",
                        "-2 -1 -6 -8 -2 -5",
                        "-1 -1 -1 -2 -3 -4",
                        "-1 -9 -2 -4 -4 -5",
                        "-7 -3 -3 -2 -9 -9",
                        "-1 -3 -1 -2 -4 -5"
                ),
                List.of("-6")
        );
    }


    @Override
    protected SolutionClassDescription getSolutionClassDescription() {
        return new SolutionClassDescription(Solution.class);
    }

}