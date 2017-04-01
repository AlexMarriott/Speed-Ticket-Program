package dvla.gui;

import dvla.logic.UserLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Alex on 23/02/2017.
 */
public class UserLoginGUI {
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnExit;
    private JPanel pnlDriverLogin;
    private JFrame frmDriverLogin;

    private UserLogin userlogic;
    private boolean userCanLogin;


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

    public void createLoginFrame() {
        frmDriverLogin = new JFrame();
        frmDriverLogin.setTitle("Login");
        frmDriverLogin.setSize(400, 175);
        frmDriverLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDriverLogin.setVisible(false);
        frmDriverLogin.setLocationRelativeTo(null);
        frmDriverLogin.getRootPane().setDefaultButton(btnLogin);


        frmDriverLogin.add(pnlDriverLogin);
        frmDriverLogin.setVisible(true);
    }

    public void createLoginPanel() {
        pnlDriverLogin = new JPanel();
        pnlDriverLogin.setLayout(null);
    }

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

    public void addLoginButtons() {
        btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 100, 100, 30);
        btnLogin.addActionListener(new Login());
        pnlDriverLogin.add(btnLogin);

        btnExit = new JButton("Exit");
        btnExit.setBounds(275, 100, 100, 30);
        btnExit.addActionListener(new LoginExitHandler());
        pnlDriverLogin.add(btnExit);
    }


    class Login implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            userlogic = new UserLogin();
            ArrayList loginArray = new ArrayList();

            userlogic.setLoginDetails(txtUserName.getText(), txtPassword.getPassword());
            userlogic.getLoginDetails();

            try {

                loginArray = userlogic.getDataStore();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int i = 0;

            if (loginArray.get(i).equals(userlogic.getLoginDetails())) {

                JOptionPane.showMessageDialog(frmDriverLogin, "Login in Successful! Welcome!");
                new SpeedingTicketGUI();
                frmDriverLogin.setVisible(false);
            } else {
                userCanLogin = false;
            }

            if (!userCanLogin) {
                JOptionPane.showMessageDialog(frmDriverLogin, "Login in Unsuccessfully.... Check your username and password!");
            }
        }
    }


    class LoginExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmDriverLogin.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new UserLoginGUI();
    }
}

