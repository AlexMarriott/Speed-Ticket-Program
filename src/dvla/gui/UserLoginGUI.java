package dvla.gui;

import dvla.logic.PasswordCipher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
    private String userLogin;
    private String userPassword;
    private String loginAndPassword;
    private ArrayList loginArray;

    private PasswordCipher checkingPassword;

    public UserLoginGUI(){

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

    public void createLoginFrame(){
        frmDriverLogin = new JFrame();
        frmDriverLogin.setTitle("Login");
        frmDriverLogin.setSize(400,175);
        frmDriverLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmDriverLogin.setVisible(false);
        frmDriverLogin.setLocationRelativeTo(null);

        frmDriverLogin.add(pnlDriverLogin);
        frmDriverLogin.setVisible(true);
    }
    public void createLoginPanel(){
        pnlDriverLogin = new JPanel();
        pnlDriverLogin.setLayout(null);
    }

    public void addLoginFields(){

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

    public void addLoginButtons(){
        btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 100, 100, 30);
        btnLogin.addActionListener(new Login());
        pnlDriverLogin.add(btnLogin);

        btnExit = new JButton("Exit");
        btnExit.setBounds(275, 100, 100, 30);
        btnExit.addActionListener(new LoginExitHandler());
        pnlDriverLogin.add(btnExit);
    }


    public void  setLoginDetails (){
        userLogin = txtUserName.getText();
        userPassword = String.valueOf(txtPassword.getPassword());
        loginAndPassword = userLogin +":"+ userPassword;
    }
    public String getLoginDetails(){
        return loginAndPassword;
    }

    public void readInLoginFile() throws FileNotFoundException {
        File file = new File("Login.txt");

        Scanner readIn  = new Scanner(file);
        loginArray = new ArrayList();
        while (readIn.hasNextLine()) {
            loginArray.add(readIn.nextLine());
        }
    }
    class Login implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event ) {
            setLoginDetails();
            getLoginDetails();

            try {
                readInLoginFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int i;
            boolean userCanLogin =true;
            for(i=0; i<loginArray.size(); i++){
                System.out.println(loginArray.get(i));

                if(loginArray.get(i).equals(loginAndPassword)){
                    JOptionPane.showMessageDialog(frmDriverLogin, "Login in Successfully! Welcome!");
                    new SpeedingTicketGUI();
                    frmDriverLogin.setVisible(false);
                    break;
                }
                else{
                    userCanLogin = false;
                }
            }
            if (!userCanLogin){
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


    public static void main(String[] args){
        new UserLoginGUI();
    }
}
