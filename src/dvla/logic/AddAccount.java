package dvla.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alex on 31/03/2017.
 */
public class AddAccount {
    private String newAccountUser;
    private String newAccountPassword;
    private String newLoginAndPassword;
    private PrintWriter accountLoginFile;
    private String[] splitPassword;
    private String stringToPassword;
    private char[] AccountPassword;

    private boolean badPassword;
    private boolean badUser;
    private char checkLetter;

    public boolean getPasswordState() {
        System.out.println(badPassword);
        return badPassword;
    }
    public boolean getUserState() {
        System.out.println(badUser);
        return badUser;
    }


    public void  setNewLogin(String newAccountUser, char[] AccountPassword){
        stringToPassword = String.valueOf(AccountPassword);

        if(newAccountUser.length() < 5 | !stringToPassword.matches("^[a-zA-Z]*$")){
            System.out.println(newAccountUser);
            badUser = false;
        }
        else
            badUser = true;

        if(stringToPassword.length() < 7 | !stringToPassword.matches("^[a-zA-Z0-9]*$")){
            System.out.println(stringToPassword);
            badPassword = false;
        }
        else
            badPassword = true;

        newAccountPassword = String.valueOf(AccountPassword);
        newLoginAndPassword = newAccountUser +":"+ newAccountPassword;
    }

    public String getNewLogin(){
        return newLoginAndPassword;
    }

    public void saveNewUser() throws IOException {

        accountLoginFile = new PrintWriter(new BufferedWriter(new FileWriter("Login.txt", true)));
        accountLoginFile.println(newLoginAndPassword);
        accountLoginFile.flush();
        accountLoginFile.close();

    }
}
