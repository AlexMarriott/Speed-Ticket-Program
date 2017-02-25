import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 23/02/2017.
 */
public class RemoveDriver {
    private JLabel lblDriverID, lblFirstName, lblLastName;
    private JTextField txtDriverID, txtFirstName, txtLastName;
    private JButton btnSearch, btnExit;
    private JPanel driverRemovePanel;
    private JFrame driverRemoveFrame;

    protected  int driverId = 1;

    private TicketDataBase writingToFile;
    private Driver DriverInfo;
    public RemoveDriver(){

        createDriverForm();
        addDriverFields();
        addDriverButtons();

        driverRemoveFrame.add(driverRemovePanel);
        driverRemoveFrame.setVisible(true);
    }

    public void createDriverForm(){
        driverRemoveFrame = new JFrame();
        driverRemoveFrame.setTitle("Remove Driver");
        driverRemoveFrame.setSize(400,200);
        driverRemoveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        driverRemoveFrame.setVisible(false);
        driverRemoveFrame.setLocationRelativeTo(null);

        driverRemovePanel = new JPanel();
        driverRemovePanel.setLayout(null);
    }

    public void addDriverFields(){

        lblDriverID = new JLabel("Driver ID");
        lblDriverID.setBounds(20, 20, 100, 20);
        driverRemovePanel.add(lblDriverID);

        txtDriverID = new JTextField(null);
        txtDriverID.setBounds(140, 20, 100, 20);
        driverRemovePanel.add(txtDriverID);

        lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(20, 50, 100, 20);
        driverRemovePanel.add(lblFirstName);

        txtFirstName = new JTextField(null);
        txtFirstName.setBounds(140, 50, 100, 20);
        driverRemovePanel.add(txtFirstName);

        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(20, 80, 100, 20);
        driverRemovePanel.add(lblLastName);

        txtLastName = new JTextField(null);
        txtLastName.setBounds(140, 80, 100, 20);
        driverRemovePanel.add(txtLastName);
    }

    public void addDriverButtons(){
        btnSearch = new JButton("Search ");
        btnSearch.setBounds(10, 130, 100, 20);
        btnSearch.addActionListener(new RemoveDriver.DriverSearchHandler());
        driverRemovePanel.add(btnSearch);

        btnExit = new JButton("Back");
        btnExit.setBounds(275, 130, 100, 20);
        btnExit.addActionListener(new RemoveDriver.DriverSearchExitHandler());
        driverRemovePanel.add(btnExit);
    }
    class DriverSearchHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverRemoveFrame.setVisible(false);
        }
    }

    class DriverSearchExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverRemoveFrame.setVisible(false);
        }
    }
}
