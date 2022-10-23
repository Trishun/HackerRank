package eu.ztsh.training.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class HackerRankTest {

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    protected void simpleAssert(List<String> input, List<String> expected) {
        var result = invoke(input);
        assertThat(result).containsExactlyElementsOf(expected);
    }

    protected List<String> invoke(List<String> input) {
        try {
            outContent.reset();
            writeLines(input);
            if (getSolutionClassDescription().fieldName() != null) {
                ReflectionHelper.reloadScanner(getSolutionClassDescription());
            }
            getSolutionClassDescription().targetClass()
                    .getMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
            return readLines();
        } catch (final NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                       NoSuchFieldException e) {
            throw new IllegalStateException(e);
        }
    }

    protected abstract SolutionClassDescription getSolutionClassDescription();

    private void writeLines(List<String> lines) {
        // https://stackoverflow.com/a/31635737
        System.setIn(new ByteArrayInputStream((String.join(System.lineSeparator(), lines) + System.lineSeparator()).getBytes()));
    }

    private List<String> readLines() {
        // https://stackoverflow.com/a/1119559
        return List.copyOf(Arrays.stream(outContent.toString().split(System.lineSeparator())).toList());
    }

    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;
    private final static PrintStream originalErr = System.err;
    private final static InputStream originalIn = System.in;

}
