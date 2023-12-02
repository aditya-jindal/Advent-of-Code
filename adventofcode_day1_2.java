import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class adventofcode_day1_2 {
    public static int matchNumberInWords(String numInWords){
        if (numInWords.contains("one")) return 1;
        else if (numInWords.contains("two")) return 2;
        else if (numInWords.contains("three")) return 3;
        else if (numInWords.contains("four")) return 4;
        else if (numInWords.contains("five")) return 5;
        else if (numInWords.contains("six")) return 6;
        else if (numInWords.contains("seven")) return 7;
        else if (numInWords.contains("eight")) return 8;
        else if (numInWords.contains("nine")) return 9;
        else if (numInWords.contains("zero")) return 0;
        return -1;
    }
    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static int getFirstNumber(String str, boolean rev) {
        String words = "";
        for (char x : str.toCharArray()) {
            words += x;
            if (matchNumberInWords(rev ? reverseString(words):words) !=-1 ) {
                return matchNumberInWords(rev ? reverseString(words):words);
            }
            if ((int) x >= (int) '0' && (int) x <= (int) '9') {
                return ((int) x - (int) '0');
            }
        }
        return -1;
    }    
    public static int getCode(String line){
       int firstDigit=getFirstNumber(line,false);
       int lastDigit=getFirstNumber(new StringBuilder(line).reverse().toString(),true);
       return firstDigit*10+lastDigit;
    }
    public static void main(String[] args) {
        int sum=0;
        try (BufferedReader br = new BufferedReader(new FileReader("adventofcode_day1_input.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            sum+=getCode(line);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        
    }
}