import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Lw_4 {
    private static void find4words(String str) {
        String[] word = str.split(" ");
        System.out.println("Finded word:");
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() == 4) {
                System.out.println(word[i]);
            }
        }
    }
    private static String convertCyrillic(String message){
        char[] abcWord = message.toLowerCase().toCharArray();
        List<String> abcMessage = new ArrayList<String>();
        for (int i = 0; i < abcWord.length; i++) {
            if (abcWord[i] == 'z' && abcWord[i+1] == 'h'){
                abcMessage.add("zh");
                i++;
            }
            else
            if (abcWord[i] == 'j' && abcWord[i+1] == 'k'){
                abcMessage.add("jk");
                i++;
            }else {
                abcMessage.add(String.valueOf(abcWord[i]));
            }

        }
        StringBuilder result = new StringBuilder();

        String[] abcCyr =  {" ","а","б","в","г","д","ѓ","е", "ж","з","ѕ","и","ј","к","л","љ","м","н","њ","о","п","р","с","т", "ќ","у", "ф","х","ц","ч","џ","ш", "А","Б","В","Г","Д","Ѓ","Е", "Ж","З","Ѕ","И","Ј","К","Л","Љ","М","Н","Њ","О","П","Р","С","Т","Ќ", "У","Ф","Х","Ц","Ч","Џ","Ш","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","/","-"};
        String[] abcLat = {" ","a","b","v","g","d","]","e","zh","z","y","i","j","k","l","q","m","n","w","o","p","r","s","t","'","u","f","h", "c",";", "x","{","A","B","V","G","D","}","E","Zh","Z","Y","I","J","K","L","Q","M","N","W","O","P","R","S","T","KJ","U","F","H", "C",":", "X","{", "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","/","-"};

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < abcMessage.size(); i++) {
            for (int x = 0; x < abcLat.length; x++ ) {
                if (Objects.equals(abcMessage.get(i), abcLat[x])) {
                    result.append(abcCyr[x]);
                    break;
                }
            }
        }
        return result.toString();
    }
    private static void LatinWords() {
        System.out.println("Print your sentence: ");
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        int count = 0;
        Matcher matcher = Pattern.compile("[A-Za-z]+").matcher(words);
        while (matcher.find() ) {
            count++;
            words = matcher.group();
        }
        if (count == 0) {
            System.out.println("This sentence is not contain latin words: ");
        } else System.out.println("Latin words: " + count);
    }

    private static void FindOnlyNumbers (){
        System.out.println("Input your sentence :");
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        int count = 0;
        // regex pattern \b\d+\b d+ one or more numbers
        Matcher matcher = Pattern.compile("\\b\\d+\\b").matcher(words);
        while (matcher.find() ) {
            count++;

        }
        if (count == 0) {
            System.out.println("This sentence has not contain numbers!");
        } else {
            System.out.println("word with numbers : " + count);
        }
    }

    private static boolean isPalindrome (String str) {
        int lft = 0, rght = str.length() - 1;

        while(lft < rght)
        {
            if(str.charAt(lft) != str.charAt(rght))
            {return false;}
            lft++;
            rght--;
        }

        return true;
    }
    private static void WordsOnlyWithNumbers() {
        System.out.println("Input your sentence: ");
        Scanner scanwrd = new Scanner(System.in);
        String words = scanwrd.nextLine();
        int count = 0;
        String[] sliced = words.split("\s");
        for (int i = 0; i < sliced.length;i++) {
            Matcher matcher = Pattern.compile("\\b\\d+\\b").matcher(sliced[i]);
            while (matcher.find() ) {
                if (isPalindrome(sliced[i]))
                    count++;
            }
        }
        if (count == 0) {
            System.out.println("This sentence is not contain palindrome words only with numbers");
        } else {
            System.out.println("Finded word with numbers: " + count);
        }
    }
    public static void main(String[] args) {
        System.out.println("№1 Input words if the words satisfy the condition (consist of 4 letters) they will be displayed in the console :");
        String userPhrase1 = new Scanner(System.in).nextLine();
        find4words(userPhrase1);

        System.out.println('\n' + "№2 Enter Latin words for Cyrillic transliteration:");
        String userPhrase2 = new Scanner(System.in).nextLine();
        String convertSentence = convertCyrillic(userPhrase2);
        System.out.println("Sentence after convert:" + convertSentence);

        System.out.println('\n' + "№3 After entering words, only Latin words will be displayed:");
        LatinWords();

        System.out.println('\n' + "№4After entering words, number of numeric words will be displayed:");
        FindOnlyNumbers();

        System.out.println('\n' + "№5:After entering words, number of numeric palindrome will be displayed");
        WordsOnlyWithNumbers();
    }

}
