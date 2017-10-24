import org.newdawn.slick.*;

public class SwordStrength extends ItemType {
	public static final int itemHP = 0;
	public static final int itemDamage = 30;
	public static final int itemCool = 0;
	String itemname = "SwordofStrength";
	
	public SwordStrength(float x, float y) 
			throws SlickException
			{
				super(x, y);
				this.itemName = itemname;
				itemPic = new Image("assets/items/sword.png");
				this.giveHP = itemHP;
				this.increaseDamage = itemDamage;
				this.decreasecooldown = itemCool;
			
			}


}
