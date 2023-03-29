import java.util.HashMap;
import java.util.Map;

public class Converter {
    private static final Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int romanToArabic(String roman) {
        int result = 0;
        int prev = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int curr = map.get(roman.charAt(i));
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    public static String arabicToRoman(int num) {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] dozens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hrns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};
        return thousands[num / 1000] + hrns[(num % 1000) / 100] + dozens[(num % 100) / 10] + units[num % 10];
    }
}
