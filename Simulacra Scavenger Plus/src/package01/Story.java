package package01;



import package02.Monster_SecurityAI;

import package02.Weapon_Blaster;


public class Story 
{
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	Monster_SecurityAI ai = new Monster_SecurityAI();
	Weapon_Blaster blaster = new Weapon_Blaster();
	
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
		case "fight":
			fight();
			break;
		case "shoot":
			shoot();
			break;
		case "enemyAttack":
			enemyAttack();
			break;
		case "title":
			vm.showTitleScreen();
			defaultSetup();
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
		ai.currentHealth = ai.maxHealth;
		ui.choice1.setText("Fight it");
		game.nextPosition1= "fight";
		ui.choice2.setText("Leave");
		game.nextPosition2 = "exit";
		ui.choice3.setText("");
		ui.choice4.setText("");
		//continueExplore();
	}
	
	public void fight()
	{
		
		ui.mainTextArea.setText(""+ai.getName()+"'s health: "+ ai.getHealth());
		ui.choice1.setText("Shoot");
		game.nextPosition1 = "shoot";
		ui.choice2.setText("Leave");
		game.nextPosition2 = "exit";
		ui.choice3.setText("");
		ui.choice4.setText("");
		
	}
	
	public void shoot()//deal damage to ai
	{
		if(ai.currentHealth>0)
		{
			int blasterDamage = blaster.getDamage();
			ai.currentHealth -= blasterDamage;
			ui.mainTextArea.setText(""+ai.getName()+"'s health: "+ ai.getHealth()+"\n"
					+ "You shot the Ai for "+ blasterDamage+" damage");
			ui.choice1.setText(">>");
			game.nextPosition1 = "enemyAttack";
		}
		if (ai.currentHealth<=0) 
		{
			ui.mainTextArea.setText(""+ai.getName()+"'s health: "+ ai.getHealth()+"\n"
					+ "You Win");
			ui.choice1.setText(">>");
			continueExplore();
		}
	}
		
		
	public void enemyAttack()
	{
		
		if(ai.currentHealth>0)
		{
			int enemyDamage = ai.getDamage();
			player.hp -= enemyDamage;
			ui.hpLabel.setText("Hp: "+ player.hp);
			ui.mainTextArea.setText(""+ai.getName()+"'s health: "+ ai.getHealth()+"\n"
					+ "The AI zapped you for "+ enemyDamage+" damage");
			ui.choice1.setText("Shoot");
			game.nextPosition1 = "shoot";
			
		}
		
		if(player.hp<=0)
		{
			ui.mainTextArea.setText("You Died");
			ui.choice1.setText("Restart");
			game.nextPosition1= "title";
		}
		
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
