package util;

/**
 * Common helper functions
 */
public class Util {
    private Util() {
    }

    public static String dashes(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
