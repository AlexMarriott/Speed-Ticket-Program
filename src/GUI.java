import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 11/02/2017.
 */
public class GUI {
    private JLabel lblSpeed, lblRoadType, lblDriversName;
    private JTextField txtSpeed, txtDriversName;
    private JButton btnResidentialRoad, btnMainRoad, btnSchoolZone, btnSingleCarriageway, btnDualCarriageway, btnSubmit, btnExit;
    private JPanel panel;
    private JFrame frame;

    public GUI(){
        createForm();
        addFields();
        addButtons();

        frame.add(panel);
        frame.setVisible(true);
    }

    public void createForm(){
        frame = new JFrame();
        frame.setTitle("DVLA Ticket Program");
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
    }

    public void addFields(){
        lblDriversName = new JLabel("Drivers Name");
        lblDriversName.setBounds(20, 520, 100, 20);
        panel.add(lblDriversName);

        txtDriversName = new JTextField("i.e  " + "Alex Marriott");
        txtDriversName.setBounds(120, 520, 150, 20);
        panel.add(txtDriversName);

        lblRoadType = new JLabel("Road Type");
        lblRoadType.setBounds(20, 550, 100, 20);
        panel.add(lblRoadType);

        lblSpeed = new JLabel("Drivers Speed");
        lblSpeed.setBounds(20, 580, 100, 20);
        panel.add(lblSpeed);

        txtSpeed = new JTextField("i.e  " + "50");
        txtSpeed.setBounds(120, 580, 150, 20);
        panel.add(txtSpeed);
    }

    public void addButtons(){
        btnSchoolZone = new JButton("SchoolZone");
        btnSchoolZone.setBounds(120, 550, 120, 20);
        btnSchoolZone.addActionListener(new SchoolZoneHandler());
        panel.add(btnSchoolZone);

        btnResidentialRoad = new JButton("Residential");
        btnResidentialRoad.setBounds(240, 550, 100, 20);
        btnResidentialRoad.addActionListener(new ResidentialRoadHandler());
        panel.add(btnResidentialRoad);

        btnMainRoad = new JButton("MainRoad");
        btnMainRoad.setBounds(340, 550, 100, 20);
        btnMainRoad.addActionListener(new MainRoadHandler());
        panel.add(btnMainRoad);

        btnSingleCarriageway = new JButton("SingleCarriageway");
        btnSingleCarriageway.setBounds(440, 550, 160, 20);
        btnSingleCarriageway.addActionListener(new SingleCarriagewayHandler());
        panel.add(btnSingleCarriageway);

        btnDualCarriageway = new JButton("DualCarriageway");
        btnDualCarriageway.setBounds(600, 550, 160, 20);
        btnDualCarriageway.addActionListener(new DualCarriagewayHandler());
        panel.add(btnDualCarriageway);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 625, 100, 20);
        btnSubmit.addActionListener(new SubmitHandler());
        panel.add(btnSubmit);

        btnExit = new JButton("Exit");
        btnExit.setBounds(450, 625, 100, 20);
        btnExit.addActionListener(new ExitHandler());
        panel.add(btnExit);
    }

    class SchoolZoneHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }

    class ResidentialRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }
    class MainRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }
    class SingleCarriagewayHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }
    class DualCarriagewayHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }
    class SubmitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
    }

    class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new GUI();
    }
}

//http://stackoverflow.com/questions/3480102/java-jframe-setlocationrelativetonull-not-centering-the-window-on-ubuntu-10-0 - Help with setting the Container to open in the middle of the screen (1).