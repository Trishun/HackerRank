package eu.ztsh.training.hackerrank.datastructures.array_1d_pt2;

import java.util.List;
import eu.ztsh.training.hackerrank.HackerRankTest;
import eu.ztsh.training.hackerrank.SolutionClassDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest extends HackerRankTest {

    @Override
    protected SolutionClassDescription getSolutionClassDescription() {
        return new SolutionClassDescription(Solution.class);
    }

    @Nested
    @DisplayName("Provided test cases")
    class TestCases {

        @Test
        public void testCase0() {
            simpleAssert(
                    List.of(
                            "4",
                            "5 3",
                            "0 0 0 0 0",
                            "6 5",
                            "0 0 0 1 1 1",
                            "6 3",
                            "0 0 1 1 1 0",
                            "3 1",
                            "0 1 0"
                    ),
                    List.of(
                            "YES",
                            "YES",
                            "NO",
                            "NO"
                    )
            );
        }

    }

    @Nested
    @DisplayName("Unit tests")
    class UnitTests {

        @Test
        public void winningMoveTest() {
            assertThat(Solution.isWinningMove(0, 1, 2)).isFalse();
            assertThat(Solution.isWinningMove(1, 5, 6)).isTrue();
        }

        @Test
        public void moveForwardTest() {
            var game = new int[]{0, 0, 1};
            assertThat(Solution.canMoveForward(0, game)).isTrue();
            assertThat(Solution.canMoveForward(1, game)).isFalse();
        }

        @Test
        public void moveBackwardTest() {
            var game = new int[]{0, 1, 0, 0, 1};
            assertThat(Solution.canMoveBackward(0, game)).isFalse();
            assertThat(Solution.canMoveBackward(3, game)).isTrue();
            assertThat(Solution.canMoveBackward(2, game)).isFalse();
        }

        @Test
        public void jumpTest() {
            var game = new int[]{0, 0, 1, 1, 1, 0};
            assertThat(Solution.canJump(0, 3, game)).isFalse();
            assertThat(Solution.canJump(1, 3, game)).isFalse();
            assertThat(Solution.canJump(1, 4, game)).isTrue();
        }

    }

}