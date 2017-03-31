package dvla.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 31/03/2017.
 */
public class UserLogin {
    private String userName;
    private String userLogin;
    private String userPassword;
    private String newUserPassword;
    private String loginAndPassword;
    private ArrayList loginArray;

    public void  setLoginDetails (String userName, char[] userPassword ){
        userLogin = userName;
        newUserPassword = String.valueOf(userPassword);

        loginAndPassword = userLogin +":"+ newUserPassword;
    }
    public String getLoginDetails(){
        return loginAndPassword;
    }

    public ArrayList getDataStore() throws FileNotFoundException {
        File file = new File("Login.txt");

        Scanner readIn = new Scanner(file);
        loginArray = new ArrayList();
        while (readIn.hasNextLine()) {
            loginArray.add(readIn.nextLine());
        }
        return loginArray;
    }
}
