package dvla.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alex on 31/03/2017.
 */
public class UserLogin {
    private String userLogin;
    private String newUserPassword;
    private String loginAndPassword;
    private List<String> loginArray;

    public UserLogin() {
    }

    public void  setLoginDetails (String userName, char[] userPassword ){
        System.out.println(userName + userPassword);
        userLogin = userName;
        newUserPassword = String.valueOf(userPassword);

        loginAndPassword = userLogin +":"+ newUserPassword;
    }
    public String getLoginDetails(){
        return loginAndPassword;
    }

    public List<String> getDataStore() throws FileNotFoundException {
        File file = new File("Login.txt");

        Scanner readIn = new Scanner(file);
        loginArray = new ArrayList<>();
        while (readIn.hasNextLine()) {
            int i =0;
            loginArray.add(readIn.nextLine());
            System.out.println(loginArray.get(i));
            i++;
        }
        return loginArray;
    }
}
