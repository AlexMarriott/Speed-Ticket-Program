package dvla.gui;

import dvla.logic.AddAccount;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <h1> AddAccountGUI</h1>
 * The AddAccount GUI class, implements the AddAccount window, which allows the users to add a new user account to access the DVLA Ticket Program.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class AddAccountGUI {

    /** The lblUserName and lblPassword are used to create labels on the panel for user and password. */
    private JLabel lblUserName, lblPassword;

    /** txtUserName is used to allow user input into the txtUserName field. */
    private JTextField txtUserName;

    /** JPasswordField is used to allow user input into the txtUserName field. */
    private JPasswordField txtPassword;

    /**
     * btnSubmit has an actionlistener which submits the newly created user.
     * btnConvention has an actionlistener which displays text regarding the username and password convention.
     * btnExit has an actionlistener which disposes of the AddAccount window.
     * */
    private JButton btnSubmit, btnConvention, btnExit;

    /** pnlAddAccount, creates the panel for the AddAccountGUI. */
    private JPanel pnlAddAccount;

    /** frmAddAccount, creates the frame for the AddAccountGUI. */
    private JFrame frmAddAccount;

    /** Declaring addingAccount variable to later initialise to pass Data to AddAccount class. */
    private AddAccount addingAccount;


    /**Initialises the AddAccount Constructor and sets the following methods. */
    public AddAccountGUI() {

        createLoginPanel();
        addLoginFields();
        addLoginButtons();
        createLoginFrame();

        /**
         * The try catch runs the UIManager to set the look and feel to the users Operating System desktop managers look, The catch will catch and stacktrace exception which interfere with the UIManager.
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates the frame for the login window.
     */
    public void createLoginFrame() {
        frmAddAccount = new JFrame();
        frmAddAccount.setTitle("Login");
        frmAddAccount.setSize(400, 175);
        frmAddAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAddAccount.setLocationRelativeTo(null);

        frmAddAccount.getRootPane().setDefaultButton(btnSubmit);
        frmAddAccount.add(pnlAddAccount);
        frmAddAccount.setVisible(true);
    }

    public void createLoginPanel() {
        pnlAddAccount = new JPanel();
        pnlAddAccount.setLayout(null);
    }

    public void addLoginFields() {

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

    public void addLoginButtons() {
        btnSubmit = new JButton("Add");
        btnSubmit.setBounds(10, 100, 100, 30);
        btnSubmit.addActionListener(new AddHandler());
        pnlAddAccount.add(btnSubmit);

        btnConvention = new JButton("Naming Convention");
        btnConvention.setBounds(117, 100, 150, 30);
        btnConvention.addActionListener(new ConventionHandler());
        pnlAddAccount.add(btnConvention);

        btnExit = new JButton("Exit");
        btnExit.setBounds(275, 100, 100, 30);
        btnExit.addActionListener(new ExitHandler());
        pnlAddAccount.add(btnExit);
    }

    class AddHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            addingAccount = new AddAccount();
            addingAccount.setNewLogin(txtUserName.getText(), txtPassword.getPassword());
            addingAccount.getNewLogin();

            if (!addingAccount.getUserState()) {
                JOptionPane.showMessageDialog(frmAddAccount, "The User length should be 5 Characters minimum and contain letters only");
            } else if (!addingAccount.getPasswordState()) {
                JOptionPane.showMessageDialog(frmAddAccount, "The Password length should be 8 Characters minimum and contain letters and Numbers only");
            } else {
                try {
                    addingAccount.saveNewUser();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(frmAddAccount, "User Added, Remember, with great power comes great responsibility ");

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
}


