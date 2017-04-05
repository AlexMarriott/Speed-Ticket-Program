package dvla.gui;

import dvla.logic.UserLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1> UserLoginGUI</h1>
 * The UserLoginGUI creates the UserLoginGUI Window, which allows Users to login into the program so long as they have the correct authorised to.
 * The UserLoginGUI uses the UserLogin class for its logic.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class UserLoginGUI {

    /**
     * Declares a Jlabel named lblUserName,lblUserName.
     */
    private JLabel lblUserName, lblPassword;

    /**
     * Declares a JTextField named lblDriverID.
     */
    private JTextField txtUserName;

    /**
     * Declares a JPasswordField named lblDriverID.
     */
    private JPasswordField txtPassword;

    /**
     * Declares a JButton named btnLogin,btnExit .
     */
    private JButton btnLogin, btnExit;

    /**
     * Declares a JPanel named pnlDriverLogin.
     */
    private JPanel pnlDriverLogin;

    /**
     * Declares a JFrame named frmDriverLogin.
     */
    private JFrame frmDriverLogin;

    /**
     * Declaring a new UserLogin Object. UserLogin is the logic part to the UserLoginGUI
     */
    private UserLogin userLogic;

    /**
     * Declares a boolean named userCanLogin. usercanLogin dictates via a true or false if the user is able to login to the program.
     */
    private boolean userCanLogin;

    /**
     * Declares a List<String> named loginArray. loginArray reads in the values from the login.txt file and is then compared with the users inputs.
     */
    private List<String> loginArray;


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
     * The LoginHandler using the UserLogin logic takes the username and passwors, converts the password from a char array to a String and then set all the usernames and passwords from the login.txt to the login array.
     * The loginArray then goes through a for loops, checking if the user inputted username and password is equal to anything in the file.
     * If there is a match then the user is allowed to login in. If there is no match, the user receive a prompt telling them to try again.
     */
    private class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            userLogic = new UserLogin();
            loginArray = new ArrayList<>();
            //Passing the username and password to Userlogin logic
            userLogic.setLoginDetails(txtUserName.getText(), txtPassword.getPassword());
            userLogic.getLoginDetails();

            try {

                loginArray = userLogic.getLoginData();

            } catch (FileNotFoundException exception) {
                JOptionPane.showMessageDialog(frmDriverLogin, "Login file cannot be found, please report this to your administrator!");
                exception.printStackTrace();
            }

            int i;
            //Checking to see if any of the entries in the txt file match the usersname and password.
            for (i = 0; i < loginArray.size(); i++) {

                if (loginArray.get(i).equals(userLogic.getLoginDetails())) {

                    JOptionPane.showMessageDialog(frmDriverLogin, "Login in Successful! Welcome!");
                    new SpeedingTicketMenuGUI();
                    frmDriverLogin.dispose();
                    userCanLogin = true;
                    break;
                } else {
                    userCanLogin = false;
                }
            }

            if (!userCanLogin) {
                JOptionPane.showMessageDialog(frmDriverLogin, "Loginr in Unsuccessfully.... Check your username and password!");
            }

        }
    }

    /**LoginExitHandler listens for the exit button to be click and then will close and dispose of the frame. */
    private class LoginExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            frmDriverLogin.dispose();
        }
    }

    /**The Main will create the instance of UserLoginGUI to begin the program. */
    public static void main(String[] args) {
        new UserLoginGUI();
    }

}

