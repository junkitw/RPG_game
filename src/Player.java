import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Player {
	private Image playerPic;
	private boolean face_direction;
	private Image flipped;
	private Image panel;
	public Vector2f playerVector;
	public int playermaxHP = 100;
	public int playerCurrHP = 100;
	public int playercool = 600;
	public int playerdamage = 26;
	public int cooldownTimer = 0;
	public double monsterdealt; // random factor generator
	/** Player object to take in x-coordinate and y-coordinate. 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @throws SlickException
	 */
	public Player(int x, int y) 
	throws SlickException
	{
		playerVector = new Vector2f(x, y);
		// the location of the image of the player to be rendered
		playerPic = new Image("assets/units/player.png");
		flipped = playerPic.getFlippedCopy(true, false);
		panel = new Image("assets/panel.png");
	}
	
	/** To draw the player
	 * @param g The Slick graphics object, used for drawing.
	 * @throws SlickException
	 */
	public void render(Graphics g, Camera cam) {
		Image map_image;
		/* the position of the player to always be rendered in the middle
		 * of the screen which is why screenwidth and screenheight is to be 
		 * divided by two */
		map_image = this.face_direction ? this.flipped : this.playerPic;
		map_image.drawCentered((int)playerVector.x, (int)playerVector.y);
	}
	
	/** Takes in arguments for movement, speed, and world for the terrain blocking
	 *  in the update method 
	 * @param dirX	Movement of player on x-axis.
	 * @param dirY	Movement of player on y-axis.
	 * @param delta	Time passed since last frame (milliseconds).
	 * @param world	world object to be passed in to this update method.
	 * @param inventory to check with villagers
	 * @param attackComm to attack monsters
	 * @param assault to check if monsters are within range to attack player
	 * @throws SlickException
	 */
	public void update(double dirX , double dirY, int delta, World world, ArrayList<Items> inventory, boolean attackComm, boolean assault) 
	{	
		ArrayList<ActiveMonster> creepies = world.getMonsters();
		
		/** when cooldown reaches 0, it resets when player attacks*/
		if ((playercool <= 0) && (attackComm)) {
			cooldownTimer = playercool;
		}
		/** decreases cooldown*/
		if ((cooldownTimer > 0)) {
			cooldownTimer -= delta/2;
		}
		
		if (dirX < 0) {
			this.face_direction = true;
		}
		else {
			this.face_direction = false;
		}
		playerVector.x += dirX*0.25*delta;
		playerVector.y += dirY*0.25*delta;
		
		playerVector.x = playerVector.x + World.tilewidth > World.whole_game ? playerVector.x = World.whole_game - World.tilewidth : playerVector.x;
		playerVector.y = playerVector.y + World.tilewidth > World.whole_game ? playerVector.y = World.whole_game - World.tilewidth : playerVector.y;
		
		monsterdealt = Math.random();
			for (int i=0; i<creepies.size(); i++) {
				if ((creepies.get(i).cooldownTimer == 0) && (assault)) {
					playerCurrHP -= (monsterdealt*creepies.get(i).getUnitDam());
					creepies.get(i).cooldownTimer = creepies.get(i).cooldown;
				}
		}
		
		if (world.detect_terrain(playerVector.x, playerVector.y))  {	// restricts movement when identify terrain
			playerVector.x -= dirX*0.25*delta;
			playerVector.y -= dirY*0.25*delta;
		}

		}
	
	/** Getter method to obtain the panel image loaded. */
	public Image getPanel() {
		return panel;
	}
	
	/** Getter method to obtain the maxHP. */
	public int getHP() {
		return playermaxHP;
	}
	
	/** Getter method to obtain the vector position. */
	public Vector2f getPlayerPos() {
		return playerVector;
	}
	
	/** Getter method to obtain the updated HP of player. */
	public int getCURRHP() {
		return playerCurrHP;
	}
	
	/** Getter method to obtain the player damage. */
	public int getCurrDam() {
		return playerdamage;
	}
	
	/** Getter method to obtain the player's updated cooldown. */
	public int getCurrRate() {
		return cooldownTimer;
	}
	
}