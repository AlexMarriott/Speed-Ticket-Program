package dvla.gui;

import dvla.logic.DatabaseWriter;

import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <h1> SpeedingTicketMenuGUI</h1>
 * The SpeedingTicketMenuGUI creates the GUI for the SPeedingTicketMenu. This menu allows the user to open up different parts of the program such as the Addriver screen.
 *
 * @author Alex Marriott s4816928
 * @version 1.0
 * @since 03/04/2017
 */
public class SpeedingTicketMenuGUI {
    /**
     * Declares a Jlabel named lblPicture.
     */
    private JLabel lblPicture;

    /**
     * Declares JButton named btnAddDriver, btnViewDriver, btnAddLogin, btnViewVehicle, btnExit.
     */
    private JButton btnAddDriver, btnViewDriver, btnAddLogin, btnViewVehicle, btnExit;

    /**
     * Declares JPanel named pnlMainMenu.
     */
    private JPanel pnlMainMenu;

    /**
     * Declares a JFrame named frmMainMenu.
     */
    private JFrame frmMainMenu;

    /**
     * Declares two Files named fileDriverID,fileDriverID.
     */
    private File fileDriverID, fileVehicleID;

    private DatabaseWriter checkFilesExist;


    /**
     * Constructor runs the methods to create the GUI
     */
    public SpeedingTicketMenuGUI() {
        loadPanel();
        loadImages();
        loadButtons();
        loadMenu();

    }


    /**
     * Creates the frame for the SpeedingTicketMenuGUI
     */
    private void loadMenu() {
        frmMainMenu = new JFrame();
        frmMainMenu.setTitle("DVLA Ticket Program");
        frmMainMenu.setSize(410, 365);
        frmMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmMainMenu.setLocationRelativeTo(null);
        frmMainMenu.addWindowListener(exitListener);
        frmMainMenu.setResizable(false);
        frmMainMenu.add(pnlMainMenu);
        frmMainMenu.setVisible(true);
    }

    /**
     * Creates the panel for the SpeedingTicketMenuGUI
     */
    private void loadPanel() {
        pnlMainMenu = new JPanel();
        pnlMainMenu.setLayout(null);
    }

    /**
     * Creates a ImageIcon and assigns a DVLA image to it.
     */
    private void loadImages() {
        ImageIcon largeDVLAImage = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(largeDVLAImage);
        lblPicture.setBounds(0, 0, 400, 200);
        pnlMainMenu.add(lblPicture);
    }

    /**
     * Adds Jbuttons to the SpeedingTicketMenuGUI
     */
    private void loadButtons() {
        btnAddDriver = new JButton("Add Driver");
        btnAddDriver.setBounds(10, 230, 120, 40);
        btnAddDriver.addActionListener(new AddDriverHandler());
        pnlMainMenu.add(btnAddDriver);

        btnViewDriver = new JButton("View Driver");
        btnViewDriver.setBounds(140, 230, 120, 40);
        btnViewDriver.addActionListener(new ViewDriverHandler());
        pnlMainMenu.add(btnViewDriver);

        btnAddLogin = new JButton("New Login");
        btnAddLogin.setBounds(270, 230, 120, 40);
        btnAddLogin.addActionListener(new AddLoginHandler());
        pnlMainMenu.add(btnAddLogin);

        btnViewVehicle = new JButton("View Vehicle");
        btnViewVehicle.setBounds(10, 290, 120, 40);
        btnViewVehicle.addActionListener(new ViewVehicleHandler());
        pnlMainMenu.add(btnViewVehicle);

        btnExit = new JButton("Exit");
        btnExit.setBounds(270, 290, 120, 40);
        btnExit.addActionListener(new ExitSplashHandler());
        pnlMainMenu.add(btnExit);
    }

    /**
     * AddDriverHandler instantiates a new AddDriverGUI.
     */
    private class AddDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new AddDriverGUI();
        }
    }

    /**
     * ViewDriverHandler instantiates a new SearchDriverGUI()
     * The ViewDriverHandler checks to see if the Drivers.txt exists or if it has any entrees. If this is the case then the SpeedingTicketMenuGUI
     * will return a prompt informing the user they need to add a driver first. If the file exists and there is data then the SearchDriverGUI is ran.
     */
    private class ViewDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            checkFilesExist = new DatabaseWriter();
            try {
                checkFilesExist.checkDriverTxt();
                if (!checkFilesExist.getCheckDriverTxt()) {
                    JOptionPane.showMessageDialog(frmMainMenu, "No drivers or dataStore exist, Please add a driver to view the datastore.");
                } else {
                    new SearchDriverGUI();
                }
            } catch (FileNotFoundException execption) {
                execption.printStackTrace();
            }
        }
    }

    /**
     * AddLoginHandler instantiates a new AddAccountGUI().
     */
    private class AddLoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new AddAccountGUI();
        }

    }

    /**
     * ViewVehicleHandler instantiates a new SearchVehicleGUI()
     * The ViewVehicleHandler checks to see if the vehicle.txt exists or if it has any entres. If this is the case then the SpeedingTicketMenugui
     * will return a prompt informing the user they need to add a driver first. If the file exists and there is data then the SearchVehicleGUI is ran.
     */
    private class ViewVehicleHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            checkFilesExist = new DatabaseWriter();
            try {
                checkFilesExist.checkVehicleTxt();
                if (!checkFilesExist.getCheckVehicleTxt()) {
                    JOptionPane.showMessageDialog(frmMainMenu, "No vehicle or dataStore exist, please add a driver to view the datastore.");
                } else {
                    new SearchVehicleGUI();
                }
            } catch (FileNotFoundException execption) {
                execption.printStackTrace();
            }
        }

    }

    /**
     * exitListener listens to the window waiting for input and when the user either clicks the top right X or the exit button then a prompt will appear asking the user if theya re sure theu wanna quit.
     */
    private WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent event) {
            int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure You Want To Exit?", "Are You Sure", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                System.exit(0);
            }
        }
    };

    /**
     * ExitSplashHandler prompts the user if they are sure they want to close the program.
     */
    private class ExitSplashHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int exit = JOptionPane.showConfirmDialog(frmMainMenu, "Are You Sure You Want To Exit?", "Are You Sure", JOptionPane.YES_NO_OPTION);
            if (exit == 0) {
                System.exit(0);
            }
        }

    }


}
