package dvla.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1> UserLogin</h1>
 * The UserLogin is the logic for the UserLoginGUI. It takes the new Username and Password and sets returners it in its correct format.
 * It also creates an array with all the username and password for the UserLoginGUI to compare.
 *
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class UserLogin {
    /**Declares a String named userLogin, this is used as the users login name.*/
    private String userLogin;

    /**Declares a String named stringUserPassword, this is used as the users login password.*/
    private String stringUserPassword;

    /**Declares a String named loginAndPassword, this is compared with the login detils in the login.txt.*/
    private String loginAndPassword;



    /**blank constructor.*/
    public UserLogin() {
    }

    /**This method sets the take the userName and userPassword which is passed through to it and constructs it into the correct format for the Login.txt file.
     * @param userName The new userName that the user inputted
     * @param  userPassword The password that the user inputted */
    public void  setLoginDetails (String userName, char[] userPassword ){
        userLogin = userName;
        stringUserPassword = String.valueOf(userPassword);

        loginAndPassword = userLogin +":"+ stringUserPassword;
    }
    /**This method returns the loginAndPassword which was set in the above method
     * @return loginAndPassword*/
    public String getLoginDetails(){
        return loginAndPassword;
    }


}
