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
    private String stringToPassword;
    private char[] AccountPassword;

    private boolean correctUserPassword;
    private boolean correctUserName;
    public boolean getPasswordState() {
        return correctUserPassword;
    }
    public boolean getUserState() {
        return correctUserName;
    }


    public void  setNewLogin(String newAccountUser, char[] AccountPassword){
        stringToPassword = String.valueOf(AccountPassword);

        if(newAccountUser.length() < 5 | !newAccountUser.matches("^[a-zA-Z]*$")){
            System.out.println(newAccountUser);
            correctUserName = false;
        }
        else
            correctUserName = true;

        if(stringToPassword.length() < 7 | !stringToPassword.matches("^[a-zA-Z0-9]*$")){
            correctUserPassword = false;
        }
        else
            correctUserPassword = true;

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
