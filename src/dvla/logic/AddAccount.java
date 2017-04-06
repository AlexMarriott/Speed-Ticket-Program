package dvla.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <h1> AddAccount</h1>
 * The AddAccount is the logic for the AddAccountGUI class. It allows the user to create a new account which can login to the program. The logic part checks that the username and password are following
 * the correct naming convention and it write the new user account to the login.txt
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class AddAccount {
    /** Declares newAccountPassword as a String variable which is used to construct the new username and password.  */
    private String newAccountPassword;

    /** Declares newLoginAndPassword as a String variable which is used to construct the new username and password.  */
    private String newLoginAndPassword;

    /** Declares accountLoginFile as a PrintWriter variable which is used to write the new username and password to login.txt.  */
    private PrintWriter accountLoginFile;

    /** Declares stringToPassword as a String variable which is assigned the String.valueOf accountPassword which is passed through as a char array.  */
    private String stringToPassword;

    /** Declares correctUserPassword as a boolean variable which if the password passes the convention rules then, pass's back a true value to the AddAccountGUI  */
    private boolean correctUserPassword;

    /** Declares correctUserName as a boolean variable which if the Username passes the convention rules then, pass's back a true value to the AddAccountGUI  */
    private boolean correctUserName;

    /** getPasswordState Method returns the correctUserPassword and is called from the AddAccountGUI */
    public boolean getPasswordState() {
        return correctUserPassword;
    }

    /** getUserState Method returns the correctUserName and is called from the AddAccountGUI */
    public boolean getUserState() {
        return correctUserName;
    }


    /** The setNewLogin method checks to see if the newnewAccountUser (username) and the accountPassword (users password) is correct and follows the naming convention.
     * The method gets the accountPassword and converts it from a char to String and then checks both the username and password to see if it follows the naming convention. If the password and username pass then
     * a true value is set which is passed back to the AddAccountGUI in the setters above, if password or username failures, a false value is passed to AddAccountGUI.
     * @param newAccountUser new user Account the user submits
     * @param accountPassword The account Password the user submits
     * */
    public void  setNewLogin(String newAccountUser, char[] accountPassword){
        stringToPassword = String.valueOf(accountPassword);

        if(correctUserName = newAccountUser.length() < 5 || !newAccountUser.matches("^[a-zA-Z0-9]*$")){
            correctUserName = false;
        }
        else
            correctUserName = true;


        if (correctUserPassword = (stringToPassword.length() < 7 || !stringToPassword.matches("^[a-zA-Z0-9]*$"))){
            correctUserPassword = false;
        }
        else
            correctUserPassword = true;

        newAccountPassword = String.valueOf(accountPassword);
        //Login.txt hold the username and password in this convention "username:password"
        newLoginAndPassword = newAccountUser +":"+ newAccountPassword;
    }

    /** getNewLogin gets the newLoginAndPassword ready to be passed to the saveNewUser method from AddAccountGUI */
    public String getNewLogin(){
        return newLoginAndPassword;
    }

    /** saveNewUser is passed the newlogin from the AddAccountGUI and write the new login to the login.txt.
     * @param newLogin new user account with password is passed through to be written*/
    public void saveNewUser(String newLogin) throws IOException {

        accountLoginFile = new PrintWriter(new BufferedWriter(new FileWriter("Login.txt", true)));
        accountLoginFile.println(newLogin);
        accountLoginFile.flush();
        accountLoginFile.close();

    }
}
