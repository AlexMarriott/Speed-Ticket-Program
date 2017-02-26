import java.awt.event.*;
import javax.swing.*;

/**
 * Created by alex on 11/02/2017.
 */
public class SpeedingTicketGUI {
    private JLabel  lblPicture;
    private JButton btnAddDriver, btnViewDriver, btnIssueTicket, btnExit;
    private JPanel splashPagePanel;
    private JFrame splashPageFrame;

    private Ticket CheckingSpeed;
    private AddDriver AddDriverWindow;

    public SpeedingTicketGUI(){

        createSplashPage();
        addSplashPageImage();
        addSplashPageButtons();

        splashPageFrame.add(splashPagePanel);
        splashPageFrame.setVisible(true);
    }
    public void createSplashPage() {
        splashPageFrame = new JFrame();
        splashPageFrame.setTitle("DVLA Ticket Program");
        splashPageFrame.setSize(420, 350);
        splashPageFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        splashPageFrame.setVisible(true);
        splashPageFrame.setLocationRelativeTo(null);
        splashPageFrame.addWindowListener(exitListener);
        splashPageFrame.setResizable(false);


        splashPagePanel = new JPanel();
        splashPagePanel.setLayout(null);
    }

    public void addSplashPageImage() {

        ImageIcon largeDVLAImage = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(largeDVLAImage);
        lblPicture.setBounds(0, 0, 400, 200);
        splashPagePanel.add(lblPicture);
    }

    public void addSplashPageButtons() {
        btnAddDriver = new JButton("Add Driver");
        btnAddDriver.setBounds(10, 240, 100, 40);
        btnAddDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnAddDriver);

        btnViewDriver = new JButton("View Driver");
        btnViewDriver.setBounds(120, 240, 140, 40);
        btnViewDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnViewDriver);

        btnIssueTicket = new JButton("Issue Ticket");
        btnIssueTicket.setBounds(270, 240, 120, 40);
        btnIssueTicket.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnIssueTicket);

        btnExit = new JButton("Exit");
        btnExit.setBounds(140, 290, 100, 20);
        btnExit.addActionListener(new ExitSplashHandler());
        splashPagePanel.add(btnExit);
    }

    class AddDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new AddDriver();
        }
    }

    class ViewDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new ViewDriverHandler();
        }
    }

    class IssueTicketHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new RemoveDriver();
        }
    }

    //This needs to be reviewed by someone in P201.
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
    //

    class ExitSplashHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int exit = JOptionPane.showConfirmDialog(splashPageFrame, "Are You Sure You Want To Exit?", "Are You Sure", JOptionPane.YES_NO_OPTION);
            if (exit == 0) {
                System.exit(0);
            }
        }

    }
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new SpeedingTicketGUI();
    }
}

//http://stackoverflow.com/questions/3480102/java-jframe-setlocationrelativetonull-not-centering-the-window-on-ubuntu-10-0 - Help with setting the Container to open in the middle of the screen (1).