package package01;

import java.util.Random;

import package02.Weapon_Blaster;

public class Story 
{
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	
	public Story(Game g, UI userInterface, VisibilityManager vManager )
	{
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup()
	{
		player.hp = 20;
		ui.hpLabel.setText("Hp: "+ player.hp);
		player.currentWeapon = new Weapon_Blaster();
		ui.weaponLabel.setText("Current Weapon: "+ player.currentWeapon.name);
		
	}
	
	public void selectPosition(String nextPosition)
	{
		switch(nextPosition)
		{
		case "dataFort":
			dataFort();
			break;
		case "exit":
			exit();
		case "encounterRobot":
			encounterRobot();
			break;
		case "encounterAI":
			encounterAI();
			break;
		case "encounterChest":
			encounterChest();
			break;
		
		
		}
	}
	
	public void entrance()
	{
		ui.mainTextArea.setText("You are at the entrance of the abandoned data fortress\n\n\t    Do you enter?");
		ui.choice1.setText("Enter data fortress");
		ui.choice2.setText("Leave");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "dataFort";
		game.nextPosition2 = "exit";
	}
	
	public void exit()
	{
		vm.showTitleScreen();
	}
	
	public void dataFort()
	{
		
		ui.mainTextArea.setText("You explore the abandoned data fortress");
		ui.choice1.setText(">>");
		ui.choice2.setText("Leave");
		game.nextPosition2 = "exit";
		ui.choice3.setText("");
		ui.choice4.setText("");
		continueExplore();
		
	}
	
	public void encounterRobot()
	{
		ui.mainTextArea.setText("You encounter a security AI\n\nWhat do you do?");
		ui.choice1.setText(">>");
		ui.choice2.setText("Leave");
		game.nextPosition2 = "exit";
		ui.choice3.setText("");
		ui.choice4.setText("");
		continueExplore();
	}
	
	
	public void encounterAI()
	{
		ui.mainTextArea.setText("You hear a disembodied voice say:\n\n\"Why are you here?\"\nContinue?");
		ui.choice1.setText(">>");
		ui.choice2.setText("Leave");
		game.nextPosition2 = "exit";
		ui.choice3.setText("");
		ui.choice4.setText("");
		continueExplore();
		
	}
	
	public void encounterChest()
	{
		ui.mainTextArea.setText("You found a chest filled with Etherium tokens");
		ui.choice1.setText(">>");
		ui.choice2.setText("Leave");
		game.nextPosition2 = "exit";
		ui.choice3.setText("");
		ui.choice4.setText("");
		continueExplore();
	}
	
	public void continueExplore()
	{
		int num;
		num = (int)(Math.random()*(3-1+1)+1);
		
		switch (num)
		{
		case 1:
			game.nextPosition1 = "encounterRobot";
			break;
		case 2:
			game.nextPosition1 = "encounterAI";
			break;
		case 3:
			game.nextPosition1 = "encounterChest";
			break;
			
		}
	}
}
