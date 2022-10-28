package eu.ztsh.training.hackerrank.datastructures.subarray;

import java.util.List;
import eu.ztsh.training.hackerrank.HackerRankTest;
import eu.ztsh.training.hackerrank.SolutionClassDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HackerRank challenges: Java Subarray")
class SolutionTest extends HackerRankTest {

    @Test
    public void testCase0() {
        simpleAssert(
                List.of("5", "1 -2 4 -5 1"),
                List.of("9")
        );
    }


    @Override
    protected SolutionClassDescription getSolutionClassDescription() {
        return new SolutionClassDescription(Solution.class);
    }

}