package thebiggestprimepalindrome;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Daniel Gurbiel
 */
public class TheBiggestPrimePalindrome {
    
    final int range = 100000;
    static Scanner input;
    Vector<Integer> list_of_fivedigits_prime_numbers;
    int biggest_palindrome;
    int number1;
    int number2;

    public TheBiggestPrimePalindrome() {
        input = new Scanner(System.in);
        list_of_fivedigits_prime_numbers = new Vector<Integer>();
        biggest_palindrome = 0;
        number1 = 0;
        number2 = 0;
    }
    
    void checkFiveDigit(Vector<Integer> tmp){
        for(int i : tmp){
            if(i > 9999) list_of_fivedigits_prime_numbers.add(i);
        }
    }
    
    void checkBiggestPalindrome(){
        int tmp;
        for(int i = 0; i < list_of_fivedigits_prime_numbers.size(); i++){
            for(int j = 0; j < list_of_fivedigits_prime_numbers.size(); j++){
                tmp = list_of_fivedigits_prime_numbers.elementAt(i) * list_of_fivedigits_prime_numbers.elementAt(j);
                if(checkPalindrome(tmp) && tmp > biggest_palindrome){
                    biggest_palindrome = tmp;
                    number1 = list_of_fivedigits_prime_numbers.elementAt(i);
                    number2 = list_of_fivedigits_prime_numbers.elementAt(j);
                }
            }
        }
    }
    
    boolean checkPalindrome(int value){
        String word = "" + value;
        int tmp = 0;
        int tmp_2 = word.length() - 1;
        while(tmp_2 > tmp){
            if(word.charAt(tmp) != word.charAt(tmp_2))
                return false;
            ++tmp;
            --tmp_2;
        }
        return true;
      /*  boolean result = false;
        String word = "" + value; //100000    1000000
        if(word.length()%2+1 == 0){
            for(int i = 0; i < word.length()/2 -1; i++){
                if(word.charAt(i) != word.charAt(word.length() -i - 1))
                    return false;
                else
                    result = true; 
            }
        }else{
            for(int i = 0; i < (word.length()-1)/2-1; i++){
                if(word.charAt(i) != word.charAt(word.length() -i -1))
                    return false;
                else
                    result = true;
            }
        }*/
      
    }

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        TheBiggestPrimePalindrome test = new TheBiggestPrimePalindrome();
        pn.range = test.range;

        pn.checkAll();
        test.checkFiveDigit(pn.list_of_prime_numbers);
        test.checkBiggestPalindrome();
        
        System.out.println("The biggest palindrome: " + test.biggest_palindrome);
        System.out.println("First number: " + test.number1);
        System.out.println("Second number: " + test.number2);
    }
    
}
