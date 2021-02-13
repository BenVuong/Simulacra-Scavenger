package package01;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import package01.Game.ChoiceHandler;
public class UI 
{
	int hp = 20;
	String title = "Simulacra Scavenger";
	JFrame window;
    Container container;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel,hpLabel, hpLabelNum, weaponLabel, tokenLabel;
    Font titleFont = new Font("Agency FB",Font.PLAIN, 60);
    Font normalFont = new Font("Times New Roman",Font.PLAIN,30);
    JButton startButton,choice1,choice2,choice3,choice4 ;
    JTextArea mainTextArea;
    private ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("bolter-gun.png"));
    private ImageIcon rainIcon;
    JLabel rainLabel;
    

	public void createUI(ChoiceHandler choiceHandler) 
	{
		//Window
				rainIcon = new ImageIcon(getClass().getClassLoader().getResource("rainbig.gif"));
		        rainLabel = new JLabel(rainIcon);
		        rainLabel.setSize(800,600);
		        window = new JFrame();
		        window.setTitle(title);
		        window.setSize(800,600);//set the size of the window to 800 pixel by 600 pixel
		        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the window it will exit the program
		        window.getContentPane().setBackground(Color.BLACK);
		        window.setLayout(null);
		        window.setResizable(false);
		        window.setIconImage(icon.getImage());
		        
		        container = window.getContentPane();
		        
		        
		        //Title Screen
		        titleNamePanel = new JPanel();// create the title for the main menu
		        titleNamePanel.setBounds(100,200,600,75);
		        titleNamePanel.setBackground(new Color(0,0,0,0));
		        titleNameLabel = new JLabel(title);
		        titleNameLabel.setForeground(Color.RED);
		        titleNameLabel.setFont(titleFont);
		        titleNamePanel.add(titleNameLabel);
		        
		        //Start Button
		        startButtonPanel = new JPanel();
		        startButtonPanel.setBounds(300, 400, 200,55);
		        startButtonPanel.setBackground(new Color(0,0,0,0));
		        startButton = new JButton("Start Game");
		        startButton.setForeground(Color.WHITE);
		        startButton.setBackground(Color.BLACK);
		        startButton.setFont(normalFont);
		        startButton.addActionListener(choiceHandler);
		        startButton.setActionCommand("title");
		        startButton.setFocusPainted(false);
		        startButtonPanel.add(startButton);
		        
		        container.add(titleNamePanel);
		        container.add(startButtonPanel);
		        window.add(rainLabel);
		        
		        
		        //Game Screen
		        playerPanel = new JPanel();
		        playerPanel.setBounds(100,15,700,50);
		        playerPanel.setBackground(Color.BLACK);
		        playerPanel.setLayout(new GridLayout(1,4));
		        container.add(playerPanel);
		        
		        hpLabel = new JLabel();
		        hpLabel.setFont(normalFont);
		        hpLabel.setBackground(Color.BLACK);
		        hpLabel.setForeground(Color.WHITE);
		        playerPanel.add(hpLabel);
		        
		        weaponLabel = new JLabel();
		        weaponLabel.setFont(normalFont);
		        weaponLabel.setBackground(Color.BLACK);
		        weaponLabel.setForeground(Color.WHITE);
		        playerPanel.add(weaponLabel);
		        
		        tokenLabel = new JLabel();
		        tokenLabel.setFont(normalFont);
		        tokenLabel.setBackground(Color.BLACK);
		        tokenLabel.setForeground(Color.WHITE);
		        playerPanel.add(tokenLabel);
		        
		       
		        hpLabel.setText("Hp: ");
		    	weaponLabel.setText("Weapon: ");
		    	
		        
		        
		        mainTextPanel = new JPanel();
		        mainTextPanel.setBounds(100,100,600,250);
		        mainTextPanel.setBackground(Color.BLACK);
		        container.add(mainTextPanel);

		        mainTextArea = new JTextArea();
		        mainTextArea.setText("Welcome to BLOCKCHAIN BELOW\n        Numbers of players Online:1");
		        //mainTextArea.setHighlighter(null);
		        mainTextArea.setEditable(false);
		        mainTextArea.setBounds(100,100,600,400);
		        mainTextArea.setBackground(Color.BLACK);
		        mainTextArea.setForeground(Color.WHITE);
		        mainTextArea.setWrapStyleWord(true);
		        mainTextArea.setFont(normalFont);
		        mainTextArea.setLineWrap(true);
		        mainTextPanel.add(mainTextArea);

		        choiceButtonPanel = new JPanel();
		        choiceButtonPanel.setBounds(250,350,300,160);
		        choiceButtonPanel.setBackground(new Color(0,0,0,0));
		        choiceButtonPanel.setLayout(new GridLayout(4,1));
		        container.add(choiceButtonPanel);

		        choice1 = new JButton();
		        choice1.setText("heal");
		        choice1.setBackground(Color.BLACK);
		        choice1.setForeground(Color.WHITE);
		        choice1.setFont(normalFont);
		        choice1.setFocusPainted(false);
		        choice1.addActionListener(choiceHandler);
		        choice1.setActionCommand("c1");
		        choiceButtonPanel.add(choice1);

		        choice2 = new JButton();
		        choice2.setText("hurt");
		        choice2.setBackground(Color.BLACK);
		        choice2.setForeground(Color.WHITE);
		        choice2.setFont(normalFont);
		        choice2.setFocusPainted(false);
		        choice2.addActionListener(choiceHandler);
		        choice2.setActionCommand("c2");
		        choiceButtonPanel.add(choice2);

		        choice3 = new JButton("Choice 3");
		        choice3.setBackground(Color.BLACK);
		        choice3.setForeground(Color.WHITE);
		        choice3.setFont(normalFont);
		        choice3.setFocusPainted(false);
		        choice3.addActionListener(choiceHandler);
		        choice3.setActionCommand("c3");
		        choiceButtonPanel.add(choice3);

		        choice4 = new JButton("Choice 4");
		        choice4.setBackground(Color.BLACK);
		        choice4.setForeground(Color.WHITE);
		        choice4.setFont(normalFont);
		        choice4.setFocusPainted(false);
		        choice4.addActionListener(choiceHandler);
		        choice4.setActionCommand("c4");
		        choiceButtonPanel.add(choice4);
		        
		        
		        mainTextPanel.setVisible(false);
		        choiceButtonPanel.setVisible(false);
				playerPanel.setVisible(false);
		        
		        window.setVisible(true);
		
	}

	
}
