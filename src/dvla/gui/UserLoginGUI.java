package dvla.gui;

import dvla.logic.DatabaseWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1> UserLoginGUI</h1>
 * The UserLoginGUI creates the UserLoginGUI Window, which allows Users to login into the program so long
 * as they have the correct authorised to.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class UserLoginGUI {

    /**
     * Declares a Jlabel named lblUserName,lblUserName, they are used to create labels on the panel for user and password..
     */
    private JLabel lblUserName, lblPassword;

    /**
     * Declares a JTextField named lblDriverID, which is used for the user account name..
     */
    private JTextField txtUserName;

    /**
     * Declares a JPasswordField named lblDriverID, which is used for the new user account password..
     */
    private JPasswordField txtPassword;

    /**
     * Declares a JButton named btnLogin,btnExit.
     * btnLogin allows the user to login into the program, login button will pass through the details of the user to the Userlogin Logic
     * btnExit will dispose of the frame and return the user to the main menu.
     */
    private JButton btnLogin, btnExit;

    /**
     * Declares a JPanel named pnlDriverLogin, this is the panel for UserloginGUI.
     */
    private JPanel pnlDriverLogin;

    /**
     * Declares a JFrame named frmDriverLogin, this is the panel for UserloginGUI.
     */
    private JFrame frmDriverLogin;
    /**
     * Declaring a new DatabaseWriter Object. data
     */
    private DatabaseWriter setLoginData;

    /**
     * Declares a boolean named userCanLogin. usercanLogin dictates via a true or false if the user is able to login to the program.
     */
    private boolean userCanLogin;

    /**
     * Declares a List named loginArray. loginArray reads in the values from the login.txt file and is then compared with the users inputs.
     */
    private List<String> loginArray;

    /**
     * Declares a String named userLogin, this is used as the users login name.
     */
    private String userLogin;

    /**
     * Declares a String named stringUserPassword, this is used as the users login password.
     */
    private String stringUserPassword;

    /**
     * Declares a String named loginAndPassword, this is compared with the login details in the login.txt.
     */
    private String loginAndPassword;

    /**
     * Constructor runs the methods to create the GUI and Table then auto fills the data in the JTable
     */
    public UserLoginGUI() {

        createLoginPanel();
        addLoginFields();
        addLoginButtons();
        createLoginFrame();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the frame for the UserLoginGUI
     */
    private void createLoginFrame() {
        frmDriverLogin = new JFrame();
        frmDriverLogin.setTitle("Login");
        frmDriverLogin.setSize(400, 175);
        frmDriverLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDriverLogin.setLocationRelativeTo(null);
        frmDriverLogin.getRootPane().setDefaultButton(btnLogin);


        frmDriverLogin.add(pnlDriverLogin);
        frmDriverLogin.setVisible(true);
    }

    /**
     * Creates the panel for the UserLoginGUI
     */
    private void createLoginPanel() {
        pnlDriverLogin = new JPanel();
        pnlDriverLogin.setLayout(null);
    }

    /**
     * Adds JTextField and JLabels to the UserLoginGUI
     */
    private void addLoginFields() {

        lblUserName = new JLabel("UserName");
        lblUserName.setBounds(20, 20, 100, 20);
        pnlDriverLogin.add(lblUserName);

        txtUserName = new JTextField(null);
        txtUserName.setBounds(140, 20, 100, 20);
        pnlDriverLogin.add(txtUserName);

        lblUserName = new JLabel("user1");
        lblUserName.setBounds(260, 20, 100, 20);
        pnlDriverLogin.add(lblUserName);

        lblUserName = new JLabel("password1");
        lblUserName.setBounds(260, 50, 100, 20);
        pnlDriverLogin.add(lblUserName);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(20, 50, 100, 20);
        pnlDriverLogin.add(lblPassword);

        txtPassword = new JPasswordField(null);
        txtPassword.setBounds(140, 50, 100, 20);
        txtPassword.setEchoChar('*');
        pnlDriverLogin.add(txtPassword);

    }

    /**
     * Adds Jbuttons to the UserLoginGUI
     */
    private void addLoginButtons() {
        btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 100, 100, 30);
        btnLogin.addActionListener(new LoginHandler());
        pnlDriverLogin.add(btnLogin);

        btnExit = new JButton("Exit");
        btnExit.setBounds(275, 100, 100, 30);
        btnExit.addActionListener(new LoginExitHandler());
        pnlDriverLogin.add(btnExit);
    }

    /**
     * The LoginHandler takes the user inputted username and password and checks to see if they are valid.
     * The LoginHandler  takes the username and passwords, converts the password from a char array to a String and then set all the usernames and passwords from the login.txt to the login array.
     * The loginArray then goes through a for loops, checking if the user inputed username and password is equal to anything in the file.
     * If there is a match then the user is allowed to login in. If there is no match, the user receive a prompt telling them to try again.
     */
    private class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            loginArray = new ArrayList<>();
            setLoginData = new DatabaseWriter();

            //Passing the username and password to Userlogin logic
            setLoginDetails(txtUserName.getText(), txtPassword.getPassword());

            try {

                loginArray = setLoginData.getLoginData();

            } catch (FileNotFoundException exception) {
                JOptionPane.showMessageDialog(frmDriverLogin, "Login file cannot be found, please report this to your administrator!");
                exception.printStackTrace();
            }

            int i;
            //Checking to see if any of the entries in the txt file match the usersnames and password.
            for (i = 0; i < loginArray.size(); i++) {

                if (loginArray.get(i).equals(getLoginDetails())) {

                    JOptionPane.showMessageDialog(frmDriverLogin, "LoginSuccessful!");
                    new SpeedingTicketMenuGUI();
                    frmDriverLogin.dispose();
                    userCanLogin = true;
                    break;
                } else {
                    userCanLogin = false;
                }
            }

            if (!userCanLogin) {
                JOptionPane.showMessageDialog(frmDriverLogin, "Login Unsuccessful.... Check your username and password!");
            }

        }
    }

    /**
     * LoginExitHandler listens for the exit button to be click and then will close and dispose of the frame.
     */
    private class LoginExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            frmDriverLogin.dispose();
        }
    }


    /**
     * This method sets the take the userName and userPassword which is passed through to it and constructs it into the correct format for the Login.txt file.
     *
     * @param userName     The new userName that the user inputed
     * @param userPassword The password that the user inputed
     */
    private void setLoginDetails(String userName, char[] userPassword) {
        userLogin = userName;
        stringUserPassword = String.valueOf(userPassword);

        loginAndPassword = userLogin + ":" + stringUserPassword;
    }

    /**
     * This method returns the loginAndPassword which was set in the above method
     *
     * @return loginAndPassword
     */
    private String getLoginDetails() {
        return loginAndPassword;
    }

    /**
     * The Main will create the instance of UserLoginGUI to begin the program.
     *
     * @param args default argument for the main
     */
    public static void main(String[] args) {
        new UserLoginGUI();
    }

}

