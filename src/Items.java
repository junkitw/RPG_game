import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public abstract class Items {
	protected Vector2f item;
	protected float itemX;
	protected float itemY;
	protected int giveHP;
	protected int increaseDamage;
	protected int decreasecooldown;
	public String itemName;
	Image itemPic;
	
	public Items(float x, float y) {
		/* assigns the position as a vector */
		item = new Vector2f(x, y);
	}	
	
	public void render(Graphics g, Camera camera) {
		itemX = item.x;
		itemY = item.y;
		itemPic.drawCentered(itemX, itemY);
	}
	/** Getter method to obtain the x-coordinate. */
	public float getXCoord() {
		return itemX;
	}
	
	/** Getter method to obtain the y-coordinate. */
	public float getYCoord() {
		return itemY;
	}
	
	/** Getter method within Vector2f of Slick to obtain the vector position. */
	public float getItemtDistance(Player player) {
		return item.distance(player.getPlayerPos());
	}
	
	public abstract void update(World world, Player player);
}
