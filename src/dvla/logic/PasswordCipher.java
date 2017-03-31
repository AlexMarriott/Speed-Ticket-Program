package dvla.logic;

import java.util.Random;

/**
 * Created by Alex on 31/03/2017.
 */
public class PasswordCipher {
    private String decryptedPassword;
    private String encryptedPassword;
    private String checkPassword;


    private char[] charSeq = new char[26];
    private Random randomInt = new Random();
    private int shiftChar = randomInt.nextInt(6) + 5;


    //http://stackoverflow.com/questions/11347211/where-can-i-find-the-java-source-code-for-the-vigenere-cipher
    public String encrypt(){
        char[] charSeq = {'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p',
                'q','r','s','t','u','v','w','x','y','z'};




        return encryptedPassword;
    }

    public String decrypt (){
        return decryptedPassword;


    }



    }