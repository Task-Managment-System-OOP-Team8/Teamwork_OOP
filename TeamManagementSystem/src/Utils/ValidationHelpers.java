package Utils;

public class ValidationHelpers {

    public static void ValidateIntRange (int current,int min, int max, String errorMessage) {
        if (current < min || current > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
