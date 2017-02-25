import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by alex on 11/02/2017.
 */
public class SpeedingTicketGUI {
    private JLabel  lblPicture;
    private JTextField txtsearchDriver;
    private JButton btnAddDriver, btnSearchDriver, btnRemoveDriver, btnExit;
    private JPanel splashPagePanel;
    private JFrame splashPageFrame;

    private IssueTicket CheckingSpeed;
    private AddDriver AddDriverWindow;

    public SpeedingTicketGUI(){

        createSplashPage();
        addSplashPageFields();
        addSplashPageButtons();

        splashPageFrame.add(splashPagePanel);
        splashPageFrame.setVisible(true);
    }
    public void createSplashPage() {
        splashPageFrame = new JFrame();
        splashPageFrame.setTitle("DVLA Ticket Program");
        splashPageFrame.setSize(420, 350);
        splashPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashPageFrame.setVisible(true);
        splashPageFrame.setLocationRelativeTo(null);

        splashPagePanel = new JPanel();
        splashPagePanel.setLayout(null);
    }

    public void addSplashPageFields() {

        ImageIcon image = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(image);
        lblPicture.setBounds(0, 0, 400, 200);
        splashPagePanel.add(lblPicture);
    }

    public void addSplashPageButtons() {
        btnAddDriver = new JButton("Add Driver");
        btnAddDriver.setBounds(10, 240, 100, 40);
        btnAddDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnAddDriver);

        btnSearchDriver = new JButton("Search For Driver");
        btnSearchDriver.setBounds(120, 240, 140, 40);
        btnSearchDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnSearchDriver);

        btnRemoveDriver = new JButton("Remove Driver");
        btnRemoveDriver.setBounds(270, 240, 120, 40);
        btnRemoveDriver.addActionListener(new AddDriverHandler());
        splashPagePanel.add(btnRemoveDriver);

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

    class SearchDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new SearchDriver();
        }
    }

    class RemoveDriverHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new RemoveDriver();
        }
    }
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