import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;


public abstract class Unit {
	protected float screenX; // x-coordinate
	protected float screenY; // y-coordinate
	protected Vector2f unit;
	protected String charName;
	protected double maxHP; 
	protected double unitCurrHP;
	protected int damageDeal;
	protected int cooldown;
	protected int cooldownTimer = 0;
	protected String text;
	protected int chat; // time for dialogue to be displayed
	public static final int deltaVal = 1000;
	Image units;
	
	public Unit(float x, float y) {
		unit = new Vector2f(x, y);
	}
	
	/** Setter method to obtain the unit name. */
	protected void setName(String name) {
		this.charName = name;
	}
	
	public void render(Graphics g, Camera camera) {
		screenX = unit.x;
		screenY = unit.y;
		units.drawCentered(screenX, screenY);
	}
	
	
	/** renders the dialogue */
	public void dialogueRender(Graphics g, Camera camera) {
			Color back = new Color(1.0f, 1.0f, 1.0f);          // White
		    Color font = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
		    int bar_width = g.getFont().getWidth(text)+20;
		    int bar_height = 25;
		    g.setColor(font);
			g.drawString(this.text, (float)unit.x-bar_width/2+3, (float)unit.y - 100);
		    g.setColor(back);
		    g.fillRect((float)unit.x - bar_width/2, (float)unit.y - 100, bar_width, bar_height);
	
	}

	public abstract void update(int delta, World world, boolean attacked, Player player, boolean combat);
	
	/** render the health bar for every unit*/
	public void renderHealthBar(Graphics g, Camera camera) {
		Color hpBAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);
		Color hpBAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);
		Color VALUE = new Color(1.0f, 1.0f, 1.0f);   
		float text_x, text_y;
		double health_percent;
		float bar_x, bar_y;
		int bar_width, bar_height;
		int hp_bar_width;
		bar_x = screenX - 50;
		bar_y = screenY - 40;
		bar_width = 90;
	    bar_height = 20;
	    text_x = screenX  - 30;
		text_y = screenY - 40;
	    health_percent = (double)(this.unitCurrHP/maxHP);                        
        hp_bar_width = (int) (bar_width * health_percent);
        g.setColor(hpBAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(hpBAR);
	    g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString("" + charName, text_x, text_y);
		
	}
	/** Getter method to obtain the x-coordinate. */
	public float getXCoord() {
		return screenX;
	}
	
	/** Getter method to obtain the y-coordinate. */
	public float getYCoord() {
		return screenY;
	}
	
	/** Getter method to obtain the distance between player and unit. */
	public float getUnitDistance(Player player) {
		return unit.distance(player.getPlayerPos());
	}
	
	/** Getter method to obtain the updated cooldown. */
	public int getUnitRate() {
		return cooldownTimer;
	}
	
	/** Getter method to obtain the damage. */
	public int getUnitDam() {
		return this.damageDeal;
	}
	
	
}
