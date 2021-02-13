package package02;

public class Item_Token 
{
	int numOfToken;
	public Item_Token()
	{
		numOfToken =0;
	}
	public int getToken()
	{
		 numOfToken = (int)(Math.random()*((10-5)+1)+5);
		return numOfToken;
	}
}
