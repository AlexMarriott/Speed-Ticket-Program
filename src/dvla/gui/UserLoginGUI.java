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
 * The UserLoginGUI creates the UserLoginGUI Window, which allows users to see all the Drivers records which have been logged into the system.
 * UserLoginGUI also allows the user to remove drivers and search for specific drivers.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class UserLoginGUI {

    /**Declares a Jlabel named lblUserName,lblUserName.*/
    private JLabel lblUserName, lblPassword;

    /**Declares a JTextField named lblDriverID.*/
    private JTextField txtUserName;

    /**Declares a JPasswordField named lblDriverID.*/
    private JPasswordField txtPassword;

    /**Declares a JButton named btnLogin,btnExit .*/
    private JButton btnLogin, btnExit;

    /**Declares a JPanel named pnlDriverLogin.*/
    private JPanel pnlDriverLogin;

    /**Declares a JFrame named frmDriverLogin.*/
    private JFrame frmDriverLogin;

    /**Declaring a new UserLogin Object. UserLogin is the logic part to the UserLoginGUI*/
    private UserLogin userlogic;

    /**Declares a boolean named userCanLogin. usercanLogin dictates via a true or false if the user is able to login to the program.*/
    private boolean userCanLogin;

    /**Declares a List<String> named loginArray. loginArray reads in the values from the login.txt file and is then compared with the users inputs.*/
    private List<String> loginArray;


    /** Constructor runs the methods to create the GUI and Table then auto fills the data in the JTable*/
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

    /** Creates the frame for the UserLoginGUI*/
    public void createLoginFrame() {
        frmDriverLogin = new JFrame();
        frmDriverLogin.setTitle("LoginHandler");
        frmDriverLogin.setSize(400, 175);
        frmDriverLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDriverLogin.setLocationRelativeTo(null);
        frmDriverLogin.getRootPane().setDefaultButton(btnLogin);


        frmDriverLogin.add(pnlDriverLogin);
        frmDriverLogin.setVisible(true);
    }

    /** Creates the panel for the UserLoginGUI*/
    public void createLoginPanel() {
        pnlDriverLogin = new JPanel();
        pnlDriverLogin.setLayout(null);
    }

    /** Adds JTextField and JLabels to the UserLoginGUI*/
    public void addLoginFields() {

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

    /** Adds Jbuttons to the UserLoginGUI*/
    public void addLoginButtons() {
        btnLogin = new JButton("LoginHandler");
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
     * The LoginHandler gets the UsersName and Password of the new user account and checks that they follow the naming convention. Once checked, it will pass the account name password to the AddAccount object,
     * which will add them to the DataStore.
     */
    class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            userlogic = new UserLogin();
            loginArray = new ArrayList<>();

            userlogic.setLoginDetails(txtUserName.getText(), txtPassword.getPassword());
            userlogic.getLoginDetails();

                try {

                    loginArray = userlogic.getDataStore();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            int i = 0;
            for (i = 0; i < loginArray.size(); i++) {

                if (loginArray.get(i).equals(userlogic.getLoginDetails())) {

                    JOptionPane.showMessageDialog(frmDriverLogin, "LoginHandler in Successful! Welcome!");
                    new SpeedingTicketMenuGUI();
                    frmDriverLogin.dispose();
                    userCanLogin = true;
                    break;
                } else {
                    userCanLogin = false;
                }
            }

                if (!userCanLogin) {
                    JOptionPane.showMessageDialog(frmDriverLogin, "LoginHandler in Unsuccessfully.... Check your username and password!");
                }

        }
    }


        class LoginExitHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {

                frmDriverLogin.dispose();
            }
        }


        public static void main(String[] args) {
            new UserLoginGUI();
        }

}

