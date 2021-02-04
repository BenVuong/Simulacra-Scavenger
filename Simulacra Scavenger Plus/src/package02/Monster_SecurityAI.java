package package02;

public class Monster_SecurityAI
{
	public String name = "Security AI";
	public int damage;
	public int  maxHealth = 30, currentHealth = 30;
	public int getDamage()
	{
		damage = (int)(Math.random()*((10-5)+1)+5);
		return damage;
	}
	public void resetHealth(int maxHealth )
	{
		currentHealth = maxHealth;
	}
	public int getHealth()
	{
		return currentHealth;
	}
	public String getName()
	{
		return name;
	}
}
