//https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e
/* 12,02,2023
Закодировать:
 *преобразовать каждую букву текста в его значение ASCII; (Значение пробела в ASCII равно 32)
 * конвертировать значения ASCII в 8-битный двоичный код;
 * утроить каждый бит;
 * объединить результат;
 Декодировать:
 *Проверьте, не было ли ошибок, и исправьте их. Ошибками будут только перевороты битов, а не потеря битов
 *длина входной строки также всегда делится на 24, поэтому ее можно преобразовать в значение ASCII.
 *Шаги:
 *Разделите ввод на группы по три символа;
 *Проверьте, не произошла ли ошибка: замените каждую группу символом, который встречается чаще всего, например. 010 --> 0, 110 --> 1 и т. д.;
 *Возьмите каждую группу из 8 символов и преобразуйте это двоичное число;
 *Преобразование двоичных значений в десятичные (ASCII);
 *Преобразуйте значения ASCII в символы и соедините результат.
 */
package strings;

public class ErrorСorrectionHammingCode {

    public static void main(String[] args) {
        String s = "Should work";
        s = encode(s);
        s = decode(s);
    }

    static String encode(String text) {
        int[] a = new int[text.length()];
//преобразовать каждую букву текста в его значение ASCII и положить в массив, включая пробелы;
        for (int i = 0; i < text.length(); i++) {
            a[i] = (int) text.charAt(i);
        }
//Получаю массив бинарных чисел
        String[] s = binary(a);
//Перевожу числа в восьми битные
        eightBit(s);
//Утраиваю символы в каждом элементе массива (в каждой букве)
        triple(s);
//массив соединяю в строку (concatenated)
        String bits = String.join("", s);
        return bits;
    }

    static String[] binary(int[] a) {
        String[] s = new String[a.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = Integer.toBinaryString(a[i]);

        }
        return s;
    }

    //Довожу до восьми бит бинарное число каждой буквы
    static String[] eightBit(String[] s) {
        for (int i = 0; i < s.length; i++) {
            //вар.1
//            while (s[i].length() < 8){
//                s[i] = "0" + s[i];
//            }
            //еще вариант
            s[i] = "0".repeat(8- s[i].length()) + s[i];
         //очень сложный, наивный вариант
//            if (s[i].length() < 8) {
//
//                int temp = 8 - s[i].length(); //вычисляю длину элемента и разницу от восьми битного
//                String str = ""; //формирую строку недостающих до 8-бит нулей
//                for (int j = 0; j < temp; j++) {
//                    str += "0";
//                }
//                s[i] = str + s[i];//конкатенация имеющегося бинарного кода буквы и вперед еще нули недостающие.
//            }
        }
        return s;
    }

    //утраиваю каждое число в бинарном числе (каждая буква)
    static void triple(String[] s) {
        for (int i = 0; i < s.length; i++) { //перебираю элементы массива (буквы в двоичном коде)
            //char[] chars = new char[s[i].length()];
            String s1 = "";
            for (int j = 0; j < s[i].length(); j++) {//перебираю каждую цифру в дв. коде буквы
               // chars[j] = s[i].charAt(j); //извлекаю символ из строки бинарных чисел
              char c = s[i].charAt(j);
              s1 += (c + "").repeat(3);
//                s1 += String.valueOf(c);//Утраиваю каждую цифру дв. кода и записываю вместо одной цифры
//                s1 += String.valueOf(c);
//                s1 += String.valueOf(c);
            }
            s[i] = s1;
        }

    }

    static String decode(String bits) {
        String[] triples = splitOfThree(bits);
        String[] correctedBits = replaceThreeToOneSymbol(triples);
        String[] bytes = convertToBinaryNumber(correctedBits);
        int[] valuesASCII = convertASCII(bytes);
        String words = asciiToCharacters(valuesASCII);
        return words;
    }

    //разбить строку по три символа
    static String[] splitOfThree(String bits) {
        String[] strings = new String[bits.length() / 3];
        int start = 0;
        for (int i = 0; i < strings.length; i++) {//бежит по массиву
            strings[i] = bits.substring(start, start + 3);//отделяет от строки по три символа
            start += 3;
        }
        return strings;
    }
//замените каждую группу символом, который встречается чаще всего
    static String[] replaceThreeToOneSymbol(String[] strings) {

        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            if (chars[0] == chars[1] || chars[0] == chars[2]) {
                strings[i] = ("" + chars[0]);
            } else {
                strings[i] = ("" + chars[1]);
            }

        }
        return strings;
}
    static String[] convertToBinaryNumber(String[] strings){
        String[] binary = new String[strings.length/8];
        for (int i = 0; i < binary.length; i++) {
            int temp = i*8;
            binary[i] = "";
            for (int j = 0; j < 8; j++) {
                binary[i] += strings[temp];
                temp++;
            }
        }
        return binary;
    }
//перевод из двоичной системы в десятичную: https://user12vv.wordpress.com/2014/01/16/java-из-двоичной-системы-в-десятичную-и-об/
    static int[] convertASCII(String[] bytes){
        int[] valuesASCII = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            valuesASCII[i] = Integer.parseInt(bytes[i], 2);
        }
        return valuesASCII;
    }
    static String asciiToCharacters(int[] valueASCII){
        String word = "";
        for (int i = 0; i < valueASCII.length; i++) {
            char c = (char) valueASCII[i];
            word += c;
        }
        return word;
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
