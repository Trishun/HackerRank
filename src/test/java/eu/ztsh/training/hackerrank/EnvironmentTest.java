package eu.ztsh.training.hackerrank;

import java.util.List;
import java.util.Scanner;
import eu.ztsh.training.hackerrank.SolutionClassDescription.FieldModifier;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvironmentTest {

    abstract static class HackerRankEnvironmentTest extends HackerRankTest {

        @Test
        public void passTwoLinesTest() {
            var input = List.of(
                    "Line 1",
                    "Line 2"
            );
            var result = invoke(input);
            assertThat(result).containsExactlyElementsOf(input);
        }

        @Test
        public void multiInvokeTest() {
            var input = List.of(
                    "Line 1",
                    "Line 2"
            );
            invoke(input);
            invoke(input);
            var result = invoke(input);
            assertThat(result).containsExactlyElementsOf(input);
        }

        @Test
        public void passTwoAnotherLinesTest() {
            var input = List.of(
                    "Line 3",
                    "Line 4"
            );
            var result = invoke(input);
            assertThat(result).containsExactlyElementsOf(input);
        }

    }

    @Nested
    @DisplayName("Test with Scanner created as private static field")
    class EnvironmentPrivateStaticTest extends HackerRankEnvironmentTest {

        @Override
        protected SolutionClassDescription getSolutionClassDescription() {
            return new SolutionClassDescription(SampleSolutionWithPrivateStaticScanner.class,
                    "scan",
                    new FieldModifier[]{FieldModifier.PRIVATE, FieldModifier.STATIC});
        }

    }

    @Disabled("Disabled: run with --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED")
    @Nested
    @DisplayName("Test with Scanner created as private static final field")
    class EnvironmentPrivateStaticFinalTest extends HackerRankEnvironmentTest {

        @Override
        protected SolutionClassDescription getSolutionClassDescription() {
            return new SolutionClassDescription(SampleSolutionWithPrivateStaticScanner.class,
                    "scan",
                    FieldModifier.values());
        }

    }

    @Nested
    @DisplayName("Test with Scanner created in main(String[]) method")
    class EnvironmentInlineTest extends HackerRankEnvironmentTest {

        @Override
        protected SolutionClassDescription getSolutionClassDescription() {
            return new SolutionClassDescription(SampleSolutionWithInlineScanner.class);
        }

    }

}

class SampleSolutionWithPrivateStaticScanner {

    public static void main(String... args) {
        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
        }
    }

    @SuppressWarnings("FieldMayBeFinal")
    private static Scanner scan = new Scanner(System.in);

}

class SampleSolutionWithPrivateStaticFinalScanner {

    public static void main(String... args) {
        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
        }
    }

    private static final Scanner scan = new Scanner(System.in);

}

class SampleSolutionWithInlineScanner {

    public static void main(String... args) {
        var scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
        }
    }

}
