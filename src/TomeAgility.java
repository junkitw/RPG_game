import org.newdawn.slick.*;

public class TomeAgility extends ItemType {
	public static final int itemHP = 0;
	public static final int itemDamage = 0;
	public static final int itemCool = -300;
	String itemname = "TomeofAgility";

	public TomeAgility(float x, float y) 
			throws SlickException
			{
				super(x, y);
				this.itemName = itemname;
				itemPic = new Image("assets/items/tome.png");
				this.giveHP = itemHP;
				this.increaseDamage = itemDamage;
				this.decreasecooldown = itemCool;
			
			}
}
