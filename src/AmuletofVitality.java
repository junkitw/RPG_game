import org.newdawn.slick.*;

public class AmuletofVitality extends ItemType {
	public static final int itemHP = 80;
	public static final int itemDamage = 0;
	public static final int itemCool = 0;
	String itemname = "AmuletofVitality";
	public AmuletofVitality(float x, float y) 
			throws SlickException
			{
				super(x, y);
				this.itemName = itemname;
				itemPic = new Image("assets/items/amulet.png");
				this.giveHP = itemHP;
				this.increaseDamage = itemDamage;
				this.decreasecooldown = itemCool;
			}
			
}
