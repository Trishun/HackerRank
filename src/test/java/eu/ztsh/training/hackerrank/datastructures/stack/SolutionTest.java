package eu.ztsh.training.hackerrank.datastructures.stack;

import java.util.List;
import eu.ztsh.training.hackerrank.HackerRankTest;
import eu.ztsh.training.hackerrank.SolutionClassDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("HackerRank challenges: Java Stack")
class SolutionTest extends HackerRankTest {

    @Test
    public void testCase0() {
        simpleAssert(
                List.of(
                        "{}()",
                        "({()})",
                        "{}(",
                        "[]"
                ),
                List.of(
                        "true",
                        "true",
                        "false",
                        "true"
                )
        );
    }

    @Test
    public void testCase1() {
        simpleAssert(
                List.of(
                        "({}[])",
                        "(({()})))",
                        "({(){}()})()({(){}()})(){()}",
                        "{}()))(()()({}}{}",
                        "}}}}",
                        "))))",
                        "{{{",
                        "(((",
                        "[]{}(){()}((())){{{}}}{()()}{{}{}}",
                        "[[]][][]",
                        "}{"
                ),
                List.of(
                        "true",
                        "false",
                        "true",
                        "false",
                        "false",
                        "false",
                        "false",
                        "false",
                        "true",
                        "true",
                        "false"
                )
        );
    }

    @Override
    protected SolutionClassDescription getSolutionClassDescription() {
        return new SolutionClassDescription(Solution.class);
    }

}
