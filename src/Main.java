import java.util.Scanner;
import java.util.regex.PatternSyntaxException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int addition = s.indexOf("+");
        int subtraction = s.indexOf("-");
        int multiplication = s.indexOf("*");
        int division = s.indexOf("/");

        String[] ar1 = s.split(" ");
        int av = ar1.length;

        if (av<2){
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(-1);
        }else if (containsMultipleOperators(s)){
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(-1);
        }

        if (addition != -1){
            String[] ar = s.split("\\+");

            if (ar.length >2 ){

                System.out.println("throws Exception //т.к. строка не является математической операцией");
            } else if (isNumber(ar[0].trim()) && isNumber(ar[1].trim())) {
                int a = Integer.parseInt(ar[0].trim());
                int b = Integer.parseInt(ar[1].trim());
                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 ) {
                    System.out.println(a+b);
                }else {
//                    throw new Exception("throws Exception //т.к. калькулятор должен принимать на вход числа от 1 до 10 включительно");
                }

            }else if (isRomanNumeral(ar[0].trim()) && isRomanNumeral(ar[1].trim())){
                int a=romanToArabic(ar[0].trim());
                int b=romanToArabic(ar[1].trim());

                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 ) {
                    System.out.println(arabicToRoman(a+b));
                }


            }else if (isNumber(ar[0].trim()) && isRomanNumeral(ar[1].trim()) || isRomanNumeral(ar[0].trim()) && isNumber(ar[1].trim()) ){
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }else {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }

        if (subtraction != -1){
            String[] ar = s.split("\\-");

            if (ar.length >2 ){
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            } else if (isNumber(ar[0].trim()) && isNumber(ar[1].trim()) ) {
                int a = Integer.parseInt(ar[0].trim());
                int b = Integer.parseInt(ar[1].trim());
                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 ) {
                    System.out.println(a-b);
                }else {
                    System.out.println("throws Exception //т.к. калькулятор должен принимать на вход числа от 1 до 10 включительно");
                }

            }else if (isRomanNumeral(ar[0].trim()) && isRomanNumeral(ar[1].trim())){
                int a=romanToArabic(ar[0].trim());
                int b=romanToArabic(ar[1].trim());
                int c = a - b;
                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 && c>1) {
                    System.out.println(arabicToRoman(c));
                }else {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
            }else if (isNumber(ar[0].trim()) && isRomanNumeral(ar[1].trim()) || isRomanNumeral(ar[0].trim()) && isNumber(ar[1].trim()) ){
                System.out.println("hrows Exception //т.к. используются одновременно разные системы счисления");
            }else {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
    }

        if (multiplication != -1){
            String[] ar = s.split("\\*");
            if (ar.length >2 ){
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            } else if (isNumber(ar[0].trim()) && isNumber(ar[1].trim()) ) {
                int a = Integer.parseInt(ar[0].trim());
                int b = Integer.parseInt(ar[1].trim());
                if (a <= 10 && b <= 10 && a >= 1 ) {
                    System.out.println(a*b);
                }
            }else if (isRomanNumeral(ar[0].trim()) && isRomanNumeral(ar[1].trim())){
                int a=romanToArabic(ar[0].trim());
                int b=romanToArabic(ar[1].trim());

                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 ) {
                    System.out.println(arabicToRoman(a*b));
                }else {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
            }else if (isNumber(ar[0].trim()) && isRomanNumeral(ar[1].trim()) || isRomanNumeral(ar[0].trim()) && isNumber(ar[1].trim()) ){
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }else {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }

        if (division != -1){
            String[] ar = s.split("\\/");

            if (ar.length >2 ){
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            } else if (isNumber(ar[0].trim()) && isNumber(ar[1].trim()) ) {
                int a = Integer.parseInt(ar[0].trim());
                int b = Integer.parseInt(ar[1].trim());
                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 ) {
                    System.out.println(a/b);
                }else {
                    System.out.println("throws Exception //т.к. калькулятор должен принимать на вход числа от 1 до 10 включительно");
                }
            }else if (isRomanNumeral(ar[0].trim()) && isRomanNumeral(ar[1].trim())){
                int a=romanToArabic(ar[0].trim());
                int b=romanToArabic(ar[1].trim());

                if (a <= 10 && b <= 10 && a >= 1 && b >= 1 ) {
                    System.out.println(arabicToRoman(a/b));
                }
            }else if (isNumber(ar[0].trim()) && isRomanNumeral(ar[1].trim()) || isRomanNumeral(ar[0].trim()) && isNumber(ar[1].trim()) ){
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }else {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            }
        }
    }

    public static int romanToArabic (String input) {
        int result = 0;
        String rimNumeral = input.toUpperCase();

        for (int i = 0; i < rimNumeral.length(); i++) {
            char rimCharAt = rimNumeral.charAt(i);
            int firstCharRim = 0;

            switch (rimCharAt) {
                case 'I':
                    firstCharRim = 1;
                    break;
                case 'V':
                    firstCharRim = 5;
                    break;
                case 'X':
                    firstCharRim = 10;
                    break;
                case 'L':
                    firstCharRim = 50;
                    break;
                case 'C':
                    firstCharRim = 100;
                    break;
                case 'D':
                    firstCharRim = 500;
                    break;
                case 'M':
                    firstCharRim = 1000;
                    break;
                default:
                    System.out.println("throws Exception //т.к. строка не является математической операцией");
            }

            if (i < rimNumeral.length() - 1) {
                char nextRimCharAT = rimNumeral.charAt(i + 1);
                int nextFirstCharRim = 0;

                switch (nextRimCharAT) {
                    case 'I':
                        nextFirstCharRim = 1;
                        break;
                    case 'V':
                        nextFirstCharRim = 5;
                        break;
                    case 'X':
                        nextFirstCharRim = 10;
                        break;
                    case 'L':
                        nextFirstCharRim = 50;
                        break;
                    case 'C':
                        nextFirstCharRim = 100;
                        break;
                    case 'D':
                        nextFirstCharRim = 500;
                        break;
                    case 'M':
                        nextFirstCharRim = 1000;
                        break;
                    default:
                        System.out.println("throws Exception //т.к. строка не является математической операцией");
                }

                if (firstCharRim < nextFirstCharRim) {
                    result -= firstCharRim;
                } else {
                    result += firstCharRim;
                }
            } else {
                result += firstCharRim;
            }
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isRomanNumeral(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D' && c != 'M') {
                return false;
            }
        }
        return true;
    }

    public static boolean containsMultipleOperators(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void jeka() {
        try {
            int a = 5 / 1;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("я долбаеб");
        }
    }
}
