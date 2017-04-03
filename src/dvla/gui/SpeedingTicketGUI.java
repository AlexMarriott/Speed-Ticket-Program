package dvla.gui;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by alex on 11/02/2017.
 */
public class SpeedingTicketGUI {
    private JLabel lblPicture;
    private JButton btnAddDriver, btnViewDriver, btnAddLogin,btnViewVehicle, btnExit;
    private JPanel pnlMainMenu;
    private JFrame frmMainMenu;

    public SpeedingTicketGUI() {
        loadPanel();
        loadImages();
        loadButtons();
        loadMenu();

    }

    private void loadPanel() {
        pnlMainMenu = new JPanel();
        pnlMainMenu.setLayout(null);
    }

    public void loadMenu() {
        frmMainMenu = new JFrame();
        frmMainMenu.setTitle("DVLA CheckDriverSpeed Program");
        frmMainMenu.setSize(410, 365);
        frmMainMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frmMainMenu.setVisible(true);
        frmMainMenu.setLocationRelativeTo(null);
        frmMainMenu.addWindowListener(exitListener);
        frmMainMenu.setResizable(false);
        frmMainMenu.add(pnlMainMenu);
        frmMainMenu.setVisible(true);
    }

    public void loadImages() {

        ImageIcon largeDVLAImage = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(largeDVLAImage);
        lblPicture.setBounds(0, 0, 400, 200);
        pnlMainMenu.add(lblPicture);
    }

    public void loadButtons() {
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

    class AddDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new AddDriverGUI();
        }
    }

    class ViewDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new SearchDriverGUI();
        }
    }




    class ExitSplashHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int exit = JOptionPane.showConfirmDialog(frmMainMenu, "Are You Sure You Want To Exit?", "Are You Sure", JOptionPane.YES_NO_OPTION);
            if (exit == 0) {
                System.exit(0);
            }
        }

    }

    class AddLoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new AddAccountGUI();
        }

    }

    class ViewVehicleHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new SearchVehicleGUI();
        }

    }
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

    public static void main(String[] args) throws IOException {

        new SpeedingTicketGUI();
    }
}

//http://stackoverflow.com/questions/3480102/java-jframe-setlocationrelativetonull-not-centering-the-window-on-ubuntu-10-0 - Help with setting the Container to open in the middle of the screen (1).