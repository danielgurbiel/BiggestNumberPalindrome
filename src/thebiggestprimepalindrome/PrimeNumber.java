package thebiggestprimepalindrome;

import java.util.Vector;

/**
 *
 * @author Daniel Gurbiel
 */
public class PrimeNumber {
    Vector<Integer> list_of_prime_numbers;
    int range;
    
    PrimeNumber(){
        list_of_prime_numbers = new Vector<Integer>();
        list_of_prime_numbers.add(1);
        range = 0;
    }
    
    void checkAll(){
        for(int i = 2; i < range+1; i++){
            if(checkPrime(i))
                list_of_prime_numbers.add(i);
        }
    }
    
    boolean checkPrime(int value){
        boolean tmp = true;
        
        for(int i = 1; i < list_of_prime_numbers.size(); i++){
            if(value % list_of_prime_numbers.elementAt(i) == 0)
                tmp = false;
        }
        
        return tmp;
    }

    
}