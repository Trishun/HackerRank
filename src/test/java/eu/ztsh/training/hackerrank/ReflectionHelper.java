package eu.ztsh.training.hackerrank;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import eu.ztsh.training.hackerrank.SolutionClassDescription.FieldModifier;


public class ReflectionHelper {

    // https://stackoverflow.com/a/56043252
    static {
        try {
            var lookup = MethodHandles.privateLookupIn(Field.class, MethodHandles.lookup());
            MODIFIERS = lookup.findVarHandle(Field.class, "modifiers", int.class);
            CAN_MODIFY_FINALS = true;
        } catch (IllegalAccessException | NoSuchFieldException ex) {
            CAN_MODIFY_FINALS = false;
        }
    }

    static void reloadScanner(SolutionClassDescription description) throws NoSuchFieldException, IllegalAccessException {
        // https://stackoverflow.com/a/3301720
        var scannerField = description.hasModifier(FieldModifier.STATIC)
                ? description.targetClass().getDeclaredField(description.fieldName())
                : description.targetClass().getField(description.fieldName());
        if (description.hasModifier(FieldModifier.PRIVATE)) {
            scannerField.setAccessible(true);
        }
        if (description.hasModifier(FieldModifier.FINAL) && CAN_MODIFY_FINALS) {
            MODIFIERS.set(scannerField, scannerField.getModifiers() & ~Modifier.FINAL);
        }
        scannerField.set(null, new Scanner(System.in));
    }

    private static VarHandle MODIFIERS;
    private static boolean CAN_MODIFY_FINALS;

}
