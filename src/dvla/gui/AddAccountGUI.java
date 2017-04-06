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
 * Creates a GUI to allow users to create new users to use the program.
 * The AddAccount GUI class, implements the AddAccount window, which allows the users to add a new user
 * account to access the DVLA Ticket Program.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class AddAccountGUI {

    /** Declares a Jlabels named lblUserName,lblPassword, they are used to create labels on the panel for user and password. */
    private JLabel lblUserName, lblPassword;

    /** Declares a JTextField named txtUserName*/
    private JTextField txtUserName;

    /** Declares a JPasswordField named txtPassword*/
    private JPasswordField txtPassword;

    /**
     * btnSubmit has an actionlistener which submits the newly created user.
     * btnConvention has an actionlistener which displays text regarding the username and password convention.
     * btnExit has an actionlistener which disposes of the AddAccount window.
     * */
    private JButton btnSubmit, btnConvention, btnExit;

    /** Declares a JPanel named pnlAddAccount*/
    private JPanel pnlAddAccount;

    /** Declares a JFrame named frmAddAccount*/
    private JFrame frmAddAccount;

    /**Declaring a new AddAccount Object. AddAccount is the logic part to the AddAccountGUI*/
    private AddAccount addingAccount;


    /**Initialises the AddAccount Constructor and sets the following methods to create the GUI. */
    public AddAccountGUI() {

        createLoginPanel();
        addLoginFields();
        addLoginButtons();
        createLoginFrame();

        /**
         * The try catch runs the UIManager to set the look and feel to the users Operating System desktop managers look,
         * The catch will catch and stacktrace exception which interfere with the UIManager.
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**creates the frame for the AddAccount GUI.*/
    private void createLoginFrame() {
        frmAddAccount = new JFrame();
        frmAddAccount.setTitle("Add New User");
        frmAddAccount.setSize(400, 175);
        frmAddAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAddAccount.setLocationRelativeTo(null);

        frmAddAccount.getRootPane().setDefaultButton(btnSubmit);
        frmAddAccount.add(pnlAddAccount);
        frmAddAccount.setVisible(true);
    }

    /**creates the Jpanel for the AddAccount GUI.*/
    private void createLoginPanel() {
        pnlAddAccount = new JPanel();
        pnlAddAccount.setLayout(null);
    }

    /**creates the JTextField and Jlabels for the AddAccountGUI panel.*/
    private void addLoginFields() {

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

    /** creates all the Jbuttons for the AddAccountGUI panel. */
    private void addLoginButtons() {
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

    /**
     * AddHandler create a new user based on the username and password provided
     * The AddHandler gets the UsersName and Password of the new user account and checks that they follow the naming convention. Once checked, it will pass the account name password to the AddAccount object,
     * which will add them to the DataStore.
     */
    private class AddHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            addingAccount = new AddAccount();
            addingAccount.setNewLogin(txtUserName.getText(), txtPassword.getPassword());

            if (!addingAccount.getUserState()) {
                JOptionPane.showMessageDialog(frmAddAccount, "The User length should be 5 Characters minimum and must contain letters and can contain numbers only");
            } else if (!addingAccount.getPasswordState()) {
                JOptionPane.showMessageDialog(frmAddAccount, "The Password length should be 8 Characters minimum and contain letters and Numbers only");
            } else {
                try {
                    addingAccount.saveNewUser(addingAccount.getNewLogin());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(frmAddAccount, "User Added, Remember, with great power comes great responsibility ");

            }
        }
    }

    /**The ConventionHandler creates a Joptionpane popup which displays the naming convention.*/
    private class ConventionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(frmAddAccount, "The User length should be 5 Characters minimum and must contain letters and can contain numbers only. \nThe Password length should be 8 Characters minimum  and contain letters and Numbers only.");
        }
    }
    /**
     * The ExitHandler will dispose of the frame and return the user back to the menu.
     */
    private class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            frmAddAccount.dispose();
        }
    }


}


