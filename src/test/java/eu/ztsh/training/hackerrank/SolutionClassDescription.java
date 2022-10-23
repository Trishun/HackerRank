package eu.ztsh.training.hackerrank;

import java.util.Arrays;

public record SolutionClassDescription(Class<?> targetClass, String fieldName, FieldModifier[] modifiers) {

    public SolutionClassDescription(Class<?> targetClass) {
        this(targetClass, null, null);
    }

    public boolean hasModifier(FieldModifier modifier) {
        return Arrays.asList(modifiers).contains(modifier);
    }

    public enum FieldModifier {
        PRIVATE, FINAL, STATIC
    }

}
