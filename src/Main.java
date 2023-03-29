import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(calc(a));
    }

    public static String calc(String s) {
        String[] input = s.split(" ");
        if (input.length != 3)throw new IllegalArgumentException
                ("формат математической операции не удовлетворяет заданию - два операнда и один оператор, разделённые пробелами");
        int result;
        NumberType numberType = Validator.checkType(input[0], input[2]);
        int first;
        int second;
        if (numberType == NumberType.ROMAN) {
            first = Converter.romanToArabic(input[0]);
            second = Converter.romanToArabic(input[2]);
        } else {
            first = Integer.parseInt(input[0]);
            second = Integer.parseInt(input[2]);
        }
        result = switch (input[1]) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("Неизвестная арифметическая операция");
        };
        if (numberType == NumberType.ROMAN && result < 1)
            throw new IllegalArgumentException("в римской системе нет отрицательных чисел");
        return numberType == NumberType.ROMAN ? Converter.arabicToRoman(result) : String.valueOf(result);
    }
}