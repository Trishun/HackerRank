package eu.ztsh.training.hackerrank.datastructures.priority_queue;

import java.util.List;
import eu.ztsh.training.hackerrank.HackerRankTest;
import eu.ztsh.training.hackerrank.SolutionClassDescription;
import eu.ztsh.training.hackerrank.SolutionClassDescription.FieldModifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("HackerRank chalenges: Java Priority Queue")
class SolutionTest extends HackerRankTest {

    @Test
    public void testCase0() {
        var input = List.of(
                "12",
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );
        var expected = List.of(
                "Dan",
                "Ashley",
                "Shafaet",
                "Maria"
        );
        simpleAssert(input, expected);
    }


    @Override
    protected SolutionClassDescription getSolutionClassDescription() {
        return new SolutionClassDescription(Solution.class,
                "scan",
                new FieldModifier[]{FieldModifier.PRIVATE, FieldModifier.STATIC});
    }

}