package dvla.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Alex on 23/02/2017.
 */
public class AddAdminUser {
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnExit;
    private JPanel pnlAddAdmin;
    private JFrame frmAddAdmin;
    private String newAdminUser;
    private String newAdminPassword;
    private String newLoginAndPassword;
    private PrintWriter adminLoginFile;
    private String[] splitPassword;

    private boolean badPassword;
    private boolean goodPassword;
    private char checkLetter;


    public AddAdminUser(){

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
        frmAddAdmin = new JFrame();
        frmAddAdmin.setTitle("Login");
        frmAddAdmin.setSize(400,175);
        frmAddAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAddAdmin.setVisible(false);
        frmAddAdmin.setLocationRelativeTo(null);

        frmAddAdmin.add(pnlAddAdmin);
        frmAddAdmin.setVisible(true);
    }
    public void createLoginPanel(){
        pnlAddAdmin = new JPanel();
        pnlAddAdmin.setLayout(null);
    }

    public void addLoginFields(){

        lblUserName = new JLabel("New UserName");
        lblUserName.setBounds(20, 20, 100, 20);
        pnlAddAdmin.add(lblUserName);

        txtUserName = new JTextField(null);
        txtUserName.setBounds(140, 20, 100, 20);
        pnlAddAdmin.add(txtUserName);

        lblPassword = new JLabel("New Password");
        lblPassword.setBounds(20, 50, 100, 20);
        pnlAddAdmin.add(lblPassword);

        txtPassword = new JPasswordField(null);
        txtPassword.setBounds(140, 50, 100, 20);
        txtPassword.setEchoChar('*');
        pnlAddAdmin.add(txtPassword);

    }

    public void addLoginButtons(){
        btnLogin = new JButton("Add");
        btnLogin.setBounds(10, 100, 100, 30);
        btnLogin.addActionListener(new AddHandler());
        pnlAddAdmin.add(btnLogin);

        btnExit = new JButton("Exit");
        btnExit.setBounds(275, 100, 100, 30);
        btnExit.addActionListener(new ExitHandler());
        pnlAddAdmin.add(btnExit);
    }


    public void  setNewLogin (){
        newAdminUser = txtUserName.getText();
        newAdminPassword = String.valueOf(txtPassword.getPassword());
        System.out.println(newAdminPassword);
        newLoginAndPassword = newAdminUser +":"+ newAdminPassword;
    }

    public String getNewLogin(){
        return newLoginAndPassword;
    }

    public void saveNewUser() throws IOException {
        adminLoginFile = new PrintWriter(new BufferedWriter(new FileWriter("Login.txt", true)));
        adminLoginFile.println(newLoginAndPassword);
        adminLoginFile.flush();
        adminLoginFile.close();
        JOptionPane.showMessageDialog(frmAddAdmin, "User Has Been Added. \nRemember, Great power comes with great responsibility.");
    }

    public void checkPassword(String loginAndPassword) {

        int i;
        int count = 0;

        if (loginAndPassword.length() != 8) {
            badPassword = true;
        } else {
            for (i = 0; i < loginAndPassword.length() ; i++) {
                splitPassword[i] = String.valueOf((loginAndPassword.split("")));
            }
            for (i = 0; i < splitPassword.length; i++) {
                checkLetter = splitPassword[i].charAt(i);
                if (!Character.isLetter(checkLetter)) {
                    badPassword = true;
                    break;
                } else {
                    count++;
                }
            }
            if (count < 8) {
                badPassword = true;
            }

        }
    }


    class AddHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            setNewLogin();
            getNewLogin();
            checkPassword(newLoginAndPassword);
            if (badPassword = true) {
                JOptionPane.showMessageDialog(frmAddAdmin, "The Password length is should be 8 Characters and contain letters only");
                ;
            } else {
                try {
                    saveNewUser();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmAddAdmin.setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddAdminUser();
    }

}
