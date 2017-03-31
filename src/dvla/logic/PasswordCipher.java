package dvla.logic;

import java.util.Random;

/**
 * Created by Alex on 31/03/2017.
 */
public class PasswordCipher {
    private String decryptedPassword;
    private String encryptedPassword;
    private String checkPassword;
    private String[] splitPassword;

    private boolean badPassword;
    private boolean goodPassword;

    private char[] charSeq = new char[26];
    private char checkLetter;
    private Random randomInt = new Random();
    private int shiftChar = randomInt.nextInt(6) + 5;

    public String encrypt(){
        char[] charSeq = {'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p',
                'q','r','s','t','u','v','w','x','y','z'};




        return encryptedPassword;
    }

    public String decrypt (){
        return decryptedPassword;


    }
    public boolean checkPassword(String loginAndPassword){

        int i;

        if(loginAndPassword.length() != 8){
            badPassword = true;
        }
        else{
        for(i=0; i<loginAndPassword.length(); i++){
           splitPassword[i] = String.valueOf(loginAndPassword.split(""));
        }
        for(i=0; i<splitPassword.length; i++){
            checkLetter = splitPassword[i].charAt(i);
            if(!checkLetter
        }

        }


    }




}
