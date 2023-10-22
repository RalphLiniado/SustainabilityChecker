
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class StartFrame extends JFrame{
    //first window objects
    public JFrame theFrame;
    public JButton button;
    public JLabel topLabel;
    public ImageIcon backgroundIcon;
    public JLabel backgroundLabel;
    //second window objects
    public int personsInt;
    public JFrame newJFrame = new JFrame();
    public JLabel errorLabel;
    public JLabel errorLabel2;
    //third window objects
    public JFrame thirdJFrame = new JFrame();
    public JFrame fourthJFrame = new JFrame();
    public int energyInt;
    public JButton backButton;
    public JButton notSureButton;
    public JButton exitButton;
    public JButton exitButton2;
    public double energyPerPerson;
    public int milesInt;
    //fourth window objects
    public JFrame publicTransport = new JFrame();
    public int publicInt;
    public char publicChar;
    public int carChecker;
    //fifth window objects
    public JFrame carMPG = new JFrame();
    public int MPGInt;
    //sixth window objects
    public int flushInt;
    public JFrame waterUsage = new JFrame();
    public int waterInt;
    //seventh window objects
    public int flyInt;
    public JFrame planeFly = new JFrame();
    //eigth window objects
    public int trashInt;
    public JFrame trashUsage = new JFrame();
    //final window objects
    public JFrame finalScreen = new JFrame();

    public StartFrame() {
        theFrame = new JFrame();
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLayout(null);
        theFrame.setPreferredSize(new Dimension(600, 600));
        theFrame.setMinimumSize(new Dimension(600, 600));
        theFrame.setMaximumSize(new Dimension(600, 600));

        backgroundIcon = new ImageIcon(this.getClass().getResource("backgroundImage.jpeg"));
        
        topLabel = new JLabel();
        topLabel.setText("How Sustainable are You?");
        topLabel.setFont(new Font("Calibri",Font.BOLD, 25));
        topLabel.setBounds(125, 45, 400, 50);

        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 600, 600);

        button = new JButton("Test Your Sustainability!");
        button.setFont(new Font("Calibri",Font.PLAIN, 15));
        button.setBounds(175,240,250,60);

        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onFirstClick();
                theFrame.setVisible(false);
            }
        });
        theFrame.add(topLabel);
        theFrame.add(button);
        theFrame.add(backgroundLabel);      
        theFrame.pack();
        theFrame.setVisible(true);
    }   

    //HOUSEHOLD QUESTION
    public void onFirstClick() {

        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);
        
       //newJFrame = new JFrame("Question 1");
        newJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newJFrame.setLayout(null);
        newJFrame.setPreferredSize(new Dimension(600, 600));
        newJFrame.setMinimumSize(new Dimension(600, 600));
        newJFrame.setMaximumSize(new Dimension(600, 600));
        

        JLabel newLabel = new JLabel("How many people live in your household?");
        
        newLabel.setBorder(border);
        newLabel.setBounds(100, 70, 400, 50);
        newLabel.setBackground(Color.WHITE);
        newLabel.setOpaque(true);
        newLabel.setFont(new Font("Calibri",Font.BOLD, 17));

        JLabel houseBackground;
        ImageIcon houseIcon;
        houseIcon = new ImageIcon(this.getClass().getResource("theRealHouse.jpg"));
        houseBackground = new JLabel(houseIcon);
        houseBackground.setBounds(0, 0, 600, 600);

        JTextField personsTextField = new JTextField();
        personsTextField.setPreferredSize(new Dimension(300, 50));
        personsTextField.setBounds(250, 200, 100, 50);

        exitButton();
        
        JButton textButton = new JButton("Submit");
        textButton.setBounds(360, 200, 100, 50);
        textButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String personsText = personsTextField.getText();
                try {
                    personsInt = Integer.parseInt(personsText);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    onSecondClick();
                    newJFrame.setVisible(false);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });


        newJFrame.add(exitButton);
        newJFrame.add(errorLabel);
        newJFrame.add(newLabel);
        newJFrame.add(textButton);
        newJFrame.add(personsTextField);
        newJFrame.add(houseBackground);
        newJFrame.pack();
        newJFrame.setVisible(true);
    }

    //energy usage window
    public void onSecondClick() {
        
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);

        // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onFirstClick();
                thirdJFrame.setVisible(false);
            }
        });

        // NOT SURE BUTTON
        notSureButton();
        notSureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                energyPerPerson = 300;
                energyInt = -1;
                onThirdClick();
                thirdJFrame.setVisible(false);
            }
        });


        thirdJFrame = new JFrame("Question 2");
    
        thirdJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thirdJFrame.setLayout(null);
        thirdJFrame.setPreferredSize(new Dimension(600, 600));
        thirdJFrame.setMinimumSize(new Dimension(600, 600));
        thirdJFrame.setMaximumSize(new Dimension(600, 600));
        
        

        JLabel energyLabel = new JLabel("What is your household monthly energy usage in kWh?");
        energyLabel.setBorder(border);
        energyLabel.setBackground(Color.WHITE);
        energyLabel.setBounds(50, 70, 500, 50);
        energyLabel.setOpaque(true);
        energyLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField energyTextField = new JTextField();
        energyTextField.setPreferredSize(new Dimension(300, 50));
        energyTextField.setBounds(250, 200, 100, 50);
        
        exitButton(); 

        JButton energyTextButton = new JButton("Submit");
        energyTextButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        energyTextButton.setBounds(360, 200, 100, 50);

        energyTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String energyText = energyTextField.getText();
                try {
                    energyInt = Integer.parseInt(energyText);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    onThirdClick();
                    thirdJFrame.setVisible(false);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });

        JLabel lightBackground;
        ImageIcon lightIcon;
        lightIcon = new ImageIcon(this.getClass().getResource("light.jpg"));
        lightBackground = new JLabel(lightIcon);
        lightBackground.setBounds(0, 0, 600, 600);

        thirdJFrame.add(exitButton);
        thirdJFrame.add(errorLabel);
        thirdJFrame.add(notSureButton);
        thirdJFrame.add(backButton);
        thirdJFrame.add(energyLabel);
        thirdJFrame.add(energyTextField);
        thirdJFrame.add(energyTextButton);
        thirdJFrame.add(lightBackground);
        thirdJFrame.setVisible(true);
    }

    //car window
    public void onThirdClick() {
        
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);

        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSecondClick();
                fourthJFrame.setVisible(false);
            }
        });

        fourthJFrame = new JFrame("Question 3");
        fourthJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fourthJFrame.setLayout(null);
        fourthJFrame.setPreferredSize(new Dimension(600, 600));
        fourthJFrame.setMinimumSize(new Dimension(600, 600));
        fourthJFrame.setMaximumSize(new Dimension(600, 600));
        
        JTextField milesTextField = new JTextField();
        milesTextField.setPreferredSize(new Dimension(300, 50));
        milesTextField.setBounds(250, 200, 100, 50);



        JLabel promptLabel = new JLabel("Do you drive a car? If not select No, if yes, estimate");
        promptLabel.setBorder(border);
        promptLabel.setBackground(Color.WHITE);
        promptLabel.setBounds(50, 20, 500, 50);
        promptLabel.setOpaque(true);
        promptLabel.setFont(new Font("Calibri",Font.BOLD, 17));


        JLabel milesLabel = new JLabel("how many miles you drive per week on average?");
        milesLabel.setBorder(border);
        milesLabel.setBackground(Color.WHITE);
        milesLabel.setBounds(50, 70, 500, 50);
        milesLabel.setOpaque(true);
        milesLabel.setFont(new Font("Calibri",Font.BOLD, 17));

        JButton milesTextButton = new JButton("Submit");
        milesTextButton.setBounds(360, 200, 100, 50);

        JButton noButton = new JButton("No");
        noButton.setBounds(250, 250, 100, 50);

        JLabel milesBackground;
        ImageIcon milesIcon;
        milesIcon = new ImageIcon(this.getClass().getResource("car.jpeg"));
        milesBackground = new JLabel(milesIcon);
        milesBackground.setBounds(0, 0, 600, 600);

        exitButton(); 

        milesTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String milesText = milesTextField.getText();
                try {
                    milesInt = Integer.parseInt(milesText);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    carMPG();
                    fourthJFrame.setVisible(false);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                publicTransport();
                fourthJFrame.setVisible(false);
                carChecker = 0;
            }
        });

        fourthJFrame.add(noButton);
        fourthJFrame.add(promptLabel);
        fourthJFrame.add(milesTextField);
        fourthJFrame.add(backButton);
        fourthJFrame.add(milesLabel);
        fourthJFrame.add(milesTextField);
        fourthJFrame.add(milesTextButton);
        fourthJFrame.add(milesBackground);
        fourthJFrame.setVisible(true);
    }
    
    //PUBLIC TRANSPORT
    public void publicTransport() {

        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);

      // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carChecker == -1) {
                    carMPG();
                    publicTransport.setVisible(false);
                } else {
                    onThirdClick();
                    publicTransport.setVisible(false);
                }
            }
        });

        publicTransport = new JFrame("Question 4");
        publicTransport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        publicTransport.setLayout(null);
        publicTransport.setPreferredSize(new Dimension(600, 600));
        publicTransport.setMinimumSize(new Dimension(600, 600));
        publicTransport.setMaximumSize(new Dimension(600, 600));

        JLabel publicLabel = new JLabel("<html>Please enter the letter key of the transport <br>you use most, " +
        "if none, select none:<br>Train - t, Bus - b, Bike - p, Walk - w<html>");
        publicLabel.setBorder(border);
        publicLabel.setBackground(Color.WHITE);
        publicLabel.setBounds(50, 60, 500, 100);
        publicLabel.setOpaque(true);
        publicLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField publicTextField = new JTextField();
        publicTextField .setPreferredSize(new Dimension(300, 50));
        publicTextField .setBounds(250, 200, 100, 50);
        
        exitButton2(); 

        JButton publicTextButton = new JButton("Submit");
        publicTextButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        publicTextButton.setBounds(360, 200, 100, 50);

        publicTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String publicText = publicTextField.getText();
                if (publicText.equals("p") || publicText.equals("w") 
                || publicText.equals("b") || publicText.equals("t")) {
                    publicChar = publicText.charAt(0);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    waterUsage();
                    publicTransport.setVisible(false);
                } else {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });

        JButton noneButton = new JButton("None");
        noneButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        noneButton.setBounds(250, 250, 100, 50);

        noneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                waterUsage();
                publicTransport.setVisible(false);
            }
        });
        
        JLabel publicBackground;
        ImageIcon publicIcon;
        publicIcon = new ImageIcon(this.getClass().getResource("bus.jpeg"));
        publicBackground = new JLabel(publicIcon);
        publicBackground.setBounds(0, 0, 600, 600);

        publicTransport.add(exitButton);
        publicTransport.add(noneButton);
        publicTransport.add(errorLabel);
        publicTransport.add(backButton);
        publicTransport.add(publicLabel);
        publicTransport.add(publicTextField);
        publicTransport.add(publicTextButton);
        publicTransport.add(publicBackground);
        publicTransport.setVisible(true);
    }
          

    //CAR MPG METHOD
    public void carMPG() {
        carChecker = -1;
        MPGInt = 1;
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);

         // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onThirdClick();
                carMPG.setVisible(false);
            }
        });

        carMPG = new JFrame("Question 4");
        carMPG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carMPG.setLayout(null);
        carMPG.setPreferredSize(new Dimension(600, 600));
        carMPG.setMinimumSize(new Dimension(600, 600));
        carMPG.setMaximumSize(new Dimension(600, 600));

        JLabel MPGLabel = new JLabel("Estimate how many miles per gallon your car gets:");
        MPGLabel.setBorder(border);
        MPGLabel.setBackground(Color.WHITE);
        MPGLabel.setBounds(50, 70, 500, 50);
        MPGLabel.setOpaque(true);
        MPGLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField MPGTextField = new JTextField();
        MPGTextField.setPreferredSize(new Dimension(300, 50));
        MPGTextField.setBounds(250, 200, 100, 50);
        
        exitButton(); 

        JButton MPGTextButton = new JButton("Submit");
        MPGTextButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        MPGTextButton.setBounds(360, 200, 100, 50);

        MPGTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MPGText = MPGTextField.getText();
                try {
                    MPGInt = Integer.parseInt(MPGText);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    publicTransport();
                    carMPG.setVisible(false);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });

        JLabel MPGBackground;
        ImageIcon MPGIcon;
        MPGIcon = new ImageIcon(this.getClass().getResource("gasCan.jpeg"));
        MPGBackground = new JLabel(MPGIcon);
        MPGBackground.setBounds(0, 0, 600, 600);

        carMPG.add(exitButton);
        carMPG.add(errorLabel);
        carMPG.add(backButton);
        carMPG.add(MPGLabel);
        carMPG.add(MPGTextField);
        carMPG.add(MPGTextButton);
        carMPG.add(MPGBackground);
        carMPG.setVisible(true);
    }
    
    //WATER STUFFFFFFFFFFFFFFFFFF
    public void waterUsage() {
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);
        // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                publicTransport();
                waterUsage.setVisible(false);
            }
        });

        waterUsage = new JFrame("Question 5");
        waterUsage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waterUsage.setLayout(null);
        waterUsage.setPreferredSize(new Dimension(600, 600));
        waterUsage.setMinimumSize(new Dimension(600, 600));
        waterUsage.setMaximumSize(new Dimension(600, 600));

        JLabel waterLabel = new JLabel("How long do you shower for per day in mins?");
        waterLabel.setBorder(border);
        waterLabel.setBackground(Color.WHITE);
        waterLabel.setBounds(50, 70, 500, 50);
        waterLabel.setOpaque(true);
        waterLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField waterTextField = new JTextField();
        waterTextField.setPreferredSize(new Dimension(300, 50));
        waterTextField.setBounds(250, 150, 100, 50);
        
        JLabel flushLabel = new JLabel("How many times do you go to the bathroom per day?");
        flushLabel.setBorder(border);
        flushLabel.setBackground(Color.WHITE);
        flushLabel.setBounds(50, 220, 500, 50);
        flushLabel.setOpaque(true);
        flushLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField flushTextField = new JTextField();
        flushTextField.setPreferredSize(new Dimension(300, 50));
        flushTextField.setBounds(250, 300, 100, 50);
 
        exitButton3();
        
        JButton flushTextButton = new JButton("Submit");
        flushTextButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        flushTextButton.setBounds(360, 300, 100, 50);

        exitButton4();
        
        
        flushTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flushText = flushTextField.getText();
                try {
                    flushInt = Integer.parseInt(flushText);
                } catch (NumberFormatException NFE) {
                    errorLabel2.setVisible(true);
                    exitButton2.setVisible(true);
                    flushInt = -1;
                }

                String waterText = waterTextField.getText();
                try {
                    waterInt = Integer.parseInt(waterText);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                    waterInt = -1;
                }
                
                if (waterInt >= 0 && flushInt >= 0) {
                    planeFly();
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    waterUsage.setVisible(false);
                    errorLabel.setVisible(false);
                    errorLabel.setVisible(false);
                    waterUsage.setVisible(false);
                }
            }
        });

        JLabel waterBackground;
        ImageIcon waterIcon;
        waterIcon = new ImageIcon(this.getClass().getResource("water.jpeg"));
        waterBackground = new JLabel(waterIcon);
        waterBackground.setBounds(0, 0, 600, 600);
        waterUsage.add(exitButton);
        waterUsage.add(errorLabel);
        waterUsage.add(exitButton2);
        waterUsage.add(errorLabel2);
        waterUsage.add(backButton);
        waterUsage.add(flushLabel);
        waterUsage.add(flushTextField);
        waterUsage.add(flushTextButton);
        waterUsage.add(waterLabel);
        waterUsage.add(waterTextField);
        waterUsage.add(waterBackground);
        waterUsage.setVisible(true);
    }

//PLANE FLYYYY
    public void planeFly() {
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);
        // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                waterUsage();
                planeFly.setVisible(false);
            }
        });

        planeFly = new JFrame("Question 6");
        planeFly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        planeFly.setLayout(null);
        planeFly.setPreferredSize(new Dimension(600, 600));
        planeFly.setMinimumSize(new Dimension(600, 600));
        planeFly.setMaximumSize(new Dimension(600, 600));

        JLabel planeLabel = new JLabel("Estimate how many flights you take per year...");
        planeLabel.setBorder(border);
        planeLabel.setBackground(Color.WHITE);
        planeLabel.setBounds(50, 70, 500, 50);
        planeLabel.setOpaque(true);
        planeLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField planeTextField = new JTextField();
        planeTextField.setPreferredSize(new Dimension(300, 50));
        planeTextField.setBounds(250, 200, 100, 50);
        
        exitButton(); 

        JButton planeTextButton = new JButton("Submit");
        planeTextButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        planeTextButton.setBounds(360, 200, 100, 50);

        planeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String planeText = planeTextField.getText();
                try {
                    flyInt = Integer.parseInt(planeText);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    trashUsage();
                    planeFly.setVisible(false);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });

        JLabel planeBackground;
        ImageIcon planeIcon;
        planeIcon = new ImageIcon(this.getClass().getResource("plane.jpeg"));
        planeBackground = new JLabel(planeIcon);
        planeBackground.setBounds(0, 0, 600, 600);

        planeFly.add(exitButton);
        planeFly.add(errorLabel);
        planeFly.add(backButton);
        planeFly.add(planeLabel);
        planeFly.add(planeTextField);
        planeFly.add(planeTextButton);
        planeFly.add(planeBackground);
        planeFly.setVisible(true);
    }

//TRASH LITTTT
    public void trashUsage() {
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);
        // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planeFly();
                trashUsage.setVisible(false);
            }
        });

        trashUsage = new JFrame("Question 7");
        trashUsage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trashUsage.setLayout(null);
        trashUsage.setPreferredSize(new Dimension(600, 600));
        trashUsage.setMinimumSize(new Dimension(600, 600));
        trashUsage.setMaximumSize(new Dimension(600, 600));

        JLabel trashLabel = new JLabel("<html>How many bags of trash does your household<br>take out every week?<html>");
        trashLabel.setBorder(border);
        trashLabel.setBackground(Color.WHITE);
        trashLabel.setBounds(50, 70, 500, 50);
        trashLabel.setOpaque(true);
        trashLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        
        JTextField trashTextField = new JTextField();
        trashTextField.setPreferredSize(new Dimension(300, 50));
        trashTextField.setBounds(250, 200, 100, 50);
        
        exitButton(); 

        JButton trashTextButton = new JButton("Submit");
        trashTextButton.setFont(new Font("Calibri",Font.PLAIN, 15));
        trashTextButton.setBounds(360, 200, 100, 50);

        trashTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trashText = trashTextField.getText();
                try {
                    trashInt = Integer.parseInt(trashText);
                    errorLabel.setVisible(false);
                    exitButton.setVisible(false);
                    finalScreen();
                    trashUsage.setVisible(false);
                } catch (NumberFormatException NFE) {
                    errorLabel.setVisible(true);
                    exitButton.setVisible(true);
                }
            }
        });

        JLabel trashBackground;
        ImageIcon trashIcon;
        trashIcon = new ImageIcon(this.getClass().getResource("trash.jpeg"));
        trashBackground = new JLabel(trashIcon);
        trashBackground.setBounds(0, 0, 600, 600);

        trashUsage.add(exitButton);
        trashUsage.add(errorLabel);
        trashUsage.add(backButton);
        trashUsage.add(trashLabel);
        trashUsage.add(trashTextField);
        trashUsage.add(trashTextButton);
        trashUsage.add(trashBackground);
        trashUsage.setVisible(true);
    }
//FINAL SCREEN
    public void finalScreen() {
        Color darkGreen = new Color(0, 100, 0); //RGB value
        Border border = BorderFactory.createLineBorder(darkGreen,3);
        // BACK BUTTON
        backButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trashUsage();
                finalScreen.setVisible(false);
            }
        });

        finalScreen = new JFrame("Your Data");
        finalScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finalScreen.setLayout(null);
        finalScreen.setPreferredSize(new Dimension(600, 600));
        finalScreen.setMinimumSize(new Dimension(600, 600));
        finalScreen.setMaximumSize(new Dimension(600, 600));

        double energyWeight = (double) Math.round(electricityEnergy() * 100d) / 100d;
        double transportWeight = (double) Math.round(transportEnergy() * 100d) / 100d;
        double waterWeight = (double) Math.round(waterEnergy() * 100d) / 100d;
        double planeWeight = (double) Math.round(planeEnergy() * 100d) / 100d;
        double trashWeight = (double) Math.round(trashEnergy() * 100d) / 100d;
        String overallScore = overallScore();

        JLabel finalLabel = new JLabel("<html>Your Results:<br>Electricity: " + energyWeight + " pounds of CO2 a month.<br>Transportation: " 
        + transportWeight + " pounds of CO2 a month.<br>Water Usage: " 
        + waterWeight + " pounds of CO2 a month.<br>Plane Transportation: " 
        + planeWeight + " pounds of CO2 a month.<br>Trash: " 
        + trashWeight + " pounds of CO2 a month.<br>Overall Score: "
        + overallScore + "<html>");

        finalLabel.setBorder(border);
        finalLabel.setBackground(Color.WHITE);
        finalLabel.setBounds(100, 0, 400, 300);
        finalLabel.setOpaque(true);
        finalLabel.setFont(new Font("Calibri",Font.BOLD, 17));

        JLabel underLabel = new JLabel("<html>Tips to reduce your Carbon Footprint:<br>1. Conserve Energy<br>2. Walk and Bike<br>3. Reduce Water " + 
        "Consumption<br>4. Minimize Air Travel<br>5. Compost<br>6. Recycle<br>7. Plant Trees<br>8. Limit Waste<html>");
        underLabel.setBorder(border);
        underLabel.setBackground(Color.WHITE);
        underLabel.setBounds(100, 300, 400, 300);
        underLabel.setOpaque(true);
        underLabel.setFont(new Font("Calibri",Font.BOLD, 17));
        

        JLabel finalBackground;
        ImageIcon finalIcon;
        finalIcon = new ImageIcon(this.getClass().getResource("forest.jpeg"));
        finalBackground = new JLabel(finalIcon);
        finalBackground.setBounds(0, 0, 600, 600);

        finalScreen.add(backButton);
        finalScreen.add(finalLabel);
        finalScreen.add(underLabel);

        finalScreen.add(finalBackground);
        finalScreen.setVisible(true);
    }

    public void backButton() {
        // BACK BUTTON
        backButton = new JButton("Back");
        backButton.setBounds(0, 525, 50, 50);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        backButton.setForeground(Color.RED);
        backButton.setBackground(Color.BLACK);
        backButton.setVisible(true);
    }

    public void notSureButton() {
        notSureButton = new JButton("Not Sure");
        notSureButton.setBounds(250, 250, 100, 50);
        notSureButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        notSureButton.setForeground(Color.BLACK);
        notSureButton.setBackground(Color.WHITE);
        notSureButton.setVisible(true);
    }

    public void exitButton() {
        errorLabel = new JLabel("Please give a whole number only.");
        errorLabel.setBounds(200, 200, 300, 50);
        errorLabel.setOpaque(true);
        errorLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        errorLabel.setVisible(false);
        
        exitButton = new JButton("X");
        exitButton.setBounds(150, 200, 50, 50);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 10));
        exitButton.setForeground(Color.RED);
        exitButton.setBackground(Color.BLACK);
        exitButton.setVisible(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                exitButton.setVisible(false);
            }
        });
    }

    public void exitButton2() {
        errorLabel = new JLabel("<html>Please enter one of the 4 characters:<br>t, b, p, or w.</html>");
        errorLabel.setBounds(150, 200, 350, 50);
        errorLabel.setOpaque(true);
        errorLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        errorLabel.setVisible(false);
        
        exitButton = new JButton("X");
        exitButton.setBounds(100, 200, 50, 50);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 10));
        exitButton.setForeground(Color.RED);
        exitButton.setBackground(Color.BLACK);
        exitButton.setVisible(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                exitButton.setVisible(false);
            }
        });
    }
    public void exitButton3() {
        errorLabel = new JLabel("Please enter a whole number.");
        errorLabel.setBounds(250, 150, 300, 50);
        errorLabel.setOpaque(true);
        errorLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        errorLabel.setVisible(false);
        
        exitButton = new JButton("X");
        exitButton.setBounds(200, 150, 50, 50);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 10));
        exitButton.setForeground(Color.RED);
        exitButton.setBackground(Color.BLACK);
        exitButton.setVisible(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                exitButton.setVisible(false);
            }
        });
    }
    public void exitButton4() {
        errorLabel2 = new JLabel("Please enter a whole number.");
        errorLabel2.setBounds(250, 300, 300, 50);
        errorLabel2.setOpaque(true);
        errorLabel2.setFont(new Font("Calibri", Font.BOLD, 17));
        
        errorLabel2.setVisible(false);
        
        exitButton2 = new JButton("X");
        exitButton2.setBounds(200, 300, 50, 50);
        exitButton2.setFont(new Font("Calibri", Font.BOLD, 10));
        exitButton2.setForeground(Color.RED);
        exitButton2.setBackground(Color.BLACK);
        exitButton2.setVisible(false);
        exitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel2.setVisible(false);
                exitButton2.setVisible(false);
            }
        });
    }
    
    // House Energy Use Calculations
    public double electricityEnergy() {
        double energyWeight;
        if (energyInt == -1) {
            energyWeight = energyPerPerson * 0.994;
        } else {
            energyPerPerson = energyInt / personsInt;
            energyWeight = energyPerPerson * 0.994;
        }
        return energyWeight;
    }

    // Transport Use Calculations
    public double transportEnergy() {
        double transportWeight = 0;
        if (publicChar == 'w' || publicChar == 'p') {
            transportWeight = 0;
        } else if (publicChar == 't') {
            transportWeight = 19.51 * 28;
        } else if (publicChar == 'b') {
            transportWeight = 32.95 * 28;
        }
        int gasUsage = milesInt / MPGInt;
        transportWeight += gasUsage * 19.6 * 4;
        
        return transportWeight;
    }
    //Public Water Use Calculations
    public double waterEnergy() {
        double waterWeight = 0;
        waterWeight += flushInt * .139;
        waterWeight += waterInt * .218;
        waterWeight *= 30;
        return waterWeight;
    }

    public double planeEnergy() {
        double planeWeight;
        planeWeight = flyInt * 250 / 12;
        return planeWeight;
    }

    public double trashEnergy() {
        double trashWeight;
        trashWeight = trashInt * 11 * 4;
        return trashWeight;
    }

    public String overallScore() {

    double energyWeight = electricityEnergy();
    double transportWeight = transportEnergy();
    double waterWeight = waterEnergy();
    double planeWeight = planeEnergy();
    double trashWeight = trashEnergy();
    String overallScore;
    double scoreInt = energyWeight + transportWeight + waterWeight + planeWeight + trashWeight;

        if (scoreInt > 1200 && scoreInt < 1600) {
            overallScore = "You are moderately sustainable.";
        } else if (scoreInt < 1200) {
            overallScore = "You are more sustainable than the average person.";
        } else {
            overallScore = "You are less sustainable than the average person.";
        }
    return overallScore;
    }
}