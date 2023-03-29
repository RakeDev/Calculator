import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static NumberType checkType(String s1, String s2) {
        if (validateRoman(s1) && validateRoman(s2))
            return NumberType.ROMAN;
        if (validateInteger(s1) && validateInteger(s2))
            return NumberType.ARABIC;
        throw new IllegalArgumentException("Неверный формат ввода");
    }

    public static boolean validateInteger(String s1) {
        Pattern pattern = Pattern.compile("^([0-9]|10)$");
        Matcher matcher = pattern.matcher(s1);
        return matcher.matches();
    }

    public static boolean validateRoman(String s1) {
        Pattern pattern = Pattern.compile("(X|IX|IV|V?I{0,3})");
        Matcher matcher = pattern.matcher(s1);
        return matcher.matches();
    }
}
