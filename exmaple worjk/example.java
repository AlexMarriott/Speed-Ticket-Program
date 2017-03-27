/**
 * Created by Alex on 17/02/2017.
 */
    /**
         * Created by alex on 11/02/2017.

        public class example {
            private JLabel  lblPicture;
            private JTextField txtsearchDriver;
            private JButton btnAddDriver, btnSearchDriver, btnRemoveDriver, btnExit;
            private JPanel splashPagePanel;
            private JFrame splashPageFrame;

            CheckDriverSpeed test = new CheckDriverSpeed();
            TicketDataBase writingToFile = new TicketDataBase();

            public example() {
                createSplashPage();
                addSplashPageImage();
                addSplashPageButtons();

                splashPageFrame.add(splashPagePanel);
                splashPageFrame.setVisible(true);
            }

            public void createSplashPage() {
                splashPageFrame = new JFrame();
                splashPageFrame.setTitle("DVLA CheckDriverSpeed Program");
                splashPageFrame.setSize(420, 350);
                splashPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                splashPageFrame.setVisible(true);
                splashPageFrame.setLocationRelativeTo(null);

                splashPagePanel = new JPanel();
                splashPagePanel.setLayout(null);
            }

            public void addSplashPageImage() {

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
                    driverAddFrame.setVisible(false);
                }
            }

            class SearchDriverHandler implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent event) {
                    txtsearchDriver = new JTextField(null);
                    txtsearchDriver.setBounds(120, 380, 150, 20);
                    splashPagePanel.add(txtsearchDriver);
                }
            }
            class ExitSplashHandler implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent event) {
                    int n = JOptionPane.showConfirmDialog(splashPageFrame, "Are You Sure You Want To Exit?", "Are You Sure", JOptionPane.YES_NO_OPTION);
                    if (n == 0) {
                        System.exit(0);
                    }
                }
            }
            public static void main(String[] args) {
                new example();
            }
        }


        public static void main (String[] args){
            JFrame splashPageFrame = new JFrame("Test");
            splashPageFrame.setVisible(true);
            splashPageFrame.setSize(500,200);
            splashPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel splashPagePanel = new JPanel();
            splashPageFrame.add(splashPagePanel);
            JButton button = new JButton("hello agin1");
            splashPagePanel.add(button);
            button.addActionListener (new Action1());

            JButton button2 = new JButton("hello agin2");
            splashPagePanel.add(button2);
            button.addActionListener (new Action2());
        }
        static class Action1 implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                JFrame frame2 = new JFrame("Clicked");
                frame2.setVisible(true);
                frame2.setSize(200,200);
                JLabel label = new JLabel("you clicked me");
                JPanel splashPagePanel = new JPanel();
                frame2.add(splashPagePanel);
                splashPagePanel.add(label);
            }
        }
        static class Action2 implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                JFrame frame3 = new JFrame("OKNO 3");
                frame3.setVisible(true);
                frame3.setSize(200,200);

                JLabel label = new JLabel("kliknales");
                JPanel splashPagePanel = new JPanel();
                frame3.add(splashPagePanel);
                splashPagePanel.add(label);
            }
        */


