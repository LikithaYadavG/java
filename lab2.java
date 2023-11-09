import java.util.Arrays;

public class lab2 {
    public static void main(String[] args) {
        String text = "We realizes that while our workers were thriving, the " +
                      "surrounding villages were still suffering. It became our " +
                      "goal to uplift their quality of life as well.";

        // charAt()
        char firstChar = text.charAt(0);
        System.out.println("charAt(): " + firstChar);

        // compareTo()
        String anotherText = "Another text for comparison";
        int compareResult = text.compareTo(anotherText);
        System.out.println("compareTo(): " + compareResult);

        // concat()
        String combinedText = text.concat(" " + anotherText);
        System.out.println("concat(): " + combinedText);

        // contains()
        boolean containsWord = text.contains("workers");
        System.out.println("contains(): " + containsWord);

        // endsWith()
        boolean endsWithPeriod = text.endsWith(".");
        System.out.println("endsWith(): " + endsWithPeriod);

        // equals()
        boolean isEqual = text.equals(anotherText);
        System.out.println("equals(): " + isEqual);

        // equalsIgnoreCase()
        boolean isEqualIgnoreCase = text.equalsIgnoreCase(anotherText);
        System.out.println("equalsIgnoreCase(): " + isEqualIgnoreCase);

        // format()
        String formattedText = String.format("Formatted text: %s", text);
        System.out.println("format(): " + formattedText);

        // getBytes()
        byte[] textBytes = text.getBytes();
        System.out.println("getBytes(): " + Arrays.toString(textBytes));

        // getChars()
        char[] charArray = new char[text.length()];
        text.getChars(0, text.length(), charArray, 0);
        System.out.println("getChars(): " + Arrays.toString(charArray));

        // indexOf()
        int indexOfThrive = text.indexOf("thriving");
        System.out.println("indexOf(): " + indexOfThrive);

        // intern()
        String internedText = text.intern();
        System.out.println("intern(): " + internedText);

        // isEmpty()
        boolean isEmpty = text.isEmpty();
        System.out.println("isEmpty(): " + isEmpty);

        // join()
        String[] words = text.split(" ");
        String joinedText = String.join("-", words);
        System.out.println("join(): " + joinedText);

        // lastIndexOf()
        int lastIndexOfVillages = text.lastIndexOf("villages");
        System.out.println("lastIndexOf(): " + lastIndexOfVillages);

        // length()
        int textLength = text.length();
        System.out.println("length(): " + textLength);

        // replace()
        String replacedText = text.replace("workers", "employees");
        System.out.println("replace(): " + replacedText);

        // replaceAll()
        String regexReplacedText = text.replaceAll("\\b(\\w+)\\b", "$1_replaced");
        System.out.println("replaceAll(): " + regexReplacedText);

        // split()
        String[] splitText = text.split(" ");
        System.out.println("split(): " + Arrays.toString(splitText));

        // startsWith()
        boolean startsWithWe = text.startsWith("We");
        System.out.println("startsWith(): " + startsWithWe);

        // substring()
        String substringText = text.substring(10, 30);
        System.out.println("substring(): " + substringText);

        // toCharArray()
        char[] charArrayFromText = text.toCharArray();
        System.out.println("toCharArray(): " + Arrays.toString(charArrayFromText));

        // toLowerCase()
        String lowerCaseText = text.toLowerCase();
        System.out.println("toLowerCase(): " + lowerCaseText);

        // toUpperCase()
        String upperCaseText = text.toUpperCase();
        System.out.println("toUpperCase(): " + upperCaseText);

        // trim()
        String trimmedText = text.trim();
        System.out.println("trim(): " + trimmedText);

        // valueOf()
        int intValue = 42;
        String stringValue = String.valueOf(intValue);
        System.out.println("valueOf(): " + stringValue);
    }
}
