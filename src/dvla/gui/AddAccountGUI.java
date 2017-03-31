package dvla.gui;

import dvla.logic.AddAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Alex on 23/02/2017.
 */
public class AddAccountGUI {
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnSubmit, btnconvention, btnExit;
    private JPanel pnlAddAccount;
    private JFrame frmAddAccount;
    private String newUserName, newPassword;
    private AddAccount addingAccount;






    public AddAccountGUI(){

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
        frmAddAccount = new JFrame();
        frmAddAccount.setTitle("Login");
        frmAddAccount.setSize(400,175);
        frmAddAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAddAccount.setVisible(false);
        frmAddAccount.setLocationRelativeTo(null);

        frmAddAccount.add(pnlAddAccount);
        frmAddAccount.setVisible(true);
    }
    public void createLoginPanel(){
        pnlAddAccount = new JPanel();
        pnlAddAccount.setLayout(null);
    }

    public void addLoginFields(){

        lblUserName = new JLabel("New UserName");
        lblUserName.setBounds(20, 20, 100, 20);
        pnlAddAccount.add(lblUserName);

        txtUserName = new JTextField(null);
        txtUserName.setBounds(140, 20, 100, 20);
        pnlAddAccount.add(txtUserName);

        lblPassword = new JLabel("New Password");
        lblPassword.setBounds(20, 50, 100, 20);
        pnlAddAccount.add(lblPassword);

        txtPassword = new JPasswordField(null);
        txtPassword.setBounds(140, 50, 100, 20);
        txtPassword.setEchoChar('*');
        pnlAddAccount.add(txtPassword);

    }

    public void addLoginButtons(){
        btnSubmit = new JButton("Add");
        btnSubmit.setBounds(10, 100, 100, 30);
        btnSubmit.addActionListener(new AddHandler());
        pnlAddAccount.add(btnSubmit);

        btnconvention = new JButton("Naming Convention");
        btnconvention.setBounds(117, 100, 150, 30);
        btnconvention.addActionListener(new ConventionHandler());
        pnlAddAccount.add(btnconvention);

        btnExit = new JButton("Exit");
        btnExit.setBounds(275, 100, 100, 30);
        btnExit.addActionListener(new ExitHandler());
        pnlAddAccount.add(btnExit);
    }


    /*public void checkPassword(String loginAndPassword) {

        int i;
        int count = 0;

        if (newAccountPassword.length() != 8) {
            badPassword = true;
        } else {
            for (i = 0; i < newAccountPassword. ; i++) {
                splitPassword[i] = String.valueOf((newAccountPassword.split("")));
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
    }*/


    class AddHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            addingAccount = new AddAccount();
            addingAccount.setNewLogin(txtUserName.getText(), txtPassword.getPassword());
            addingAccount.getNewLogin();

            if (!addingAccount.getUserState()) {
                JOptionPane.showMessageDialog(frmAddAccount, "The User length should be 5 Characters minimum and contain letters only");
            } else {
                if (!addingAccount.getPasswordState()) {
                    JOptionPane.showMessageDialog(frmAddAccount, "The Password length should be 8 Characters minimum and contain letters and Numbers only");
                } else {
                    try {
                        addingAccount.saveNewUser();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmAddAccount.setVisible(false);
        }
    }

    class ConventionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(frmAddAccount, "The Username Length should be 5 Characters minimum and contain letters only. \nThe Password length should be 8 Characters minimum  and contain letters and Numbers only.");
        }
    }

    public static void main(String[] args){
        new AddAccountGUI();
    }

}
