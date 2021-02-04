package package02;



public class Weapon_Blaster extends SuperWeapon {
	public Weapon_Blaster()
	{
		name = "Blaster";
		damage = 3;
	}
	
	public int getDamage()
	{
		damage = (int)(Math.random()*((10-5)+1)+5);
		return damage;
	}

}
