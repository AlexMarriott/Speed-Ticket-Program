import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 23/02/2017.
 */
public class SearchDriver {
        private JLabel lblDriverID, lblFirstName, lblLastName;
        private JTextField txtDriverID, txtFirstName, txtLastName;
        private JButton btnSearch, btnExit;
        private JPanel driverViewPanel;
        private JFrame driverViewFrame;

        protected  int driverId = 1;

        private TicketDataBase writingToFile;
        private Driver DriverInfo;
        public SearchDriver(){

            createDriverForm();
            addDriverFields();
            addDriverButtons();

            driverViewFrame.add(driverViewPanel);
            driverViewFrame.setVisible(true);
        }

        public void createDriverForm(){
            driverViewFrame = new JFrame();
            driverViewFrame.setTitle("View Driver");
            driverViewFrame.setSize(500,400);
            driverViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            driverViewFrame.setVisible(false);
            driverViewFrame.setLocationRelativeTo(null);

            driverViewPanel = new JPanel();
            driverViewPanel.setLayout(null);
        }

        public void addDriverFields(){

            lblDriverID = new JLabel("Driver ID");
            lblDriverID.setBounds(20, 250, 100, 20);
            driverViewPanel.add(lblDriverID);

            txtDriverID = new JTextField(null);
            txtDriverID.setBounds(140, 250, 100, 20);
            driverViewPanel.add(txtDriverID);

            lblFirstName = new JLabel("First Name");
            lblFirstName.setBounds(20, 270, 100, 20);
            driverViewPanel.add(lblFirstName);

            txtFirstName = new JTextField(null);
            txtFirstName.setBounds(140, 270, 100, 20);
            driverViewPanel.add(txtFirstName);

            lblLastName = new JLabel("Last Name");
            lblLastName.setBounds(20, 290, 100, 20);
            driverViewPanel.add(lblLastName);

            txtLastName = new JTextField(null);
            txtLastName.setBounds(140, 290, 100, 20);
            driverViewPanel.add(txtLastName);
        }

        public void addDriverButtons(){
            btnSearch = new JButton("Search ");
            btnSearch.setBounds(10, 325, 100, 20);
            btnSearch.addActionListener(new DriverSearchHandler());
            driverViewPanel.add(btnSearch);

            btnExit = new JButton("Remove");
            btnExit.setBounds(370, 325, 100, 20);
            btnExit.addActionListener(new DriverRemoveHandler());
            driverViewPanel.add(btnExit);

            btnExit = new JButton("Back");
            btnExit.setBounds(140, 350, 100, 30);
            btnExit.addActionListener(new DriverSearchExitHandler());
            driverViewPanel.add(btnExit);
        }
    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverViewFrame.setVisible(false);
        }
    }
    class DriverRemoveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverViewFrame.setVisible(false);
        }
    }

    class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
                driverViewFrame.setVisible(false);
            }
        }

    public static void main(String[] args) {
            new SearchDriver();
    }
    }

