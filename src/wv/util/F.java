package wv.util;

/**
 * F provides static methods for the comparison of floating-point values. These methods
 * are provided in order to get around the accuracy problems inherent in floating-point
 * numbers. Instead of comparing floating-point values exactly, which can lead to problems,
 * F uses a threshold and will return true for values that are almost equal to each other.
 * @author TheMonsterFromTheDeep
 */
public class F {
    /**
     * The threshold used to determine if floating point numbers are close enough to teach other to be
     * considered equal.
     */
    public static final float THRESHOLD = 0.00001f;
    
    /**
     * @param a The first number to compare.
     * @param b The second number to compare.
     * @return Whether the first argument is equal to the second argument.
     */
    public static boolean equals(float a, float b) {
        return Math.abs(a - b) < THRESHOLD;
    }
    
    /**
     * @param a The first number to compare.
     * @param b The second number to compare.
     * @return Whether the first argument is less than or equal to the second argument.
     */
    public static boolean lessOrEqual(float a, float b) {
        return b - a < THRESHOLD;
    }
    
    /**
     * @param a The first number to compare.
     * @param b The second number to compare.
     * @return Whether the first argument is greater than or equal to the second argument.
     */
    public static boolean greaterOrEqual(float a, float b) {
        return a - b < THRESHOLD;
    }
}