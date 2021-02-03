package package01;

public class VisibilityManager 
{
	UI ui;
	public VisibilityManager(UI userInterface)
	{
		ui = userInterface;
	}
	
	public void showTitleScreen()
	{
		ui.titleNameLabel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		ui.rainLabel.setVisible(true);
		
		//hide Game Screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
	}
	
	public void showGameScreen()
	{
		ui.titleNameLabel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.rainLabel.setVisible(false);
		
		//hide Game Screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		
	}
}
