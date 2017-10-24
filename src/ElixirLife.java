import org.newdawn.slick.*;

public class ElixirLife extends ItemType {
	public static final int itemHP = 0;
	public static final int itemDamage = 0;
	public static final int itemCool = 0;
	String itemname = "ELixirofLife";
	
	public ElixirLife(float x, float y) 
			throws SlickException
			{
				super(x, y);
				this.itemName = itemname;
				itemPic = new Image("assets/items/elixir.png");
				this.giveHP = itemHP;
				this.increaseDamage = itemDamage;
				this.decreasecooldown = itemCool;
			
			}
	}
